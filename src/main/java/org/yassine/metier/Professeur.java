package org.yassine.metier;

import org.yassine.metier.Abstract.Utilisateur;

public class Professeur extends Utilisateur {
    private String matiere;
    public Professeur(String name, String email , String matiere) {
        super(name, email);
        this.matiere = matiere;
    }

    public String getMatiere(){
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public String afficherDetails(){
        return String.format("Professeur: %s, Email: %s, Matiere: %s ",getName(),getEmail(),matiere);
    }
}
