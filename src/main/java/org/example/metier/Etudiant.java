package org.example.metier;

import org.example.persistance.Implementation.EtudiantDaoImp;

import java.sql.Connection;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.UUID;

public class Etudiant {
    private UUID id;
    private String name;
    private String email;
    private EtudiantDaoImp etudiantDaoImp;

    public Etudiant(Connection connection){
        this.id = null;
        this.name = "";
        this.email = "";
        this.etudiantDaoImp = new EtudiantDaoImp(connection);
    }

    public Etudiant(UUID id , String name , String email, Connection connection ){
        this.id = id;
        this.name = name;
        this.email = email;
        this.etudiantDaoImp = new EtudiantDaoImp(connection);
    }

    private UUID generateUuid() {
        return UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    Scanner scan = new Scanner(System.in);
//    public void createEtudiant(){
//        this.id = generateUuid();
//        System.out.println("Entrer le nom et le prenom de l'etudiant");
//        String name = scan.nextLine();
//        System.out.println("Entrer l'email de l'etudiant");
//        String email = scan.nextLine();
//        etudiantDaoImp.createEtudiant(this.id.toString() ,name,email);
//    }

    public void deleteEtudiant(String name){
        System.out.println("Entrer l'etudiant que vous voulez supprimer :");
        scan.nextLine();
        etudiantDaoImp.deleteEtudiant(this.name);
        System.out.println("supprime");
    }
}
