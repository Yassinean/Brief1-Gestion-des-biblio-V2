package org.example.persistance.DTO;

public class LivreDTO extends DocumentDTO{
    private String isbn;

    public LivreDTO(int id, String titre, String auteur, String datePublication, int nombreDePages, String isbn) {
        super(id, titre, auteur, datePublication, nombreDePages);
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
