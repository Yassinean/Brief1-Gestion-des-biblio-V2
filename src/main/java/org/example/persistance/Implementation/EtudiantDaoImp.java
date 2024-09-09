package org.example.persistance.Implementation;

import org.example.config.DbConfig;
import org.example.metier.Utilisateur;
import org.example.persistance.Interface.UtilisateurDaoInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EtudiantDaoImp implements UtilisateurDaoInterface {


    private final Connection connection;

    public EtudiantDaoImp() throws SQLException {
        try{
            this.connection = DbConfig.getInstance().getConnection();
        }catch ()
    }


    @Override
    public void createUtilisateur(Utilisateur user) {
        try (Connection connection = DbConfig.getInstance().getConnection();
             PreparedStatement stmt = connection.prepareStatement(
                     "INSERT INTO etudiant (id, name, email) VALUES (CAST(? AS UUID), ?, ?)")) {
            stmt.setString(1, id);
            stmt.setString(2, name);
            stmt.setString(3, email);
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
    public boolean deleteUtilisateur(Integer id) {
        boolean isDeleted = false;
        String query = "DELETE FROM utilisateur WHERE id = ?";
        try (Connection connection = DbConfig.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            isDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isDeleted;
    }

    @Override
    public void getUtilisateur() {

    }

    @Override
    public void getAllUtilisateurs() {

    }
}

