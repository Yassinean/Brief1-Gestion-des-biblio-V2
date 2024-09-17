package org.yassine.DAO.Interface;

import org.yassine.model.Abstract.Utilisateur;
import org.yassine.model.JournalScientifique;
import org.yassine.model.Livre;
import org.yassine.model.Magazine;
import org.yassine.model.TheseUniversitaire;

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
