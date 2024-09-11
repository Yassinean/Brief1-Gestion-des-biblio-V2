package org.example.metier;

import org.example.metier.Abstract.Document;
import org.example.metier.Abstract.Utilisateur;
import org.example.service.Interface.UtilisateurService;

import java.util.ArrayList;

public class Bibliotheque {
    private static Bibliotheque instance;

    private Bibliotheque() {

    }

    public static Bibliotheque getInstance() {
        if (instance == null) {
            instance = new Bibliotheque();
        }
        return instance;
    }

    // Méthodes pour la gestion des documents
    public void ajouterDocument(Document document) {
        // Implémentation
    }

    public void modifierDocument(Document document) {
        // Implémentation
    }

    public void supprimerDocument(int id) {
        // Implémentation
    }

    public Document rechercherDocument(int id) {
        // Implémentation
        return null;
    }

    // Méthodes pour la gestion des utilisateurs
    public void ajouterUtilisateur(Utilisateur utilisateur) {
        // Implémentation
    }

    public void modifierUtilisateur(Utilisateur utilisateur) {
        // Implémentation
    }

    public void supprimerUtilisateur(int id) {
        // Implémentation
    }

    public Utilisateur rechercherUtilisateur(int id) {
        // Implémentation
        return null;
    }

    // Méthodes pour la gestion des emprunts
    public void emprunterDocument(int idDocument, int idUtilisateur) {
        // Implémentation
    }

    public void retournerDocument(int idDocument) {
        // Implémentation
    }

    public List<Emprunt> listeEmpruntsEnCours() {
        // Implémentation
        return new ArrayList<>();
    }

    // Méthodes pour la gestion des réservations
    public void reserverDocument(int idDocument, int idUtilisateur) {
        // Implémentation
    }

    public void annulerReservation(int idReservation) {
        // Implémentation
    }

    public List<Reservation> listeReservationsEnCours() {
        // Implémentation
        return new ArrayList<>();
    }
}
