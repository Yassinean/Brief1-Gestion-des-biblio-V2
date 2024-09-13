package org.yassine.persistance.Implementation.userImp;

import org.yassine.config.DbConfig;
import org.yassine.metier.Etudiant;
import org.yassine.metier.Livre;
import org.yassine.persistance.Interface.Utilisateur.EtudiantDaoInterface;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EtudiantDaoImp implements EtudiantDaoInterface {


    private final Connection connection;

    public EtudiantDaoImp() throws SQLException {
        try {
            this.connection = DbConfig.getInstance().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void createEtudiant(Etudiant user) {
        if (!(user instanceof Etudiant)) {
            throw new IllegalArgumentException("User must be of type Etudiant");
        }
        Etudiant etudiant = (Etudiant) user;
        try (Connection connection = DbConfig.getInstance().getConnection();
             PreparedStatement stmt = connection.prepareStatement(
                     "INSERT INTO etudiant (name, email,branche) VALUES ( ?, ?, ?)")) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, ((Etudiant) user).getBranche());
            stmt.executeUpdate();
            System.out.println("L'étudiant a été ajouté avec succès");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateEtudiant(Etudiant utilisateur) {
        if (!(utilisateur instanceof Etudiant)) {
            throw new IllegalArgumentException("User must be of type Etudiant");
        }

        Etudiant etudiant = (Etudiant) utilisateur;
        String sql = "UPDATE etudiant SET name = ?, email = ?, branche = ? WHERE id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, etudiant.getId());
            pstmt.setString(2, etudiant.getName());
            pstmt.setString(3, etudiant.getEmail());
            pstmt.setString(4, etudiant.getBranche());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void deleteEtudiant(Integer id) {
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
    public Etudiant getEtudiantById(Integer userId) {
        Etudiant etudiant = null;
        String sql = "SELECT * FROM etudiant WHERE id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            ResultSet res = pstmt.executeQuery();
            if (res.next()) {
                etudiant = new Etudiant(
                        res.getString("name"),
                        res.getString("email"),
                        res.getString("branche")
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return etudiant;
    }

    @Override
    public List<Etudiant> getEtudiantByName(String name) {

        List<Etudiant> etudiants = new ArrayList<>();
        String sql = "SELECT * FROM etudiant WHERE name LIKE ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            String searchPattern = "%" + name + "%";
            statement.setString(1, searchPattern);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Etudiant etudiant = new Etudiant(
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("branche")
                );
                etudiants.add(etudiant);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return etudiants;

    }

    @Override
    public List<Etudiant> getAllEtudiants() {
        List<Etudiant> etudiants = new ArrayList<>();
        String sql = "SELECT * FROM etudiant";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            ResultSet res = pstmt.executeQuery();
            if (res.next()) {
                Etudiant etudiant = new Etudiant(
                        res.getString("name"),
                        res.getString("email"),
                        res.getString("branche")
                );
                etudiants.add(etudiant);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return etudiants;
    }
}

