package org.example.metier;

import java.time.LocalDate;

public class Document {
    private int id;
    protected String titre;
    protected String auteur;
    protected LocalDate datePublication;
    protected int nombreDePages;
    protected boolean isEmprunted = false;

    public Document(String titre, String auteur, LocalDate datePublication, int nombreDePages) {
        this.titre = titre;
        this.auteur = auteur;
        this.datePublication = datePublication;
        this.nombreDePages = nombreDePages;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getTitre(){
        return titre;
    }

    public void setTitre(String titre){
        this.titre = titre;
    }

    public String getAuteur(){
        return auteur;
    }

    public void setAuteur(String auteur){
        this.auteur = auteur;
    }

    public int getNombreDePages(){
        return nombreDePages;
    }

    public void setNombreDePages(int nombreDePages){
        this.nombreDePages = nombreDePages;
    }

    public LocalDate getDate(){
        return datePublication;
    }

    public void setDate(LocalDate datePublication){
        this.datePublication = datePublication;
    }

    public boolean getIsEmprunted(){
        return isEmprunted;
    }

    public void setIsEmprunted(boolean isEmprunted){
        this.isEmprunted = isEmprunted;
    }


}
