package org.yassine.metier;

import org.yassine.metier.Abstract.Document;
import org.yassine.metier.Abstract.DroitAccess;

import java.time.LocalDate;

public class TheseUniversitaire extends Document {
    private String universite;
    private String domaine;

    public TheseUniversitaire(String titre, String auteur, LocalDate datePublication, int nombreDePages, String universite, String domaine, DroitAccess droitAccess) {
        super(titre, auteur, datePublication, nombreDePages, droitAccess);
        this.universite = universite;
        this.domaine = domaine;
    }

    public String getUniversite() {
        return universite;
    }

    public void setUniversite(String universite) {
        this.universite = universite;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    @Override
    public String afficherDetails() {
        return String.format("These Universitaire: %s, Auteur: %s, Pages: %d, Date de publication : %te %<tB %<ty,Domaine: %s,Universite :%s", getTitre(), getAuteur(), getNombreDePages(),getDatePublication(),domaine, universite);
    }
}
