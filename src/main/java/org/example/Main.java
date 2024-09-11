package org.example;

import org.example.config.DbConfig;
import org.example.metier.Bibliotheque;
import org.example.persistance.Implementation.documentImp.LivreDaoImp;
import org.example.persistance.Implementation.userImp.EtudiantDaoImp;
import org.example.persistance.Interface.DocumentDaoInterface;
import org.example.persistance.Interface.UtilisateurDaoInterface;
import org.example.presentation.ConsoleUI;
import org.example.service.Implementation.DocumentServiceImp;
import org.example.service.Implementation.UtilisateurServiceImp;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        UtilisateurDaoInterface utilisateurDao = new EtudiantDaoImp(); // Replace with the correct implementation if necessary
        DocumentDaoInterface documentDao = new LivreDaoImp(); // Replace with the correct implementation

        // Initialize services with DAO implementations
        UtilisateurServiceImp utilisateurService = new UtilisateurServiceImp(utilisateurDao);
        DocumentServiceImp documentService = new DocumentServiceImp(documentDao);

        // Initialize Bibliotheque with services
        Bibliotheque bibliotheque = Bibliotheque.getInstance(utilisateurService, documentService);

        // Initialize and start the ConsoleUI
        ConsoleUI ui = ConsoleUI.getInstance(bibliotheque);
        ui.start();
    }
}