package org.example.presentation;

import java.util.Scanner;

public class ConsoleUI {

    private static ConsoleUI instance;
    private Scanner scanner;

    private ConsoleUI() {
        scanner = new Scanner(System.in);
    }

    public static ConsoleUI getInstance() {
        if (instance == null) {
            instance = new ConsoleUI();
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
                    gestionUtilisateurs();
                    break;
                case 3:
                    gestionEmprunts();
                    break;
                case 4:
                    gestionReservations();
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
        System.out.println("3. Gestion des emprunts");
        System.out.println("4. Gestion des réservations");
        System.out.println("0. Quitter");
    }

    private void gestionDocuments() {
        System.out.println("\n=== GESTION DES DOCUMENTS ===");
        System.out.println("1. Ajouter un document");
        System.out.println("2. Modifier un document");
        System.out.println("3. Supprimer un document");
        System.out.println("4. Rechercher un document");
        System.out.println("0. Retour au menu principal");

        int choice = getIntInput("Choisissez une option: ");
        switch (choice){
            case 1 :

                break;
        }
    }

    private void gestionUtilisateurs() {
        System.out.println("\n=== GESTION DES UTILISATEURS ===");
        System.out.println("1. Ajouter un utilisateur");
        System.out.println("2. Modifier un utilisateur");
        System.out.println("3. Supprimer un utilisateur");
        System.out.println("4. Rechercher un utilisateur");
        System.out.println("0. Retour au menu principal");

        int choice = getIntInput("Choisissez une option: ");
        // Implémenter les actions correspondantes
    }

    private void gestionEmprunts() {
        System.out.println("\n=== GESTION DES EMPRUNTS ===");
        System.out.println("1. Emprunter un document");
        System.out.println("2. Retourner un document");
        System.out.println("3. Liste des emprunts en cours");
        System.out.println("0. Retour au menu principal");

        int choice = getIntInput("Choisissez une option: ");
        // Implémenter les actions correspondantes
    }

    private void gestionReservations() {
        System.out.println("\n=== GESTION DES RÉSERVATIONS ===");
        System.out.println("1. Réserver un document");
        System.out.println("2. Annuler une réservation");
        System.out.println("3. Liste des réservations en cours");
        System.out.println("0. Retour au menu principal");

        int choice = getIntInput("Choisissez une option: ");
        // Implémenter les actions correspondantes
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
