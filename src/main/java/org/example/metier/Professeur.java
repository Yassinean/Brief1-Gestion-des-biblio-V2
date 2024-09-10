package org.example.metier;

public class Professeur extends Utilisateur{
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
}
