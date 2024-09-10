package org.example;

import org.example.config.DbConfig;
import org.example.metier.Etudiant;
import org.example.metier.Utilisateur;
import org.example.persistance.Implementation.userImp.EtudiantDaoImp;
import org.example.presentation.ConsoleUI;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.UUID;

public class Main {
    public static void main(String[] args) throws SQLException {
        EtudiantDaoImp etudiantDao = new EtudiantDaoImp();
        Connection connection = DbConfig.getInstance().getConnection();
        Scanner scanner = new Scanner(System.in);


        boolean continueMenu = true;

        while (continueMenu) {
            System.out.println("Menu:");
            System.out.println("1. Ajouter un étudiant");
            System.out.println("2. Mettre à jour un étudiant");
            System.out.println("3. Supprimer un étudiant");
            System.out.println("4. Afficher un étudiant");
            System.out.println("5. Quitter");
            System.out.print("Choisissez une option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Ajouter un étudiant:");
                    System.out.print("Entrer le nom de l'étudiant: ");
                    String name = scanner.nextLine();
                    scanner.nextLine();
                    System.out.print("Entrer l'email de l'étudiant: ");
                    String email = scanner.nextLine();
                    System.out.print("Entrer la branche de l'étudiant: ");
                    String branche = scanner.nextLine();
                    Utilisateur etudiant = new Etudiant(name, email, branche);
                    etudiantDao.createUtilisateur(etudiant);
                    break;
                case 2:
                    System.out.println("Modifier le etudiant");

                    break;
                case 3:
                    // Call method to delete student (implement later)
                    System.out.println("Supprimer un étudiant");
                    break;
                case 4:
                    System.out.println("Quitter le programme.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Choix non valide, essayez à nouveau.");
            }
        }

    }

}