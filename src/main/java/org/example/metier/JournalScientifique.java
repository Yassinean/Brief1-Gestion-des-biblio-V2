package org.example.metier;

import org.example.metier.Abstract.Document;

import java.time.LocalDate;

public class JournalScientifique extends Document {
    private String domaineRecherche;
    public JournalScientifique(String titre, String auteur, String datePublication, int nombreDePages ,  String domaineRecherche) {
        super(titre, auteur, datePublication, nombreDePages);
        this.domaineRecherche = domaineRecherche;
    }

    public String getDomaine() {
        return domaineRecherche;
    }

    public void setDomaine(String domaineRecherche) {
        this.domaineRecherche = domaineRecherche;
    }

    @Override
    public String afficherDetails() {
        return "";
    }
}
