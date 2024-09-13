package org.yassine.persistance.Implementation.documentImp;

import org.yassine.config.DbConfig;
import org.yassine.metier.JournalScientifique;
import org.yassine.persistance.Interface.Document.JournalScientifiqueDaoInterface;

import java.sql.*;
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

        String sql = "INSERT INTO journalscientifique (titre, auteur, datePublication, nombreDePage, domainerecherche) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, js.getTitre());
            statement.setString(2, js.getAuteur());
            statement.setString(3, js.getDatePublication());
            statement.setInt(4, js.getNombreDePages());
            statement.setString(5, js.getDomaine());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
    }

    @Override
    public void updateJournalScientifique(JournalScientifique js) {

        String sql = "UPDATE journalscientifique SET titre = ?, auteur = ?, datePublication = ?, nombreDePage = ?, domainerecherche = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, js.getTitre());
            statement.setString(2, js.getAuteur());
            statement.setString(3,js.getDatePublication());
            statement.setInt(4, js.getNombreDePages());
            statement.setString(5, js.getDomaine());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
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

    @Override
    public JournalScientifique displayJournalScientifique(Integer jsId) {
        List<JournalScientifique> js = new ArrayList<>();
        String sql = "SELECT * FROM journalscientifique WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, jsId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Titre: " + resultSet.getString("titre"));
                System.out.println("Auteur: " + resultSet.getString("auteur"));
                System.out.println("Date de publication: " + resultSet.getString("datePublication"));
                System.out.println("Nombre de pages: " + resultSet.getInt("nombreDePage"));
                System.out.println("Domaine: " + resultSet.getString("domainerecherche"));
                return new JournalScientifique(
                        resultSet.getString("titre"),
                        resultSet.getString("auteur"),
                        resultSet.getString("datePublication"),
                        resultSet.getInt("nombredepage"),
                        resultSet.getString("domaine")
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<JournalScientifique> displayAllJournalScientifiques() {
        List<JournalScientifique> journals = new ArrayList<>();
        String sql = "SELECT * FROM journalscientifique";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                JournalScientifique js = new JournalScientifique(
                        resultSet.getString("titre"),
                        resultSet.getString("auteur"),
                        resultSet.getString("datePublication"),
                        resultSet.getInt("nombreDePage"),
                        resultSet.getString("domainerechecher")
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
                JournalScientifique js = new JournalScientifique(
                        resultSet.getString("titre"),
                        resultSet.getString("auteur"),
                        resultSet.getString("datePublication"),
                        resultSet.getInt("nombreDePage"),
                        resultSet.getString("domainerecherche")
                );
                journals.add(js);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return journals;
    }

}