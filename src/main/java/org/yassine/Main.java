package org.yassine;

import org.yassine.metier.Bibliotheque;
import org.yassine.persistance.Implementation.documentImp.JournalScientifiqueDaoImp;
import org.yassine.persistance.Implementation.documentImp.LivreDaoImp;
import org.yassine.persistance.Implementation.documentImp.MagazineDaoImp;
import org.yassine.persistance.Implementation.documentImp.TheseUniversitaireDaoImp;
import org.yassine.persistance.Implementation.userImp.EtudiantDaoImp;
import org.yassine.persistance.Implementation.userImp.ProfesseurDaoImp;
import org.yassine.persistance.Interface.Document.JournalScientifiqueDaoInterface;
import org.yassine.persistance.Interface.Document.LivreDaoInterface;
import org.yassine.persistance.Interface.Document.MagazineDaoInterface;
import org.yassine.persistance.Interface.Document.TheseUniversitaireDaoInterface;
import org.yassine.persistance.Interface.Utilisateur.EtudiantDaoInterface;
import org.yassine.persistance.Interface.Utilisateur.ProfesseurDaoInterface;
import org.yassine.presentation.ConsoleUI;
import org.yassine.service.Implementation.Document.LivreServiceImp;
import org.yassine.service.Implementation.Document.MagazineServiceImp;
import org.yassine.service.Implementation.Document.JournalScientifiqueServiceImp;
import org.yassine.service.Implementation.Document.TheseUniversitaireServiceImp;
import org.yassine.service.Implementation.Utilisateur.EtudiantServiceImp;
import org.yassine.service.Implementation.Utilisateur.ProfesseurServiceImp;



import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws SQLException {

        EtudiantDaoInterface etudiantDao = new EtudiantDaoImp();
        ProfesseurDaoInterface professeurDao = new ProfesseurDaoImp();
        LivreDaoInterface livreDao = new LivreDaoImp();
        MagazineDaoInterface magazineDao = new MagazineDaoImp();
        JournalScientifiqueDaoInterface journalScientifiqueDao = new JournalScientifiqueDaoImp();
        TheseUniversitaireDaoInterface theseUniversitaireDao = new TheseUniversitaireDaoImp();


        EtudiantServiceImp etudiantService = new EtudiantServiceImp(etudiantDao);
        ProfesseurServiceImp professeurService =  new ProfesseurServiceImp(professeurDao);
        LivreServiceImp livreService = new LivreServiceImp(livreDao);
        MagazineServiceImp magazineService = new MagazineServiceImp(magazineDao);
        JournalScientifiqueServiceImp journalService = new JournalScientifiqueServiceImp(journalScientifiqueDao);
        TheseUniversitaireServiceImp theseService = new TheseUniversitaireServiceImp(theseUniversitaireDao);

        // Initialize Bibliotheque with services
        Bibliotheque bibliotheque = Bibliotheque.getInstance(livreService , magazineService , journalService , theseService , professeurService, etudiantService);

        // Initialize and start the ConsoleUI
        ConsoleUI ui = ConsoleUI.getInstance(bibliotheque, livreService, magazineService , journalService , theseService , professeurService, etudiantService);
        ui.start();

    }
}