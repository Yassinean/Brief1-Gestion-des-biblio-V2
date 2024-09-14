package org.yassine.metier;

import org.yassine.metier.Abstract.Document;
import org.yassine.persistance.Interface.Empruntable;
import org.yassine.persistance.Interface.Reservable;

import java.time.LocalDate;

public class Livre extends Document {
    private String isbn;

    public Livre(String titre, String auteur, LocalDate datePublication, int nombreDePages , String isbn) {
        super(titre, auteur, datePublication, nombreDePages);
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String afficherDetails() {
        return String.format("Livre: %s, Auteur: %s, ISBN: %s, Pages: %d",getTitre(),getAuteur(),isbn);
    }

}
