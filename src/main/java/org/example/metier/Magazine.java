package org.example.metier;

import org.example.metier.Abstract.Document;

import java.time.LocalDate;

public class Magazine extends Document {
    private int numero;


    public Magazine(String titre, String auteur, LocalDate datePublication, int nombreDePages, int numero) {
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
        return "";
    }
}
