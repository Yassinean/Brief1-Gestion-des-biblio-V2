package org.example.metier;

import java.time.LocalDate;

public class JournalScientifique extends Document{
    private String domaineRecherche;
    public JournalScientifique(String titre, String auteur, LocalDate datePublication, int nombreDePages ,  String domaineRecherche, boolean isEmprunted , boolean isReserved) {
        super(titre, auteur, datePublication, nombreDePages, isEmprunted, isReserved);
        this.domaineRecherche = domaineRecherche;
    }

    public String getDomaine() {
        return domaineRecherche;
    }

    public void setDomaine(String domaineRecherche) {
        this.domaineRecherche = domaineRecherche;
    }
}
