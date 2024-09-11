package org.example.persistance.Implementation.documentImp;

import org.example.config.DbConfig;
import org.example.metier.Abstract.Document;
import org.example.metier.JournalScientifique;
import org.example.metier.TheseUniversitaire;
import org.example.persistance.Interface.DocumentDaoInterface;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TheseUniversitaireDaoImp implements DocumentDaoInterface {

    private Connection connection;

    public TheseUniversitaireDaoImp() {
        try {
            this.connection = DbConfig.getInstance().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createDocument(Document document) {
        TheseUniversitaire theseUniversitaire = (TheseUniversitaire) document;
        String sql = "INSERT INTO theseuniversitaire (titre, auteur, datePublication, nombreDePages, universite, domaine) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, theseUniversitaire.getTitre());
            statement.setString(2, theseUniversitaire.getAuteur());
            statement.setDate(3, Date.valueOf(theseUniversitaire.getDatePublication()));
            statement.setInt(4, theseUniversitaire.getNombreDePages());
            statement.setString(5, theseUniversitaire.getUniversite());
            statement.setString(6, theseUniversitaire.getDomaine());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
    }

    @Override
    public void updateDocument(Document document) {
        TheseUniversitaire theseUniversitaire = (TheseUniversitaire) document;
        String sql = "UPDATE theseuniversitaire SET titre = ?, auteur = ?, datePublication = ?, nombreDePages = ?, universite = ?, domaine = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, theseUniversitaire.getTitre());
            statement.setString(2, theseUniversitaire.getAuteur());
            statement.setDate(3, Date.valueOf(theseUniversitaire.getDatePublication()));
            statement.setInt(4, theseUniversitaire.getNombreDePages());
            statement.setString(5, theseUniversitaire.getUniversite());
            statement.setString(6, theseUniversitaire.getDomaine());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteDocument(Integer jsId) {
        String sql = "DELETE FROM theseuniversitaire WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, jsId);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }

    }

    @Override
    public void displayDocument(Integer theseUId) {
        String sql = "SELECT * FROM theseuniversitaire WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, theseUId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Titre: " + resultSet.getString("titre"));
                System.out.println("Auteur: " + resultSet.getString("auteur"));
                System.out.println("Date de publication: " + resultSet.getDate("datePublication").toLocalDate());
                System.out.println("Nombre de pages: " + resultSet.getInt("nombreDePages"));
                System.out.println("University: " + resultSet.getString("universite"));
                System.out.println("Domaine: " + resultSet.getString("domaine"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public List<Document> displayAllDocuments() {
        List<Document> journals = new ArrayList<>();
        String sql = "SELECT * FROM theseuniversitaire";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                TheseUniversitaire js = new TheseUniversitaire(
                        resultSet.getString("titre"),
                        resultSet.getString("auteur"),
                        resultSet.getDate("datePublication").toLocalDate(),
                        resultSet.getInt("nombreDePages"),
                        resultSet.getBoolean("isEmprunted"),
                        resultSet.getBoolean("isReserved"),
                        resultSet.getString("universite"),
                        resultSet.getString("domaine")
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
        List<Document> theseUniversitaire = new ArrayList<>();
        String sql = "SELECT * FROM theseuniversitaire WHERE titre LIKE ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            String searchPattern = "%" + titre + "%";
            statement.setString(1, searchPattern);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                TheseUniversitaire theseU = new TheseUniversitaire(
                        resultSet.getString("titre"),
                        resultSet.getString("auteur"),
                        resultSet.getDate("datePublication").toLocalDate(),
                        resultSet.getInt("nombreDePages"),
                        resultSet.getBoolean("isEmprunted"),
                        resultSet.getBoolean("isReserved"),
                        resultSet.getString("universite"),
                        resultSet.getString("domaine")
                );
                theseUniversitaire.add(theseU);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return theseUniversitaire;
    }

}