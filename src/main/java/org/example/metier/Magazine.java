package org.example.metier;

import java.time.LocalDate;

public class Magazine extends Document{
    private int numero;


    public Magazine(String titre, String auteur, LocalDate datePublication, int nombreDePages, boolean isEmprunted, boolean isReserved , int numero) {
        super(titre, auteur, datePublication, nombreDePages, isEmprunted, isReserved);
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero){
        this.numero = numero;
    }
}
