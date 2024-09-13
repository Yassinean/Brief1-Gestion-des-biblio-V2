package org.yassine;

import org.yassine.metier.Bibliotheque;
import org.yassine.persistance.Implementation.documentImp.JournalScientifiqueDaoImp;
import org.yassine.persistance.Implementation.documentImp.LivreDaoImp;
import org.yassine.persistance.Implementation.documentImp.MagazineDaoImp;
import org.yassine.persistance.Implementation.documentImp.TheseUniversitaireDaoImp;
import org.yassine.persistance.Implementation.userImp.EtudiantDaoImp;
import org.yassine.persistance.Interface.Document.JournalScientifiqueDaoInterface;
import org.yassine.persistance.Interface.Document.LivreDaoInterface;
import org.yassine.persistance.Interface.Document.MagazineDaoInterface;
import org.yassine.persistance.Interface.Document.TheseUniversitaireDaoInterface;
import org.yassine.persistance.Interface.Utilisateur.UtilisateurDaoInterface;
import org.yassine.presentation.ConsoleUI;
import org.yassine.service.Implementation.Document.LivreServiceImp;
import org.yassine.service.Implementation.Document.MagazineServiceImp;
import org.yassine.service.Implementation.Document.JournalScientifiqueServiceImp;
import org.yassine.service.Implementation.Document.TheseUniversitaireServiceImp;
import org.yassine.service.Implementation.UtilisateurServiceImp;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        UtilisateurDaoInterface utilisateurDao = new EtudiantDaoImp();
        LivreDaoInterface livreDao = new LivreDaoImp();
        MagazineDaoInterface magazineDao = new MagazineDaoImp();
        JournalScientifiqueDaoInterface journalScientifiqueDao = new JournalScientifiqueDaoImp();
        TheseUniversitaireDaoInterface theseUniversitaireDao = new TheseUniversitaireDaoImp();

        // Initialize services with DAO implementations
        UtilisateurServiceImp utilisateurService = new UtilisateurServiceImp(utilisateurDao);

        LivreServiceImp livreService = new LivreServiceImp(livreDao);
        MagazineServiceImp magazineService = new MagazineServiceImp(magazineDao);
        JournalScientifiqueServiceImp journalService = new JournalScientifiqueServiceImp(journalScientifiqueDao);
        TheseUniversitaireServiceImp theseService = new TheseUniversitaireServiceImp(theseUniversitaireDao);

        // Initialize Bibliotheque with services
        Bibliotheque bibliotheque = Bibliotheque.getInstance(utilisateurService, livreService , magazineService , journalService , theseService);

        // Initialize and start the ConsoleUI
        ConsoleUI ui = ConsoleUI.getInstance(bibliotheque,livreService, magazineService , journalService , theseService);
        ui.start();
    }
}