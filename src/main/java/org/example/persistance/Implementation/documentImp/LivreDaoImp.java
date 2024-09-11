package org.example.persistance.Implementation.documentImp;

import org.example.config.DbConfig;
import org.example.metier.Abstract.Document;
import org.example.metier.Livre;
import org.example.persistance.Interface.DocumentDaoInterface;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivreDaoImp implements DocumentDaoInterface {

    private Connection connection;

    public LivreDaoImp() {
        try {
            this.connection = DbConfig.getInstance().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createDocument(Document document) {
        Livre livre = (Livre) document;
        String sql = "INSERT INTO livre (titre, auteur, datePublication, nombreDePages, isbn) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, livre.getTitre());
            statement.setString(2, livre.getAuteur());
            statement.setDate(3, Date.valueOf(livre.getDatePublication()));
            statement.setInt(4, livre.getNombreDePages());
            statement.setString(5, livre.getIsbn());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
    }

    @Override
    public void updateDocument(Document document) {
        Livre livre = (Livre) document;
        String sql = "UPDATE livre SET titre = ?, auteur = ?, datePublication = ?, nombreDePages = ?, isbn = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, livre.getTitre());
            statement.setString(2, livre.getAuteur());
            statement.setDate(3, Date.valueOf(livre.getDatePublication()));
            statement.setInt(4, livre.getNombreDePages());
            statement.setString(5, livre.getIsbn());
            statement.setInt(6, livre.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteDocument(Integer livreId) {
        String sql = "DELETE FROM livre WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, livreId);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }

    }

    @Override
    public void displayDocument(Integer livreId) {
        String sql = "SELECT * FROM livre WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, livreId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Titre: " + resultSet.getString("titre"));
                System.out.println("Auteur: " + resultSet.getString("auteur"));
                System.out.println("Date de publication: " + resultSet.getDate("datePublication").toLocalDate());
                System.out.println("Nombre de pages: " + resultSet.getInt("nombreDePages"));
                System.out.println("ISBN: " + resultSet.getString("isbn"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public List<Document> displayAllDocuments() {
        List<Document> livres = new ArrayList<>();
        String sql = "SELECT * FROM livre";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                Livre livre = new Livre(
                        resultSet.getInt("id"),
                        resultSet.getString("titre"),
                        resultSet.getString("auteur"),
                        resultSet.getDate("datePublication").toLocalDate(),
                        resultSet.getInt("nombreDePages"),
                        resultSet.getString("isbn")
                );
                livres.add(livre);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return livres;

    }

    @Override
    public List<Document> searchDocument(String titre) {
        List<Document> livres = new ArrayList<>();
        String sql = "SELECT * FROM livre WHERE titre LIKE ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            String searchPattern = "%" + titre + "%";
            statement.setString(1, searchPattern);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Livre livre = new Livre(
                        resultSet.getInt("id"),
                        resultSet.getString("titre"),
                        resultSet.getString("auteur"),
                        resultSet.getDate("datePublication").toLocalDate(),
                        resultSet.getInt("nombreDePages"),
                        resultSet.getString("isbn")
                );
                livres.add(livre);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return livres;
    }

}