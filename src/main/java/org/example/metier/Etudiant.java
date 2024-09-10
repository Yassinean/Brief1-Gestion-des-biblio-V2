package org.example.metier;

import org.example.persistance.Implementation.EtudiantDaoImp;


import java.util.Scanner;

public class Etudiant extends Utilisateur{
    private String branche;
    public Etudiant(int id , String name , String email , String branche){
        super(id,name,email);
        this.branche = branche;
    }

    public String getBranche(){
        return branche;
    }

    public void setBranche(String branche) {
        this.branche = branche;
    }

}
