package org.yassine.persistance.Implementation.userImp;

import org.yassine.config.DbConfig;
import org.yassine.metier.Etudiant;
import org.yassine.persistance.Interface.Utilisateur.EtudiantDaoInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EtudiantDaoImp implements EtudiantDaoInterface {

    private static final Logger logger = Logger.getLogger(EtudiantDaoImp.class.getName());
    private final Connection connection;

    public EtudiantDaoImp() throws SQLException {
        try {
            this.connection = DbConfig.getInstance().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createEtudiant(Etudiant etudiant) {
        String sql = "INSERT INTO etudiant (name, email, branche) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, etudiant.getName());
            stmt.setString(2, etudiant.getEmail());
            stmt.setString(3, etudiant.getBranche());
            stmt.executeUpdate();
            logger.info("L'étudiant a été ajouté avec succès");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erreur lors de l'ajout de l'étudiant", e);
        }
    }

    @Override
    public void updateEtudiant(Integer id, Etudiant etudiant) {
        String sql = "UPDATE etudiant SET name = ?, email = ?, branche = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, etudiant.getName());
            pstmt.setString(2, etudiant.getEmail());
            pstmt.setString(3, etudiant.getBranche());
            pstmt.setInt(4, id);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                logger.info("Etudiant with ID " + id + " updated successfully.");
            } else {
                logger.warning("No student found with ID: " + id);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error updating student with ID: " + id, e);
        }
    }


    @Override
    public void deleteEtudiant(Integer id) {
        String query = "DELETE FROM etudiant WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            int affectedRows = statement.executeUpdate();
            if (affectedRows > 0) {
                logger.info("Etudiant supprimé avec succès.");
            } else {
                logger.warning("Aucun étudiant trouvé avec l'ID : " + id);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erreur lors de la suppression de l'étudiant", e);
        }
    }

    @Override
    public Etudiant getEtudiantById(Integer userId) {
        Etudiant etudiant = null;
        String sql = "SELECT * FROM etudiant WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            try (ResultSet res = pstmt.executeQuery()) {
                if (res.next()) {
                    etudiant = new Etudiant(
                            res.getString("name"),
                            res.getString("email"),
                            res.getString("branche")
                    );
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erreur lors de la récupération de l'étudiant par ID", e);
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
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Etudiant etudiant = new Etudiant(
                            resultSet.getString("name"),
                            resultSet.getString("email"),
                            resultSet.getString("branche")
                    );
                    etudiants.add(etudiant);
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erreur lors de la récupération des étudiants par nom", e);
        }
        return etudiants;
    }

    @Override
    public List<Etudiant> getAllEtudiants() {
        List<Etudiant> etudiants = new ArrayList<>();
        String sql = "SELECT * FROM etudiant";
        try (PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet res = pstmt.executeQuery()) {
            while (res.next()) {
                Etudiant etudiant = new Etudiant(
                        res.getString("name"),
                        res.getString("email"),
                        res.getString("branche")
                );
                etudiants.add(etudiant);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erreur lors de la récupération de tous les étudiants", e);
        }
        return etudiants;
    }
}
