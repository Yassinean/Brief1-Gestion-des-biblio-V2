package org.yassine.persistance.Implementation;


import org.yassine.config.DbConfig;
import org.yassine.metier.Abstract.Utilisateur;
import org.yassine.metier.JournalScientifique;
import org.yassine.metier.Livre;
import org.yassine.metier.Magazine;
import org.yassine.metier.TheseUniversitaire;
import org.yassine.persistance.Interface.Reservable;
import org.yassine.utilitaire.UserCheck;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservableImp implements Reservable {

    private Connection getConnection() throws SQLException {
        return DbConfig.getInstance().getConnection();
    }
    private void documentReservation(String tableName, int documentId, int utilisateurId, String typeDocument) {
        String query = "UPDATE " + tableName + " SET reserverpar = ? WHERE id = ? AND reserverpar IS NULL";
        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, utilisateurId);
            stmt.setInt(2, documentId);
            int rows = stmt.executeUpdate();
            if (rows > 0){
                System.out.println("Ce "+typeDocument+" est réservé avec succès.");
            }else {
                System.out.println("Ce "+typeDocument+" est déjà réservé.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void annuleReservation(String tableName, int documentId, int utilisateurId,String typeDocument) {
        String checkQuery = "SELECT reserverpar FROM " + tableName + " WHERE id = ?";
        String updateQuery = "UPDATE " + tableName + " SET reserverpar = NULL WHERE id = ? AND reserverpar = ?";

        try (Connection con = getConnection();
             PreparedStatement checkStmt = con.prepareStatement(checkQuery);
             PreparedStatement updateStmt = con.prepareStatement(updateQuery)) {
            checkStmt.setInt(1, documentId);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                int reservePar = rs.getInt("reserverpar");

                if (reservePar == 0) {
                    System.out.println("Ce "+typeDocument+" n'est pas réservé."); ;
                } else if (reservePar != utilisateurId) {
                    System.out.println("Ce "+typeDocument+" est réservé par un autre utilisateur. Vous n'avez pas accès pour annuler cette réservation.");
                } else {

                    updateStmt.setInt(1, documentId);
                    updateStmt.setInt(2, utilisateurId);
                    int rows = updateStmt.executeUpdate();

                    if (rows > 0) {
                        System.out.println("La réservation sur ce "+typeDocument+" est annulée avec succès.");
                    } else {
                        System.out.println( "Erreur lors de l'annulation de la réservation.");
                    }
                }
            } else {
                System.out.println( typeDocument+" avec cet ID n'existe pas.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void reserveLivre(Livre livre, Utilisateur utilisateur) {
        if (UserCheck.checkUserAccess(livre, utilisateur)) {
            documentReservation("livre", livre.getId(), utilisateur.getId(),"Livre");
        } else {
            System.out.println("L'utilisateur n'a pas accès à ce document.");
        }
    }

    @Override
    public void reserveMagazine(Magazine magazine, Utilisateur utilisateur) {
        if (UserCheck.checkUserAccess(magazine, utilisateur)) {
            documentReservation("magazine", magazine.getId(), utilisateur.getId(),"Magazine");
        } else {
            System.out.println("L'utilisateur n'a pas accès à ce document.");
        }
    }

    @Override
    public void reserveThese(TheseUniversitaire theseUniversitaire, Utilisateur utilisateur) {
        if (UserCheck.checkUserAccess(theseUniversitaire, utilisateur)) {
            documentReservation("theseuniversitaire", theseUniversitaire.getId(), utilisateur.getId(),"These Universitaire");
        } else {
            System.out.println("L'utilisateur n'a pas accès à ce document.");
        }
    }

    @Override
    public void reserveJournal(JournalScientifique journalScientifique, Utilisateur utilisateur) {
        if (UserCheck.checkUserAccess(journalScientifique, utilisateur)) {
            documentReservation("journalscientifique", journalScientifique.getId(), utilisateur.getId(),"journal scientifique");
        } else {
            System.out.println("L'utilisateur n'a pas accès à ce document.");
        }
    }
    @Override
    public void annuleReserveLivre(Livre livre, Utilisateur utilisateur) {
        annuleReservation("livre", livre.getId(), utilisateur.getId(),"Livre");
    }

    @Override
    public void annuleReserveMagazine(Magazine magazine, Utilisateur utilisateur) {
        annuleReservation("magazine", magazine.getId(), utilisateur.getId(),"Magazine");
    }

    @Override
    public void annuleReserveThese(TheseUniversitaire theseUniversitaire, Utilisateur utilisateur) {
        annuleReservation("theseuniversitaire", theseUniversitaire.getId(), utilisateur.getId(),"These Universitaire");
    }

    @Override
    public void annuleReserveJournal(JournalScientifique journalScientifique, Utilisateur utilisateur) {
        annuleReservation("journalscientifique", journalScientifique.getId(), utilisateur.getId(),"Journal Scientifique");
    }
}
