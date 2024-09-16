package org.yassine.service.Implementation;
import org.yassine.metier.*;
import org.yassine.metier.Abstract.Utilisateur;
import org.yassine.persistance.Implementation.EmpruntableDaoImp;
import org.yassine.service.Interface.EmpruntableService;
import java.util.logging.Logger;


public class EmpruntableServiceImp implements EmpruntableService {

    private static final Logger logger = Logger.getLogger(EmpruntableServiceImp.class.getName());
    private EmpruntableDaoImp empruntableImp;

    public EmpruntableServiceImp() {
        this.empruntableImp = new EmpruntableDaoImp();
    }

    @Override
    public void empruntLivre(Livre livre, Utilisateur utilisateur) {
        empruntableImp.empruntLivre(livre, utilisateur);
        logger.info("Emprunted livre Success");
    }

    @Override
    public void empruntMagazine(Magazine magazine, Utilisateur utilisateur) {
        empruntableImp.empruntMagazine(magazine, utilisateur);
        logger.info("Emprunted magazine Success");
    }

    @Override
    public void empruntThese(TheseUniversitaire theseUniversitaire, Utilisateur utilisateur) {
        empruntableImp.empruntThese(theseUniversitaire, utilisateur);
        logger.info("Emprunted these Success");
    }

    @Override
    public void empruntJournal(JournalScientifique journalScientifique, Utilisateur utilisateur) {
        empruntableImp.empruntJournal(journalScientifique, utilisateur);
        logger.info("Emprunted journal Success");
    }

    @Override
    public void retournerLivre(Livre livre, Utilisateur utilisateur) {
        empruntableImp.retournerLivre(livre, utilisateur);
        logger.info("Retour livre Success");
    }

    @Override
    public void retournerMagazine(Magazine magazine, Utilisateur utilisateur) {
        empruntableImp.retournerMagazine(magazine, utilisateur);
        logger.info("Retour magazine Success");
    }

    @Override
    public void retournerThese(TheseUniversitaire theseUniversitaire, Utilisateur utilisateur) {
        empruntableImp.retournerThese(theseUniversitaire, utilisateur);
        logger.info("Retour these Success");
    }

    @Override
    public void retournerJournal(JournalScientifique journalScientifique, Utilisateur utilisateur) {
        empruntableImp.retournerJournal(journalScientifique, utilisateur);
        logger.info("Retour journal Success");
    }
}