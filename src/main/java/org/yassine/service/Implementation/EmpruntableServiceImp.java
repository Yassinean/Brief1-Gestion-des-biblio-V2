package org.yassine.service.Implementation;
import org.yassine.metier.Abstract.Utilisateur;
import org.yassine.metier.JournalScientifique;
import org.yassine.metier.Livre;
import org.yassine.metier.Magazine;
import org.yassine.metier.TheseUniversitaire;
import org.yassine.persistance.Implementation.EmpruntableImp;
import org.yassine.service.Interface.EmpruntableService;

public class EmpruntableServiceImp implements EmpruntableService {

    private EmpruntableImp empruntableImp;

    public EmpruntableServiceImp() {
        this.empruntableImp = new EmpruntableImp();
    }

    @Override
    public void empruntLivre(Livre livre, Utilisateur utilisateur) {
        empruntableImp.empruntLivre(livre, utilisateur);
    }

    @Override
    public void empruntMagazine(Magazine magazine, Utilisateur utilisateur) {
        empruntableImp.empruntMagazine(magazine, utilisateur);
    }

    @Override
    public void empruntThese(TheseUniversitaire theseUniversitaire, Utilisateur utilisateur) {
        empruntableImp.empruntThese(theseUniversitaire, utilisateur);
    }

    @Override
    public void empruntJournal(JournalScientifique journalScientifique, Utilisateur utilisateur) {
        empruntableImp.empruntJournal(journalScientifique, utilisateur);
    }

    @Override
    public void retournerLivre(Livre livre, Utilisateur utilisateur) {
        empruntableImp.retournerLivre(livre, utilisateur);
    }

    @Override
    public void retournerMagazine(Magazine magazine, Utilisateur utilisateur) {
        empruntableImp.retournerMagazine(magazine, utilisateur);
    }

    @Override
    public void retournerThese(TheseUniversitaire theseUniversitaire, Utilisateur utilisateur) {
        empruntableImp.retournerThese(theseUniversitaire, utilisateur);
    }

    @Override
    public void retournerJournal(JournalScientifique journalScientifique, Utilisateur utilisateur) {
        empruntableImp.retournerJournal(journalScientifique, utilisateur);
    }
}