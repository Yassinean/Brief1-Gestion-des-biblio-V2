package org.yassine.metier.Interface;

import org.yassine.metier.Abstract.Utilisateur;
import org.yassine.metier.JournalScientifique;
import org.yassine.metier.Livre;
import org.yassine.metier.Magazine;
import org.yassine.metier.TheseUniversitaire;

public interface Empruntable {


    void empruntLivre(Livre livre, Utilisateur utilisateur);
    void empruntMagazine(Magazine magazine , Utilisateur utilisateur);
    void empruntThese(TheseUniversitaire theseUniversitaire, Utilisateur utilisateur);
    void empruntJOURNAL(JournalScientifique journalScientifique , Utilisateur utilisateur);

    void retournLivre(Livre livre,Utilisateur utilisateur);
    void retournMagazine(Magazine magazine ,Utilisateur utilisateur);
    void retournThese(TheseUniversitaire theseUniversitaire,Utilisateur utilisateur);
    void retournJournal(JournalScientifique journalScientifique ,Utilisateur utilisateur);

}
