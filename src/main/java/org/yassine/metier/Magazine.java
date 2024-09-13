package org.yassine.metier;

import org.yassine.metier.Abstract.Document;

public class Magazine extends Document {
    private int numero;


    public Magazine(String titre, String auteur, String datePublication, int nombreDePages, int numero) {
        super(titre, auteur, datePublication, nombreDePages);
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
        return String.format("Livre: %s, Auteur: %s, ISBN: %s, Pages: %d",getTitre(),getAuteur(),numero, nombreDePages);
    }
}
