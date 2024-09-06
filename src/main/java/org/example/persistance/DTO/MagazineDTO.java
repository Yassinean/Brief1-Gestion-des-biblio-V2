package org.example.persistance.DTO;

import java.util.Enumeration;

public class MagazineDTO extends DocumentDTO{
    int numero ;
    public MagazineDTO(int id, String titre, String auteur, String datePublication, int nombreDePages , int numero) {
        super(id, titre, auteur, datePublication, nombreDePages);
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
