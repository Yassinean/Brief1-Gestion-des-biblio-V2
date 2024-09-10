package org.example.persistance.Implementation;

import org.example.config.DbConfig;
import org.example.metier.Etudiant;
import org.example.metier.Utilisateur;
import org.example.persistance.Interface.UtilisateurDaoInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EtudiantDaoImp implements UtilisateurDaoInterface {


    private final Connection connection;

    public EtudiantDaoImp() throws SQLException {
        try{
            this.connection = DbConfig.getInstance().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void createUtilisateur(Utilisateur user) {
        if(!(user instanceof Etudiant)){
            throw new IllegalArgumentException("User must be of type Etudiant");
        }
        Etudiant etudiant = (Etudiant) user;
        try (Connection connection = DbConfig.getInstance().getConnection();
             PreparedStatement stmt = connection.prepareStatement(
                     "INSERT INTO etudiant (id, name, email) VALUES (CAST(? AS UUID), ?, ?)")) {
            stmt.setInt(1, user.getId());
            stmt.setString(2,user.getName());
            stmt.setString(3, user.getEmail());
            stmt.executeUpdate();
            System.out.println("L'étudiant a été ajouté avec succès");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateUtilisateur() {

    }

    @Override
    public void deleteUtilisateur(Integer id) {
        boolean isDeleted = false;
        String query = "DELETE FROM utilisateur WHERE id = ?";
        try (Connection connection = DbConfig.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            isDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Utilisateur getUtilisateur(Integer userId) {
        Etudiant etudiant = null;
        String sql = "SELECT * FROM etudiant WHERE id = ?";

        try(PreparedStatement pstmt = connection.prepareStatement(sql)){
            pstmt.setInt(1,userId);
            ResultSet res = pstmt.executeQuery();
            if(res.next()){
                etudiant = new Etudiant(
                        res.getInt("id"),
                        res.getString("name"),
                        res.getString("email"),
                        res.getString("branche")
                );
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return etudiant;
    }

    @Override
    public void getAllUtilisateurs() {

    }
}

