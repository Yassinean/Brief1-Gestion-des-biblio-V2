package org.yassine.service.Interface;


import org.yassine.metier.Abstract.Utilisateur;
import org.yassine.metier.JournalScientifique;
import org.yassine.metier.Livre;
import org.yassine.metier.Magazine;
import org.yassine.metier.TheseUniversitaire;

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
