package org.example.metier;

import java.time.LocalDate;

public class Livre extends Document {
    private String isbn;

    public Livre(Integer id, String titre, String auteur, LocalDate datePublication, int nombreDePages, boolean isEmprunted, boolean isReserved , String isbn) {
        super(titre, auteur, datePublication, nombreDePages, isEmprunted, isReserved);
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
