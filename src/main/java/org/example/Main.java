package org.example;

import org.example.config.DbConfig;
import org.example.metier.Etudiant;
import org.example.metier.Abstract.Utilisateur;
import org.example.persistance.Implementation.userImp.EtudiantDaoImp;
import org.example.presentation.ConsoleUI;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        ConsoleUI ui = ConsoleUI.getInstance();
        ui.start();
    }
}