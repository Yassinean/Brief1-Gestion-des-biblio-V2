package org.yassine.model;

import org.yassine.model.Abstract.Document;
import org.yassine.model.Abstract.DroitAccess;

import java.time.LocalDate;

public class Magazine extends Document {
    private int numero;


    public Magazine(String titre, String auteur, LocalDate datePublication, int nombreDePages, DroitAccess droitAccess, int numero) {
        super(titre, auteur, datePublication, nombreDePages,droitAccess);
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero){
        this.numero = numero;
    }

    @Override
    public String afficherDetails() {
        return String.format("Magazine: %s, Auteur: %s, NUMERO: %d, Pages: %d, Date de publication: %te %<tB, %<tY, Accessibilte :%s",getTitre(),getAuteur(), numero ,getNombreDePages(),getDatePublication(),getDroitAcces());
    }
}
