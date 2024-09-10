package org.example.metier;

public class Professeur extends Utilisateur{
    private String matiere;
    public Professeur(int id, String name, String email , String matiere) {
        super(id, name, email);
        this.matiere = matiere;
    }

    public String getMatiere(){
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }
}
