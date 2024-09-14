package org.yassine.persistance.Implementation.documentImp;

import org.yassine.config.DbConfig;
import org.yassine.metier.Magazine;
import org.yassine.persistance.Interface.Document.MagazineDaoInterface;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MagazineDaoImp implements MagazineDaoInterface {

    private Connection connection;

    public MagazineDaoImp() {
        try {
            this.connection = DbConfig.getInstance().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createMagazine(Magazine magazine) {

        String sql = "INSERT INTO magazine (titre, auteur, datePublication, nombredepage, numero) VALUES (?, ?, ?, ?, ?)";

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
    public void updateMagazine(Integer id, Magazine magazine) {

        String sql = "UPDATE magazine SET titre = ?, auteur = ?, datePublication = ?, nombredepage = ?, numero = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, magazine.getTitre());
            statement.setString(2, magazine.getAuteur());
            statement.setDate(3, Date.valueOf(magazine.getDatePublication()));
            statement.setInt(4, magazine.getNombreDePages());
            statement.setInt(5, magazine.getNumero());
            statement.setInt(6, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteMagazine(Integer magazineId) {
        String sql = "DELETE FROM magazine WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, magazineId);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }

    }

    @Override
    public Magazine displayMagazine(Integer magazineId) {

        String sql = "SELECT * FROM magazine WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, magazineId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Titre: " + resultSet.getString("titre"));
                System.out.println("Auteur: " + resultSet.getString("auteur"));
                System.out.println("Date de publication: " + resultSet.getString("datePublication"));
                System.out.println("Nombre de pages: " + resultSet.getInt("nombreDePage"));
                System.out.println("Numero : " + resultSet.getInt("numero"));
                return new Magazine(
                        resultSet.getString("titre"),
                        resultSet.getString("auteur"),
                        resultSet.getDate("datePublication").toLocalDate(),
                        resultSet.getInt("nombredepage"),
                        resultSet.getInt("numero")
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Magazine> displayAllMagazines() {
        List<Magazine> magazines = new ArrayList<>();
        String sql = "SELECT * FROM magazine";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                Magazine magazine = new Magazine(
                        resultSet.getString("titre"),
                        resultSet.getString("auteur"),
                        resultSet.getDate("datePublication").toLocalDate(),
                        resultSet.getInt("nombreDePage"),
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
    public List<Magazine> searchMagazine(String titre) {
        List<Magazine> magazines = new ArrayList<>();
        String sql = "SELECT * FROM magazine WHERE titre LIKE ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            String searchPattern = "%" + titre + "%";
            statement.setString(1, searchPattern);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Magazine magazine = new Magazine(
                        resultSet.getString("titre"),
                        resultSet.getString("auteur"),
                        resultSet.getDate("datePublication").toLocalDate(),
                        resultSet.getInt("nombreDePage"),
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