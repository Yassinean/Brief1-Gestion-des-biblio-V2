package org.yassine.persistance.Implementation;




import org.yassine.config.DbConfig;
import org.yassine.metier.Abstract.Utilisateur;
import org.yassine.metier.JournalScientifique;
import org.yassine.metier.Livre;
import org.yassine.metier.Magazine;
import org.yassine.metier.TheseUniversitaire;
import org.yassine.persistance.Interface.Empruntable;
import org.yassine.utilitaire.UserCheck;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpruntableImp implements Empruntable {

    private Connection getConnection() throws SQLException {
        return DbConfig.getInstance().getConnection();
    }

    public boolean empruntDocument(String tableName ,int documentId , int utilisateurId){
        String query = " UPDATE " +tableName+ " SET emprunterpar = ? WHERE id = ? AND emprunterpar IS NULL ";
        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1,utilisateurId);
            stmt.setInt(2,documentId);
            int rowUpdated =  stmt.executeUpdate();
            return rowUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean retournDocument(String tableName ,int documentId ,int utilisateurId){
        String selectQuery = "SELECT emprunterpar , reserverpar FROM "+tableName+ " WHERE id = ?";
        String updateQuery = "UPDATE "+tableName+" SET emprunterpar = ? , reserverpar = NULL WHERE id = ? AND emprunterpar = ? ";
        try (Connection con = getConnection();
             PreparedStatement selectStmt = con.prepareStatement(selectQuery);
             PreparedStatement updateStmt = con.prepareStatement(updateQuery)){
            selectStmt.setInt(1,documentId);
            ResultSet rs = selectStmt.executeQuery();
            if (rs.next()){
                int reservePar = rs.getInt("reserverpar");
                if(reservePar != 0){
                    updateStmt.setInt(1, reservePar);
                    updateStmt.setInt(2, documentId);
                    updateStmt.setInt(3, utilisateurId);
                    int rows = updateStmt.executeUpdate();
                    if (rows > 0) {
                        System.out.println("Document retourné et maintenant emprunté automatiquement par l'utilisateur qui a réservé (ID: " + reservePar + ").");
                        return true;
                    }
                }else {
                    String query = "UPDATE "+tableName+ " SET emprunterpar = NULL WHERE id = ? AND emprunterpar = ? ";
                    try (
                            PreparedStatement stmt = con.prepareStatement(query)) {
                        stmt.setInt(1, documentId);
                        stmt.setInt(2, utilisateurId);
                        int rowUpdated = stmt.executeUpdate();
                        return rowUpdated > 0;
                    }
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        return false;
    }

    @Override
    public void empruntLivre(Livre livre, Utilisateur utilisateur) {
        if (UserCheck.checkUserAccess(livre, utilisateur)) {
            boolean queryExecute =  empruntDocument("livre",livre.getId(),utilisateur.getId());
            if (queryExecute){
                System.out.println("Livre emprunté avec succès.");
            }else {
                System.out.println("Ce livre est déjà emprunté.");
            }
        } else {
            System.out.println("L'utilisateur n'a pas accès à ce document.");
        }
    }

    @Override
    public void empruntMagazine(Magazine magazine, Utilisateur utilisateur) {
        if (UserCheck.checkUserAccess(magazine, utilisateur)) {
            boolean queryExecute =  empruntDocument("magazine",magazine.getId(),utilisateur.getId());
            if (queryExecute){
                System.out.println("Magazine emprunté avec succès.");
            }else {
                System.out.println("Cette magazine est déjà emprunté.");
            }
        } else {
            System.out.println("L'utilisateur n'a pas accès à ce document.");
        }
    }

    @Override
    public void empruntThese(TheseUniversitaire theseUniversitaire, Utilisateur utilisateur) {
        if (UserCheck.checkUserAccess(theseUniversitaire, utilisateur)) {
            boolean queryExecute =  empruntDocument("theseuniversitaire",theseUniversitaire.getId(),utilisateur.getId());
            if (queryExecute){
                System.out.println("These universitaire emprunté avec succès.");
            }else {
                System.out.println("Cette these universitaire est déjà emprunté.");
            }
        } else {
            System.out.println("L'utilisateur n'a pas accès à ce document.");
        }
    }

    @Override
    public void empruntJournal(JournalScientifique journalScientifique, Utilisateur utilisateur) {
        if (UserCheck.checkUserAccess(journalScientifique, utilisateur)) {
            boolean queryExecute = empruntDocument("journalscientifique",journalScientifique.getId(),utilisateur.getId());
            if (queryExecute){
                System.out.println("journal scientifique emprunté avec succès.");
            }else {
                System.out.println("Ce journal scientifique est déjà emprunté.");
            }
        } else {
            System.out.println("L'utilisateur n'a pas accès à ce document.");
        }
    }

    @Override
    public void retournerLivre(Livre livre, Utilisateur utilisateur) {
        boolean queryExecute =  retournDocument("livre",livre.getId(),utilisateur.getId());
        if (queryExecute){
            System.out.println("Livre retourné avec succès.");
        }else {
            System.out.println("Ce livre est déjà retourné.");
        }
    }

    @Override
    public void retournerMagazine(Magazine magazine, Utilisateur utilisateur) {
        boolean queryExecute =  retournDocument("magazine",magazine.getId(),utilisateur.getId());
        if (queryExecute){
            System.out.println("Magazine retourné avec succès.");
        }else {
            System.out.println("Cette magazine est déjà retourné.");
        }
    }

    @Override
    public void retournerThese(TheseUniversitaire theseUniversitaire, Utilisateur utilisateur) {
        boolean queryExecute =   retournDocument("theseuniversitaire",theseUniversitaire.getId(),utilisateur.getId());
        if (queryExecute){
            System.out.println("These universitaire retourné avec succès.");
        }else {
            System.out.println("Cette these universitaire est déjà retourné.");
        }
    }

    @Override
    public void retournerJournal(JournalScientifique journalScientifique, Utilisateur utilisateur) {
        boolean queryExecute =  retournDocument("journalscientifique",journalScientifique.getId(),utilisateur.getId());
        if (queryExecute){
            System.out.println("journal scientifique retourné avec succès.");
        }else {
            System.out.println("Ce journal scientifique est déjà retourné.");
        }
    }
}


