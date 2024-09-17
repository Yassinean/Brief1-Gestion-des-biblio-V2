package org.yassine.model;

import org.yassine.model.Abstract.Document;
import org.yassine.model.Abstract.DroitAccess;

import java.time.LocalDate;

public class JournalScientifique extends Document {
    private String domaineRecherche;
    public JournalScientifique(String titre, String auteur, LocalDate datePublication, int nombreDePages , String domaineRecherche, DroitAccess droitAccess) {
        super(titre, auteur, datePublication, nombreDePages,droitAccess);
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
        return String.format("Journal Scientifique: %s, Auteur: %s, Pages: %d, Date de publication : %te %<tB %<ty,Domaine de recherche: %s", getTitre(), getAuteur(), getNombreDePages(),getDatePublication(),domaineRecherche);
    }
}
