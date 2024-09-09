package org.example;

import org.example.config.DbConfig;
import org.example.metier.Etudiant;
import org.example.persistance.Implementation.EtudiantDaoImp;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = DbConfig.getInstance().getConnection();

        Etudiant etudiant = new Etudiant(connection);
//        etudiant.createEtudiant();
        etudiant.deleteEtudiant(etudiant.getName());
    }
}

