package org.example.persistance.Implementation.documentImp;

import org.example.config.DbConfig;
import org.example.metier.Abstract.Document;
import org.example.metier.JournalScientifique;
import org.example.persistance.Interface.DocumentDaoInterface;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JournalScientifiqueDaoImp implements DocumentDaoInterface {

    private Connection connection;

    public JournalScientifiqueDaoImp() {
        try {
            this.connection = DbConfig.getInstance().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createDocument(Document document) {
        JournalScientifique js = (JournalScientifique) document;
        String sql = "INSERT INTO journalscientifique (titre, auteur, datePublication, nombreDePages, domainerecherche) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, js.getTitre());
            statement.setString(2, js.getAuteur());
            statement.setDate(3, Date.valueOf(js.getDatePublication()));
            statement.setInt(4, js.getNombreDePages());
            statement.setString(5, js.getDomaine());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
    }

    @Override
    public void updateDocument(Document document) {
        JournalScientifique js = (JournalScientifique) document;
        String sql = "UPDATE journalscientifique SET titre = ?, auteur = ?, datePublication = ?, nombreDePages = ?, domainerecherche = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, js.getTitre());
            statement.setString(2, js.getAuteur());
            statement.setDate(3, Date.valueOf(js.getDatePublication()));
            statement.setInt(4, js.getNombreDePages());
            statement.setString(5, js.getDomaine());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteDocument(Integer jsId) {
        String sql = "DELETE FROM journalscientifique WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, jsId);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }

    }

    @Override
    public void displayDocument(Integer jsId) {
        String sql = "SELECT * FROM journalscientifique WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, jsId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Titre: " + resultSet.getString("titre"));
                System.out.println("Auteur: " + resultSet.getString("auteur"));
                System.out.println("Date de publication: " + resultSet.getDate("datePublication").toLocalDate());
                System.out.println("Nombre de pages: " + resultSet.getInt("nombreDePages"));
                System.out.println("Domaine: " + resultSet.getString("domainerecherche"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public List<Document> displayAllDocuments() {
        List<Document> journals = new ArrayList<>();
        String sql = "SELECT * FROM journalscientifique";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                JournalScientifique js = new JournalScientifique(
                        resultSet.getString("titre"),
                        resultSet.getString("auteur"),
                        resultSet.getDate("datePublication").toLocalDate(),
                        resultSet.getInt("nombreDePages"),
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
    public List<Document> searchDocument(String titre) {
        List<Document> journals = new ArrayList<>();
        String sql = "SELECT * FROM journalscientifique WHERE titre LIKE ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            String searchPattern = "%" + titre + "%";
            statement.setString(1, searchPattern);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                JournalScientifique js = new JournalScientifique(
                        resultSet.getString("titre"),
                        resultSet.getString("auteur"),
                        resultSet.getDate("datePublication").toLocalDate(),
                        resultSet.getInt("nombreDePages"),
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