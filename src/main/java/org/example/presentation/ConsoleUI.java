package org.example.presentation;

import org.example.metier.Abstract.Document;
import org.example.metier.Livre; // Assuming Livre and Magazine extend Document
import org.example.metier.Magazine;
import org.example.metier.Bibliotheque;

import java.util.Scanner;

public class ConsoleUI {

    private static ConsoleUI instance;
    private Scanner scanner;
    private Bibliotheque bibliotheque;

    private ConsoleUI(Bibliotheque bibliotheque) {
        scanner = new Scanner(System.in);
        this.bibliotheque = bibliotheque;
    }

    public static ConsoleUI getInstance(Bibliotheque bibliotheque) {
        if (instance == null) {
            instance = new ConsoleUI(bibliotheque);
        }
        return instance;
    }

    public void start() {
        boolean exit = false;
        while (!exit) {
            printMenu();
            int choice = getIntInput("Choisissez une option: ");
            switch (choice) {
                case 1:
                    gestionDocuments();
                    break;
                case 2:
//                    gestionUtilisateurs();
                    break;
                case 3:
//                    gestionEmprunts();
                    break;
                case 4:
//                    gestionReservations();
                    break;
                case 0:
                    exit = true;
                    System.out.println("Au revoir!");
                    break;
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        }
        scanner.close();
    }

    private void printMenu() {
        System.out.println("\n=== SYSTÈME DE GESTION DE BIBLIOTHÈQUE ===");
        System.out.println("1. Gestion des documents");
        System.out.println("2. Gestion des utilisateurs");
        System.out.println("0. Quitter");
    }

    private void gestionDocuments() {
        System.out.println("\n=== GESTION DES DOCUMENTS ===");
        System.out.println("1. Ajouter un document");
        System.out.println("2. Modifier un document");
        System.out.println("3. Supprimer un document");
        System.out.println("4. Rechercher un document");
        System.out.println("5. Emprunter un document");
        System.out.println("6. Reserver un document");
        System.out.println("0. Retour au menu principal");

        int choice = getIntInput("Choisissez une option: ");
        switch (choice) {
            case 1:
                ajouterDocument();
                break;
            case 2:
                modifierDocument();
                break;
            case 3:
                supprimerDocument();
                break;
            case 4:
                rechercherDocument();
                break;
            case 5:
                emprunterDocument();
                break;
            case 6:
                reserverDocument();
                break;
            case 0:
                // Retour au menu principal
                break;
            default:
                System.out.println("Option invalide. Veuillez réessayer.");
        }
    }

    private void ajouterDocument() {
        System.out.println("\n=== AJOUTER UN DOCUMENT ===");
        System.out.println("1. Livre");
        System.out.println("2. Magazine");

        int typeChoix = getIntInput("Choisissez le type de document: ");
        Document document = null;

        switch (typeChoix) {
            case 1:
                creerLivre();
                break;
            case 2:
                creerMagazine();
                break;
            default:
                System.out.println("Type de document invalide.");
                return;
        }

        if (document != null) {
            bibliotheque.createDocument(document);
            System.out.println("Document ajouté avec succès.");
        }
    }

    private void creerLivre() {
        System.out.println("=== AJOUTER UN LIVRE ===");
        String titre = getStringInput("Entrez le titre du livre: ");
        scanner.nextLine();
        String auteur = getStringInput("Entrez l'auteur du livre: ");
        scanner.nextLine();
        String datePublication = getStringInput("Entrez la date de publication du livre: ");
        scanner.nextLine();
        int nombreDePage = getIntInput("Entrez le nombre de page du livre: ");
        scanner.nextLine();
        String isbn = getStringInput("Entrez l'ISBN du livre: ");
        Livre livre = new Livre(titre, auteur, datePublication, nombreDePage, isbn);
        bibliotheque.createDocument(livre);
    }

    private void creerMagazine() {
        System.out.println("=== AJOUTER UN MAGAZINE ===");
        String titre = getStringInput("Entrez le titre du magazine: ");
        scanner.nextLine();
        String auteur = getStringInput("Entrez l'auteur du magazine: ");
        scanner.nextLine();
        String datePublication = getStringInput("Entrez la date de publication du magazine: ");
        scanner.nextLine();
        int nombreDePage = getIntInput("Entrez le nombre de page du magazine: ");
        scanner.nextLine();
        int numero = getIntInput("Entrez le numero du magazine: ");
        scanner.nextLine();
        Magazine magazine = new Magazine(titre, auteur, datePublication, nombreDePage, numero);
        bibliotheque.createDocument(magazine);
    }

    private void modifierDocument() {
        System.out.println("=== MODIFIER UN DOCUMENT ===");
        // Implement modification logic
    }

    private void supprimerDocument() {
        System.out.println("=== SUPPRIMER UN DOCUMENT ===");
        // Implement deletion logic
    }

    private void rechercherDocument() {
        System.out.println("=== RECHERCHER UN DOCUMENT ===");
        // Implement search logic
    }

    private void emprunterDocument() {
        System.out.println("=== EMPRUNTER UN DOCUMENT ===");
        // Implement search logic
    }

    private void reserverDocument() {
        System.out.println("=== RESERVER UN DOCUMENT ===");
        // Implement search logic
    }

    private int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Veuillez entrer un nombre valide.");
            System.out.print(prompt);
            scanner.next();
        }
        return scanner.nextInt();
    }

    public String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.next();
    }
}
