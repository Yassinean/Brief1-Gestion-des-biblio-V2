package org.example.persistance.Implementation.userImp;

import org.example.config.DbConfig;
import org.example.metier.Etudiant;
import org.example.metier.Abstract.Utilisateur;
import org.example.persistance.Interface.UtilisateurDaoInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
                     "INSERT INTO etudiant (name, email,branche) VALUES ( ?, ?, ?)")) {
            stmt.setString(1,user.getName());
            stmt.setString(2,user.getEmail());
            stmt.setString(3, ((Etudiant) user).getBranche());
            stmt.executeUpdate();
            System.out.println("L'étudiant a été ajouté avec succès");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateUtilisateur(Utilisateur utilisateur) {
        if(!(utilisateur instanceof Etudiant)){
            throw new IllegalArgumentException("User must be of type Etudiant");
        }

        Etudiant etudiant = (Etudiant) utilisateur;
        String sql = "UPDATE etudiant SET name = ?, email = ?, branche = ? WHERE id = ?";

        try(PreparedStatement pstmt = connection.prepareStatement(sql)){
            pstmt.setInt(1,etudiant.getId());
            pstmt.setString(2,etudiant.getName());
            pstmt.setString(3,etudiant.getEmail());
            pstmt.setString(4,etudiant.getBranche());
            pstmt.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void deleteUtilisateur(Integer id) {
        boolean isDeleted = false;
        String query = "DELETE FROM etudiant WHERE id = ?";
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
    public List<Utilisateur> getAllUtilisateurs() {
        List<Utilisateur> etudiants = new ArrayList<>();
        String sql = "SELECT * FROM etudiant";

        try(PreparedStatement pstmt = connection.prepareStatement(sql)){
            ResultSet res = pstmt.executeQuery();
            if(res.next()){
                Etudiant etudiant = new Etudiant(
                        res.getString("name"),
                        res.getString("email"),
                        res.getString("branche")
                );
                etudiants.add(etudiant);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return etudiants;
    }
}

