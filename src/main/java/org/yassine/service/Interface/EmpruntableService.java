package org.yassine.service.Interface;


import org.yassine.model.Abstract.Utilisateur;
import org.yassine.model.JournalScientifique;
import org.yassine.model.Livre;
import org.yassine.model.Magazine;
import org.yassine.model.TheseUniversitaire;

public interface EmpruntableService {

    void empruntLivre(Livre livre, Utilisateur utilisateur);
    void empruntMagazine(Magazine magazine, Utilisateur utilisateur);
    void empruntThese(TheseUniversitaire theseUniversitaire, Utilisateur utilisateur);
    void empruntJournal(JournalScientifique journalScientifique, Utilisateur utilisateur);

    void retournerLivre(Livre livre, Utilisateur utilisateur);
    void retournerMagazine(Magazine magazine, Utilisateur utilisateur);
    void retournerThese(TheseUniversitaire theseUniversitaire, Utilisateur utilisateur);
    void retournerJournal(JournalScientifique journalScientifique, Utilisateur utilisateur);
}
