package org.example.metier;

import org.example.metier.Abstract.Document;
import org.example.metier.Interface.Empruntable;
import org.example.metier.Interface.Reservable;

import java.time.LocalDate;

public class Livre extends Document implements Empruntable, Reservable {
    private String isbn;
    private boolean estEmprunte;
    private boolean estReserve;

    public Livre(Integer id, String titre, String auteur, LocalDate datePublication, int nombreDePages , String isbn) {
        super(titre, auteur, datePublication, nombreDePages);
        this.isbn = isbn;
        this.estEmprunte = false;
        this.estReserve = false;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String afficherDetails() {
        return String.format("Livre: %s, Auteur: %s, ISBN: %s, Pages: %d",getTitre(),getAuteur(),isbn, nombreDePages);
    }

    @Override
    public boolean emprunter() {
        if (!estEmprunte && !estReserve) {
            estEmprunte = true;
            return true;
        }
        return false;
    }

    @Override
    public boolean retourner() {
        if (estEmprunte) {
            estEmprunte = false;
            return true;
        }
        return false;
    }

    @Override
    public boolean reserver() {
        if (!estEmprunte && !estReserve) {
            estReserve = true;
            return true;
        }
        return false;
    }

    @Override
    public boolean annulerReservation() {
        if (estReserve) {
            estReserve = false;
            return true;
        }
        return false;
    }
}
