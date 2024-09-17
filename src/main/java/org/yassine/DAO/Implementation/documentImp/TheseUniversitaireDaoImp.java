package org.yassine.DAO.Implementation.documentImp;

import org.yassine.config.DbConfig;
import org.yassine.model.Abstract.DroitAccess;
import org.yassine.model.TheseUniversitaire;
import org.yassine.DAO.Interface.Document.TheseUniversitaireDaoInterface;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        String sql = "INSERT INTO theseuniversitaire (titre, auteur, datePublication, nombreDePage, universite, domaine ,acces) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, theseUniversitaire.getTitre());
            statement.setString(2, theseUniversitaire.getAuteur());
            statement.setDate(3, Date.valueOf(theseUniversitaire.getDatePublication()));
            statement.setInt(4, theseUniversitaire.getNombreDePages());
            statement.setString(5, theseUniversitaire.getUniversite());
            statement.setString(6, theseUniversitaire.getDomaine());
            statement.setString(7, theseUniversitaire.getDroitAcces().name());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateTheseUniversitaire(TheseUniversitaire theseUniversitaire) {

        String sql = "UPDATE theseuniversitaire SET titre = ?, auteur = ?, datePublication = ?, nombreDePage = ?, universite = ?, domaine = ? , acces = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, theseUniversitaire.getTitre());
            statement.setString(2, theseUniversitaire.getAuteur());
            statement.setDate(3, Date.valueOf(theseUniversitaire.getDatePublication()));
            statement.setInt(4, theseUniversitaire.getNombreDePages());
            statement.setString(5, theseUniversitaire.getUniversite());
            statement.setString(6, theseUniversitaire.getDomaine());
            statement.setString(7, theseUniversitaire.getDroitAcces().name());
            statement.setInt(8, theseUniversitaire.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteTheseUniversitaire(Integer theseId) {
        String sql = "DELETE FROM theseuniversitaire WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, theseId);
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
                DroitAccess droitAccess = DroitAccess.valueOf(resultSet.getString("acces"));
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Titre: " + resultSet.getString("titre"));
                System.out.println("Auteur: " + resultSet.getString("auteur"));
                System.out.println("Date de publication: " + resultSet.getString("datePublication"));
                System.out.println("Nombre de pages: " + resultSet.getInt("nombreDePage"));
                System.out.println("University: " + resultSet.getString("universite"));
                System.out.println("Domaine: " + resultSet.getString("domaine"));
                System.out.println("Accessibility: " + resultSet.getString("acces"));
                return new TheseUniversitaire(resultSet.getString("titre"), resultSet.getString("auteur"), resultSet.getDate("datePublication").toLocalDate(), resultSet.getInt("nombredepage"), resultSet.getString("universite"), resultSet.getString("domaine"), droitAccess);
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

        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                DroitAccess droitAcces = DroitAccess.valueOf(resultSet.getString("acces"));
                TheseUniversitaire these = new TheseUniversitaire(resultSet.getString("titre"), resultSet.getString("auteur"), resultSet.getDate("datePublication").toLocalDate(), resultSet.getInt("nombreDePage"), resultSet.getString("universite"), resultSet.getString("domaine"), droitAcces);
                theses.add(these);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return theses;

    }

    @Override
    public List<TheseUniversitaire> searchTheseUniversitaire(String titre) {
        Map<Integer, TheseUniversitaire> theseMap = new HashMap<>();
        List<TheseUniversitaire> result = new ArrayList<>();
//        String sql = "SELECT * FROM theseuniversitaire WHERE titre LIKE ?";
//
//        try (PreparedStatement statement = connection.prepareStatement(sql)) {
//            String searchPattern = "%" + titre + "%";
//            statement.setString(1, searchPattern);
//            ResultSet resultSet = statement.executeQuery();
//
//            while (resultSet.next()) {
//                DroitAccess droitAcces = DroitAccess.valueOf(resultSet.getString("acces"));
//                TheseUniversitaire theseU = new TheseUniversitaire(resultSet.getString("titre"), resultSet.getString("auteur"), resultSet.getDate("datePublication").toLocalDate(), resultSet.getInt("nombreDePage"), resultSet.getString("universite"), resultSet.getString("domaine"), droitAcces);
//                theseUniversitaire.add(theseU);
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
        for(TheseUniversitaire these : theseMap.values()){
            if (these.getTitre().contains(titre)){
                result.add(these);
            }
        }

        return result;
    }

}