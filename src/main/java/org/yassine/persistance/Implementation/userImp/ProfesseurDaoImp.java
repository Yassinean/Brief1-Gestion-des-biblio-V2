package org.yassine.persistance.Implementation.userImp;

import org.yassine.config.DbConfig;
import org.yassine.metier.Etudiant;
import org.yassine.metier.Livre;
import org.yassine.metier.Professeur;
import org.yassine.persistance.Interface.Utilisateur.ProfesseurDaoInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfesseurDaoImp implements ProfesseurDaoInterface {


    private final Connection connection;

    public ProfesseurDaoImp() throws SQLException {
        try {
            this.connection = DbConfig.getInstance().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void createProfesseur(Professeur professeur) {
        if (!(professeur instanceof Professeur)) {
            throw new IllegalArgumentException("User must be of type Professeur");
        }
//        Professeur professeur = (Professeur) professeur;
        try (Connection connection = DbConfig.getInstance().getConnection();
             PreparedStatement stmt = connection.prepareStatement(
                     "INSERT INTO professeur (name, email) VALUES ( ?, ?)")) {
            stmt.setString(1, professeur.getName());
            stmt.setString(2, professeur.getEmail());
            stmt.executeUpdate();
            System.out.println("Le professeur a été ajouté avec succès");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateProfesseur(Integer id, Professeur professeur) {
        if (!(professeur instanceof Professeur)) {
            throw new IllegalArgumentException("User must be of type Professeur");
        }

        String sql = "UPDATE professeur SET name = ?, email = ?, matiere = ? WHERE id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, professeur.getName());
            pstmt.setString(2, professeur.getEmail());
            pstmt.setString(4, professeur.getMatiere());
            pstmt.setInt(5, professeur.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteProfesseur(Integer id) {
        boolean isDeleted = false;
        String query = "DELETE FROM professeur WHERE id = ?";
        try (Connection connection = DbConfig.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            isDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Professeur getProfesseurById(Integer professeurId) {
        Professeur professeur = null;
        String sql = "SELECT * FROM professeur WHERE id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, professeurId);
            ResultSet res = pstmt.executeQuery();
            if (res.next()) {
                professeur = new Professeur(
                        res.getString("name"),
                        res.getString("email"),
                        res.getString("matiere")
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return professeur;
    }

    @Override
    public List<Professeur> getProfesseurByName(String name) {
        List<Professeur> professeurs = new ArrayList<>();
        String sql = "SELECT * FROM professeur WHERE name LIKE ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            String searchPattern = "%" + name + "%";
            statement.setString(1, searchPattern);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Professeur professeur = new Professeur(
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("matiere")
                );
                professeurs.add(professeur);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return professeurs;

    }

    @Override
    public List<Professeur> getAllProfesseurs() {
        List<Professeur> professeurs = new ArrayList<>();
        String sql = "SELECT * FROM professeur";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            ResultSet res = pstmt.executeQuery();
            if (res.next()) {
                Professeur professeur = new Professeur(
                        res.getString("name"),
                        res.getString("email"),
                        res.getString("matiere")
                );
                professeurs.add(professeur);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return professeurs;

    }
}

