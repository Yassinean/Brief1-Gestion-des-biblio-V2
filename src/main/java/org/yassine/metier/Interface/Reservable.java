package org.yassine.metier.Interface;

import org.yassine.metier.Abstract.Utilisateur;
import org.yassine.metier.JournalScientifique;
import org.yassine.metier.Livre;
import org.yassine.metier.Magazine;
import org.yassine.metier.TheseUniversitaire;

public interface Reservable {

    void reserveLivre(Livre livre, Utilisateur utilisateur);
    void reserveMagazine(Magazine magazine, Utilisateur utilisateur);
    void reserveThese(TheseUniversitaire theseUniversitaire, Utilisateur utilisateur);
    void reserveJournal(JournalScientifique journalScientifique, Utilisateur utilisateur);

    void annuleReserveLivre(Livre livre, Utilisateur utilisateur);
    void annuleReserveMagazine(Magazine magazine, Utilisateur utilisateur);
    void annuleReserveThese(TheseUniversitaire theseUniversitaire, Utilisateur utilisateur);
    void annuleReserveJournal(JournalScientifique journalScientifique, Utilisateur utilisateur);

}
