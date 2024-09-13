package org.yassine.metier;

import org.yassine.metier.Abstract.Document;

public class TheseUniversitaire extends Document {
    private String universite;
    private String domaine;
    public TheseUniversitaire(String titre, String auteur, String datePublication, int nombreDePages ,String universite , String domaine ) {
        super(titre, auteur, datePublication, nombreDePages);
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
        return "";
    }
}
