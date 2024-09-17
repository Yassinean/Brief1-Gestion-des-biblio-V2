package org.yassine.DAO.Implementation.documentImp;

import org.yassine.config.DbConfig;
import org.yassine.model.Abstract.DroitAccess;
import org.yassine.model.JournalScientifique;
import org.yassine.DAO.Interface.Document.JournalScientifiqueDaoInterface;
import org.yassine.model.Magazine;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JournalScientifiqueDaoImp implements JournalScientifiqueDaoInterface {

    private Connection connection;

    public JournalScientifiqueDaoImp() {
        try {
            this.connection = DbConfig.getInstance().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createJournalScientifique(JournalScientifique js) {
        String sql = "INSERT INTO journalscientifique (titre, auteur, datePublication, nombreDePage, domainerecherche, acces) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, js.getTitre());
            statement.setString(2, js.getAuteur());
            statement.setDate(3, Date.valueOf(js.getDatePublication()));
            statement.setInt(4, js.getNombreDePages());
            statement.setString(5, js.getDomaine());
            statement.setString(6, js.getDroitAcces().name());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateJournalScientifique(Integer id ,JournalScientifique js) {
        String sql = "UPDATE journalscientifique SET titre = ?, auteur = ?, datePublication = ?, nombreDePage = ?, domainerecherche = ?, acces = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, js.getTitre());
            statement.setString(2, js.getAuteur());
            statement.setDate(3, Date.valueOf(js.getDatePublication()));
            statement.setInt(4, js.getNombreDePages());
            statement.setString(5, js.getDomaine());
            statement.setString(6, js.getDroitAcces().name());
            statement.setInt(7, id);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Journal scientifique mis à jour avec succès.");
            } else {
                System.out.println("Aucun journal scientifique trouvé avec l'ID fourni.");
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la mise à jour du journal scientifique : " + e.getMessage());
        }
    }

    @Override
    public void deleteJournalScientifique(Integer jsId) {
        String sql = "DELETE FROM journalscientifique WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, jsId);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public JournalScientifique displayJournalScientifique(Integer jsId) {
        String sql = "SELECT * FROM journalscientifique WHERE id = ?";
        JournalScientifique journal = null;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, jsId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                String titre = resultSet.getString("titre");
                String auteur = resultSet.getString("auteur");
                LocalDate datePublication = resultSet.getDate("datePublication").toLocalDate();
                int nombreDePage = resultSet.getInt("nombredepage");
                String domaine = resultSet.getString("domainerecherche");
                DroitAccess droitAcces = DroitAccess.valueOf(resultSet.getString("acces"));


                System.out.println("ID: " + jsId);
                System.out.println("Titre: " + titre);
                System.out.println("Auteur: " + auteur);
                System.out.println("Date de publication: " + datePublication);
                System.out.println("Nombre de pages: " + nombreDePage);
                System.out.println("Domaine: " + domaine);
                System.out.println("Accessibility: " + droitAcces);

                journal = new JournalScientifique(
                        titre,
                        auteur,
                        datePublication,
                        nombreDePage,
                        domaine,
                        droitAcces
                );
            }
        } catch (SQLException e) {
            System.out.println("Error fetching journal by id: " + e.getMessage());
        }

        return journal;
    }

    @Override
    public List<JournalScientifique> displayAllJournalScientifiques() {
        List<JournalScientifique> journals = new ArrayList<>();
        String sql = "SELECT * FROM journalscientifique";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                DroitAccess droitAcces = DroitAccess.valueOf(resultSet.getString("acces"));
                JournalScientifique js = new JournalScientifique(
                        resultSet.getString("titre"),
                        resultSet.getString("auteur"),
                        resultSet.getDate("datePublication").toLocalDate(),
                        resultSet.getInt("nombreDePage"),
                        resultSet.getString("domainerecherche"),
                        droitAcces
                );
                journals.add(js);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return journals;
    }

    @Override
    public List<JournalScientifique> searchJournalScientifique(String titre) {
        List<JournalScientifique> journals = new ArrayList<>();
        String sql = "SELECT * FROM journalscientifique WHERE titre LIKE ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            String searchPattern = "%" + titre + "%";
            statement.setString(1, searchPattern);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                DroitAccess droitAcces = DroitAccess.valueOf(resultSet.getString("acces"));
                JournalScientifique js = new JournalScientifique(
                        resultSet.getString("titre"),
                        resultSet.getString("auteur"),
                        resultSet.getDate("datePublication").toLocalDate(),
                        resultSet.getInt("nombreDePage"),
                        resultSet.getString("domainerecherche"),
                        droitAcces
                );
                journals.add(js);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return journals;
    }
}