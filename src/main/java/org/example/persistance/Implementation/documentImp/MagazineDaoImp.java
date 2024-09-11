package org.example.persistance.Implementation.documentImp;

import org.example.config.DbConfig;
import org.example.metier.Abstract.Document;
import org.example.metier.Magazine;
import org.example.persistance.Interface.DocumentDaoInterface;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MagazineDaoImp implements DocumentDaoInterface {

    private Connection connection;

    public MagazineDaoImp() {
        try {
            this.connection = DbConfig.getInstance().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createDocument(Document document) {
        Magazine magazine = (Magazine) document;
        String sql = "INSERT INTO magazine (titre, auteur, datePublication, nombreDePages, numero) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, magazine.getTitre());
            statement.setString(2, magazine.getAuteur());
            statement.setDate(3, Date.valueOf(magazine.getDatePublication()));
            statement.setInt(4, magazine.getNombreDePages());
            statement.setInt(5, magazine.getNumero());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
    }

    @Override
    public void updateDocument(Document document) {
        Magazine magazine = (Magazine) document;
        String sql = "UPDATE magazine SET titre = ?, auteur = ?, datePublication = ?, nombreDePages = ?, numero = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, magazine.getTitre());
            statement.setString(2, magazine.getAuteur());
            statement.setDate(3, Date.valueOf(magazine.getDatePublication()));
            statement.setInt(4, magazine.getNombreDePages());
            statement.setInt(5, magazine.getNumero());
            statement.setInt(6, magazine.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteDocument(Integer magazineId) {
        String sql = "DELETE FROM magazine WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, magazineId);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }

    }

    @Override
    public Document displayDocument(Integer magazineId) {
        List<Document> magazines = new ArrayList<>();
        String sql = "SELECT * FROM magazinw WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, magazineId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Titre: " + resultSet.getString("titre"));
                System.out.println("Auteur: " + resultSet.getString("auteur"));
                System.out.println("Date de publication: " + resultSet.getString("datePublication"));
                System.out.println("Nombre de pages: " + resultSet.getInt("nombreDePages"));
                System.out.println("ISBN: " + resultSet.getInt("numero"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return (Document) magazines;
    }

    @Override
    public List<Document> displayAllDocuments() {
        List<Document> magazines = new ArrayList<>();
        String sql = "SELECT * FROM magazine";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                Magazine magazine = new Magazine(
                        resultSet.getString("titre"),
                        resultSet.getString("auteur"),
                        resultSet.getString("datePublication"),
                        resultSet.getInt("nombreDePages"),
                        resultSet.getInt("numero")
                );
                magazines.add(magazine);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return magazines;

    }

    @Override
    public List<Document> searchDocument(String titre) {
        List<Document> magazines = new ArrayList<>();
        String sql = "SELECT * FROM magazine WHERE titre LIKE ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            String searchPattern = "%" + titre + "%";
            statement.setString(1, searchPattern);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Magazine magazine = new Magazine(
                        resultSet.getString("titre"),
                        resultSet.getString("auteur"),
                        resultSet.getString("datePublication"),
                        resultSet.getInt("nombreDePages"),
                        resultSet.getInt("numero")
                );
                magazines.add(magazine);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return magazines;
    }

}