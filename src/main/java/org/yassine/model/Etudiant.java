package org.yassine.model;

import org.yassine.model.Abstract.Utilisateur;

public class Etudiant extends Utilisateur {

    private String branche;

    public Etudiant(String name , String email , String branche){
        super(name,email);
        this.branche = branche;
    }

    public String getBranche(){
        return branche;
    }

    public void setBranche(String branche) {
        this.branche = branche;
    }

    public String afficherDetails(){
        return String.format("Etudiant : %s, Email: %s, Branche: %s",getName(),getEmail(),branche);
    }

}
