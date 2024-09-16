package org.yassine.persistance.Implementation.documentImp;

import org.yassine.config.DbConfig;
import org.yassine.metier.Abstract.DroitAccess;
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
    public void updateJournalScientifique(JournalScientifique js) {
        String sql = "UPDATE journalscientifique SET titre = ?, auteur = ?, datePublication = ?, nombreDePage = ?, domainerecherche = ?, acces = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, js.getTitre());
            statement.setString(2, js.getAuteur());
            statement.setDate(3, Date.valueOf(js.getDatePublication()));
            statement.setInt(4, js.getNombreDePages());
            statement.setString(5, js.getDomaine());
            statement.setString(6, js.getDroitAcces().name());
            statement.setInt(7, js.getId());
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
        String sql = "SELECT * FROM journalscientifique WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, jsId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                DroitAccess droitAcces = DroitAccess.valueOf(resultSet.getString("acces"));
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Titre: " + resultSet.getString("titre"));
                System.out.println("Auteur: " + resultSet.getString("auteur"));
                System.out.println("Date de publication: " + resultSet.getString("datePublication"));
                System.out.println("Nombre de pages: " + resultSet.getInt("nombreDePage"));
                System.out.println("Domaine: " + resultSet.getString("domainerecherche"));
                System.out.println("Accessibility: " + resultSet.getString("acces"));
                return new JournalScientifique(
                        resultSet.getString("titre"),
                        resultSet.getString("auteur"),
                        resultSet.getDate("datePublication").toLocalDate(),
                        resultSet.getInt("nombreDePage"),
                        resultSet.getString("domainerecherche"),
                        droitAcces
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