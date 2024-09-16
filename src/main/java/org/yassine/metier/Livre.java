package org.yassine.metier;

import org.yassine.metier.Abstract.Document;
import org.yassine.metier.Abstract.DroitAccess;
import org.yassine.persistance.Interface.Empruntable;
import org.yassine.persistance.Interface.Reservable;

import java.time.LocalDate;

public class Livre extends Document {
    private String isbn;

    public Livre(String titre, String auteur, LocalDate datePublication, int nombreDePages , DroitAccess droitAccess, String isbn) {
        super(titre, auteur, datePublication, nombreDePages,droitAccess);
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
        return String.format("Livre: %s, Auteur: %s, ISBN: %s, Pages: %d, Date de publication: %te %<tB, %<tY, Accessibilte : %s",getTitre(),getAuteur(),isbn,getNombreDePages(),getDatePublication(),getDroitAcces());
    }

}
