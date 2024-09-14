package org.yassine.persistance.Implementation.documentImp;

import org.yassine.config.DbConfig;
import org.yassine.metier.TheseUniversitaire;
import org.yassine.persistance.Interface.Document.TheseUniversitaireDaoInterface;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TheseUniversitaireDaoImp implements TheseUniversitaireDaoInterface {

    private Connection connection;

    public TheseUniversitaireDaoImp() {
        try {
            this.connection = DbConfig.getInstance().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createTheseUniversitaire(TheseUniversitaire theseUniversitaire) {

        String sql = "INSERT INTO theseuniversitaire (titre, auteur, datePublication, nombreDePage, universite, domaine) VALUES (?, ?, ?, ?, ?, ?)";

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
    public void updateTheseUniversitaire(TheseUniversitaire theseUniversitaire) {

        String sql = "UPDATE theseuniversitaire SET titre = ?, auteur = ?, datePublication = ?, nombreDePage = ?, universite = ?, domaine = ? WHERE id = ?";

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
    public void deleteTheseUniversitaire(Integer jsId) {
        String sql = "DELETE FROM theseuniversitaire WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, jsId);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }

    }

    @Override
    public TheseUniversitaire displayTheseUniversitaire(Integer theseUId) {
        List<TheseUniversitaire> theses = new ArrayList<>();
        String sql = "SELECT * FROM theseuniversitaire WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, theseUId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Titre: " + resultSet.getString("titre"));
                System.out.println("Auteur: " + resultSet.getString("auteur"));
                System.out.println("Date de publication: " + resultSet.getString("datePublication"));
                System.out.println("Nombre de pages: " + resultSet.getInt("nombreDePage"));
                System.out.println("University: " + resultSet.getString("universite"));
                System.out.println("Domaine: " + resultSet.getString("domaine"));
                return new TheseUniversitaire(
                        resultSet.getString("titre"),
                        resultSet.getString("auteur"),
                        resultSet.getDate("datePublication").toLocalDate(),
                        resultSet.getInt("nombredepage"),
                        resultSet.getString("universite"),
                        resultSet.getString("domaine")
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<TheseUniversitaire> displayAllTheseUniversitaires() {
        List<TheseUniversitaire> theses = new ArrayList<>();
        String sql = "SELECT * FROM theseuniversitaire";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                TheseUniversitaire these = new TheseUniversitaire(
                        resultSet.getString("titre"),
                        resultSet.getString("auteur"),
                        resultSet.getDate("datePublication").toLocalDate(),
                        resultSet.getInt("nombreDePage"),
                        resultSet.getString("universite"),
                        resultSet.getString("domaine")
                );
                theses.add(these);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return theses;

    }

    @Override
    public List<TheseUniversitaire> searchTheseUniversitaire(String titre) {
        List<TheseUniversitaire> theseUniversitaire = new ArrayList<>();
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
                        resultSet.getInt("nombreDePage"),
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