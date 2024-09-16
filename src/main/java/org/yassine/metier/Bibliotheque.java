package org.yassine.metier;

import org.yassine.metier.Abstract.Document;
import org.yassine.metier.Abstract.Utilisateur;
import org.yassine.persistance.Implementation.EmpruntableDaoImp;
import org.yassine.persistance.Implementation.ReservableImp;
import org.yassine.service.Implementation.EmpruntableServiceImp;
import org.yassine.service.Implementation.ReservableServiceImp;
import org.yassine.service.Interface.Document.JournalScientifiqueService;
import org.yassine.service.Interface.Document.LivreService;
import org.yassine.service.Interface.Document.MagazineService;
import org.yassine.service.Interface.Document.TheseUniversitaireService;
import org.yassine.service.Interface.EmpruntableService;
import org.yassine.service.Interface.ReservableService;
import org.yassine.service.Interface.Utilisateur.EtudiantService;
import org.yassine.service.Interface.Utilisateur.ProfesseurService;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Bibliotheque {

    private static Bibliotheque instance;

    private final ProfesseurService professeurService;
    private final EtudiantService etudiantService;
    private final LivreService livreService;
    private final MagazineService magazineService;
    private final JournalScientifiqueService journalService;
    private final TheseUniversitaireService theseService;
    private final EmpruntableService docEmprunt = new EmpruntableServiceImp();
    private final ReservableService docReserve = new ReservableServiceImp();
    private final Map<Integer, Document> documentMap = new HashMap<>();
    private final Map<Integer, Utilisateur> utilisateurMap = new HashMap<>();

    private static final Logger logger = Logger.getLogger(Bibliotheque.class.getName());

    public Bibliotheque(LivreService livreService, MagazineService magazineService, JournalScientifiqueService journalService, TheseUniversitaireService theseService, ProfesseurService professeurService, EtudiantService etudiantService) {
        this.livreService = livreService;
        this.magazineService = magazineService;
        this.journalService = journalService;
        this.theseService = theseService;
        this.professeurService = professeurService;
        this.etudiantService = etudiantService;
    }

    public static Bibliotheque getInstance(LivreService livreService, MagazineService magazineService, JournalScientifiqueService journalService, TheseUniversitaireService theseService, ProfesseurService professeurService, EtudiantService etudiantService) {
        if (instance == null) {
            instance = new Bibliotheque(livreService, magazineService, journalService, theseService, professeurService, etudiantService);
        }
        return instance;
    }

    /* ============ Méthodes pour la gestion des professeurs ============ */
    public Professeur getProfesseurById(Integer id) {
        return professeurService.getProfesseurById(id);
    }

    public List<Professeur> getProfesseurByName(String name) {
        return professeurService.getProfesseurByName(name);
    }

    public List<Professeur> getAllProfesseurs() {
        return professeurService.getAllProfesseurs();
    }

    public void createProfesseur(Professeur professeur) {
        professeurService.createProfesseur(professeur);
    }

    public void updateProfesseur(Integer id, Professeur professeur) {
        professeurService.updateProfesseur(id, professeur);
    }

    public void deleteProfesseur(Integer id) {
        professeurService.deleteProfesseur(id);
    }
    /* ============ Fin méthodes pour la gestion des professeurs ============ */

    /* ============ Méthodes pour la gestion des etudiants ============ */
    public Etudiant getEtudiantById(Integer id) {
        return etudiantService.getEtudiantById(id);
    }

    public List<Etudiant> getEtudiantByName(String name) {
        return etudiantService.getEtudiantByName(name);
    }

    public List<Etudiant> getAllEtudiants() {
        return etudiantService.getAllEtudiants();
    }

    public void createEtudiant(Etudiant etudiant) {
        etudiantService.createEtudiant(etudiant);
    }

    public void updateEtudiant(Integer id, Etudiant etudiant) {
        etudiantService.updateEtudiant(id, etudiant);
    }

    public void deleteEtudiant(Integer id) {
        etudiantService.deleteEtudiant(id);
    }
    /* ============ Fin méthodes pour la gestion des étudiants ============ */

    /* ============ Méthodes pour la gestion des livres ============ */
    public Livre getLivreById(Integer id) {
        return livreService.getLivreById(id);
    }

    public List<Livre> getLivreByTitre(String titre) {
        return livreService.getLivreByTitre(titre);
    }

    public List<Livre> getAllLivres() {
        return livreService.getAllLivres();
    }

    public void createLivre(Livre livre) {
        livreService.createLivre(livre);
    }

    public void updateLivre(Integer id, Livre livre) {
        livreService.updateLivre(id, livre);
    }

    public void deleteLivre(Integer id) {
        livreService.deleteLivre(id);
    }
    /* ============ Fin méthodes pour la gestion des livres ============ */

    /* ============ Méthodes pour la gestion des magazines ============ */
    public Magazine getMagazineById(Integer id) {
        return magazineService.getMagazineById(id);
    }

    public List<Magazine> getMagazineByTitre(String titre) {
        return magazineService.getMagazineByTitre(titre);
    }

    public List<Magazine> getAllMagazines() {
        return magazineService.getAllMagazines();
    }

    public void createMagazine(Magazine magazine) {
        magazineService.createMagazine(magazine);
    }

    public void updateMagazine(Integer id, Magazine magazine) {
        magazineService.updateMagazine(id, magazine);
    }

    public void deleteMagazine(Integer id) {
        magazineService.deleteMagazine(id);
    }
    /* ============ Fin méthodes pour la gestion des magazines ============ */

    /* ============ Méthodes pour la gestion des journaux scientifiques ============ */
    public JournalScientifique getJournalScientifiqueById(Integer id) {
        return journalService.getJournalScientifiqueById(id);
    }

    public List<JournalScientifique> getJournalScientifiqueByTitre(String titre) {
        return journalService.getJournalScientifiqueByTitre(titre);
    }

    public List<JournalScientifique> getAllJournalScientifiques() {
        return journalService.getAllJournalScientifiques();
    }

    public void createJournalScientifique(JournalScientifique journal) {
        journalService.createJournalScientifique(journal);
    }

    public void updateJournalScientifique(Integer id, JournalScientifique journal) {
        journalService.updateJournalScientifique(id, journal);
    }

    public void deleteJournalScientifique(Integer id) {
        journalService.deleteJournalScientifique(id);
    }
    /* ============ Fin méthodes pour la gestion des journaux scientifiques ============ */

    /* ============ Méthodes pour la gestion des theses universitaires ============ */
    public TheseUniversitaire getTheseUniversitaireById(Integer id) {
        return theseService.getTheseUniversitaireById(id);
    }

    public List <TheseUniversitaire> getTheseUniversitaireByTitre(String titre) {
        return theseService.getTheseUniversitaireByTitre(titre);
    }

    public List<TheseUniversitaire> getAllTheseUniversitaires() {
        return theseService.getAllTheseUniversitaires();
    }

    public void createTheseUniversitaire(TheseUniversitaire these) {
        theseService.createTheseUniversitaire(these);
    }

    public void updateTheseUniversitaire(Integer id, TheseUniversitaire these) {
        theseService.updateTheseUniversitaire(id, these);
    }

    public void deleteTheseUniversitaire(Integer id) {
        theseService.deleteTheseUniversitaire(id);
    }
    /* ============ Fin méthodes pour la gestion des theses universitaires ============ */

    /* ============ Méthodes pour la gestion des documents et utilisateurs "HashMap & stream api" ============ */
    public void addDocument(Document document) {
        documentMap.put(document.getId(), document);
    }

    public void addUtilisateur(Utilisateur utilisateur) {
        utilisateurMap.put(utilisateur.getId(), utilisateur);
    }

    public Document getDocumentById(Integer id) {
        Livre livre = livreService.getLivreById(id);
        if (livre != null) {
            return livre;
        }

        Magazine magazine = magazineService.getMagazineById(id);
        if (magazine != null) {
            return magazine;
        }

        JournalScientifique journal = journalService.getJournalScientifiqueById(id);
        if (journal != null) {
            return journal;
        }

        TheseUniversitaire these = theseService.getTheseUniversitaireById(id);
        if (these != null) {
            return these;
        }

        return documentMap.get(id);
    }

    public Utilisateur getUtilisateurById(Integer id) {

        // premiere chose soit avoir est ce que le prof n'est pas null
        Professeur professeur = professeurService.getProfesseurById(id);
        if (professeur != null) {
            return professeur;
        }

        // apres, try to find an Etudiant
        Etudiant etudiant = etudiantService.getEtudiantById(id);
        if (etudiant != null) {
            return etudiant;
        }

        // If not found in both services, fallback to the utilisateurMap
        return utilisateurMap.get(id);
    }

    public List<Document> getAllDocuments() {
        return new ArrayList<>(documentMap.values());
    }

    public List<Utilisateur> getAllUtilisateurs() {
        return new ArrayList<>(utilisateurMap.values());
    }

    public List<Document> searchDocumentByTitle(String title) {
        return documentMap.values().stream()
                .filter(doc -> doc.getTitre().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }

    public List<Utilisateur> searchUtilisateurByName(String name) {
        return utilisateurMap.values().stream()
                .filter(user -> user.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }
    /* ============ Fin méthodes pour la gestion des documents et utilisateurs ============ */

    /* ============ Méthodes pour la gestion des emprunts et réservations ============ */
    public void empruntDocument(Document document, Utilisateur utilisateur) {
        if (document instanceof Livre livre) {
            docEmprunt.empruntLivre(livre, utilisateur);
        } else if (document instanceof Magazine magazine) {
            docEmprunt.empruntMagazine(magazine, utilisateur);
        } else if (document instanceof TheseUniversitaire theseUniversitaire) {
            docEmprunt.empruntThese(theseUniversitaire, utilisateur);
        } else if (document instanceof JournalScientifique journalScientifique) {
            docEmprunt.empruntJournal(journalScientifique, utilisateur);
        } else {
            logger.log(Level.WARNING, "Type de document inconnu pour l'emprunt.");
        }
    }

    public void reserveDocument(Document document, Utilisateur utilisateur) {
        if (document instanceof Livre livre) {
            docReserve.reserveLivre(livre, utilisateur);
        } else if (document instanceof Magazine magazine) {
            docReserve.reserveMagazine(magazine, utilisateur);
        } else if (document instanceof TheseUniversitaire theseUniversitaire) {
            docReserve.reserveThese(theseUniversitaire, utilisateur);
        } else if (document instanceof JournalScientifique journalScientifique) {
            docReserve.reserveJournal(journalScientifique, utilisateur);
        } else {
            logger.log(Level.WARNING, "Type de document inconnu pour la réservation.");
        }
    }

    public void retournerDocument(Document document, Utilisateur utilisateur) {
        if (document instanceof Livre livre) {
            docEmprunt.retournerLivre(livre, utilisateur);
        } else if (document instanceof Magazine magazine) {
            docEmprunt.retournerMagazine(magazine, utilisateur);
        } else if (document instanceof TheseUniversitaire theseUniversitaire) {
            docEmprunt.retournerThese(theseUniversitaire, utilisateur);
        } else if (document instanceof JournalScientifique journalScientifique) {
            docEmprunt.retournerJournal(journalScientifique, utilisateur);
        } else {
            logger.log(Level.WARNING, "Type de document inconnu pour le retour.");
        }
    }

    public void annuleReserveDocument(Document document, Utilisateur utilisateur) {
        if (document instanceof Livre livre) {
            docReserve.annuleReserveLivre(livre, utilisateur);
        } else if (document instanceof Magazine magazine) {
            docReserve.annuleReserveMagazine(magazine, utilisateur);
        } else if (document instanceof TheseUniversitaire theseUniversitaire) {
            docReserve.annuleReserveThese(theseUniversitaire, utilisateur);
        } else if (document instanceof JournalScientifique journalScientifique) {
            docReserve.annuleReserveJournal(journalScientifique, utilisateur);
        } else {
            logger.log(Level.WARNING, "Type de document inconnu pour l'annulation de la réservation.");
        }
    }

    private void handleDocumentOperation(Document document, Utilisateur utilisateur, String operation) {
        if (document instanceof Livre livre) {
            switch (operation) {
                case "emprunt" -> docEmprunt.empruntLivre(livre, utilisateur);
                case "reserve" -> docReserve.reserveLivre(livre, utilisateur);
                case "retourner" -> docEmprunt.retournerLivre(livre, utilisateur);
                case "annuleReserve" -> docReserve.annuleReserveLivre(livre, utilisateur);
            }
        } else if (document instanceof Magazine magazine) {
            switch (operation) {
                case "emprunt" -> docEmprunt.empruntMagazine(magazine, utilisateur);
                case "reserve" -> docReserve.reserveMagazine(magazine, utilisateur);
                case "retourner" -> docEmprunt.retournerMagazine(magazine, utilisateur);
                case "annuleReserve" -> docReserve.annuleReserveMagazine(magazine, utilisateur);
            }
        } else if (document instanceof JournalScientifique journal) {
            switch (operation) {
                case "emprunt" -> docEmprunt.empruntJournal(journal, utilisateur);
                case "reserve" -> docReserve.reserveJournal(journal, utilisateur);
                case "retourner" -> docEmprunt.retournerJournal(journal, utilisateur);
                case "annuleReserve" -> docReserve.annuleReserveJournal(journal, utilisateur);
            }
        } else if (document instanceof TheseUniversitaire thess) {
            switch (operation) {
                case "emprunt" -> docEmprunt.empruntThese(thess, utilisateur);
                case "reserve" -> docReserve.reserveThese(thess, utilisateur);
                case "retourner" -> docEmprunt.retournerThese(thess, utilisateur);
                case "annuleReserve" -> docReserve.annuleReserveThese(thess, utilisateur);
            }
        } else {
            logger.log(Level.WARNING, "Unknown document type for operation: " + operation);
        }
    }
    /* ============ Fin méthodes pour la gestion des emprunts et réservations ============ */
}
