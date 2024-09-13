package org.yassine.metier;

import org.yassine.metier.Abstract.Utilisateur;
import org.yassine.service.Interface.Document.JournalScientifiqueService;
import org.yassine.service.Interface.Document.LivreService;
import org.yassine.service.Interface.Document.MagazineService;
import org.yassine.service.Interface.Document.TheseUniversitaireService;
import org.yassine.service.Interface.Utilisateur.UtilisateurService;

import java.util.List;

public class Bibliotheque {

    private static Bibliotheque instance;

    private final UtilisateurService utilisateurService;
    private final LivreService livreService;
    private final MagazineService magazineService;
    private final JournalScientifiqueService journalService;
    private final TheseUniversitaireService theseService;


    public Bibliotheque(UtilisateurService utilisateurService, LivreService livreService, MagazineService magazineService, JournalScientifiqueService journalService, TheseUniversitaireService theseService) {
        this.utilisateurService = utilisateurService;
        this.livreService = livreService;
        this.magazineService = magazineService;
        this.journalService = journalService;
        this.theseService = theseService;
    }

    public static Bibliotheque getInstance(UtilisateurService utilisateurService, LivreService livreService, MagazineService magazineService, JournalScientifiqueService journalService, TheseUniversitaireService theseService) {
        if (instance == null) {
            instance = new Bibliotheque(utilisateurService, livreService, magazineService, journalService, theseService);
        }
        return instance;
    }

    /* ============ Méthodes pour la gestion des utilisateurs ============*/
    public Utilisateur getUtilisateurById(Integer id) {
        return utilisateurService.getUtilisateurById(id);
    }

    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurService.getAllUtilisateurs();
    }

    public void createUtilisateur(Utilisateur utilisateur) {
        utilisateurService.createUtilisateur(utilisateur);
    }

    public void updateUtilisateur(Integer id, Utilisateur utilisateur) {
        utilisateurService.updateUtilisateur(id, utilisateur);
    }

    public void deleteUtilisateur(Integer id) {
        utilisateurService.deleteUtilisateur(id);
    }
    /* ============ Fin méthodes pour la gestion des utilisateurs ============*/

    /* ============ Méthodes pour la gestion des livres ============*/
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
    /* ============ Fin méthodes pour la gestion des livres ============*/

    /* ============ Méthodes pour la gestion des magazines ============*/
    public Magazine getMagazineById(Integer id) {
        return magazineService.getMagazineById(id);
    }

    public List <Magazine> getMagazineByTitre(String titre) {
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
    /* ============ Fin méthodes pour la gestion des magazines ============*/

    /* ============ Méthodes pour la gestion des journalScientifiques ============*/
    public JournalScientifique getJournalScientifiqueById(Integer id) {
        return journalService.getJournalScientifiqueById(id);
    }

    public List <JournalScientifique> getJournalScientifiqueByTitre(String titre) {
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
    /* ============ Fin méthodes pour la gestion des journalScientifiques ============*/

    /* ============ Méthodes pour la gestion des theseUniversitaires ============*/
    public TheseUniversitaire getTheseUniversitaireById(Integer id) {
        return theseService.getTheseUniversitaireById(id);
    }

    public TheseUniversitaire getTheseUniversitaireByTitre(String titre) {
        return theseService.getTheseUniversitaireByTitre(titre);
    }

    public List<TheseUniversitaire> getAllTheseUniversitaires() {
        return theseService.getAllTheseUniversitaires();
    }

    public void createTheseUniversitaire(TheseUniversitaire livre) {
        theseService.createTheseUniversitaire(livre);
    }

    public void updateTheseUniversitaire(Integer id, TheseUniversitaire livre) {
        theseService.updateTheseUniversitaire(id, livre);
    }

    public void deleteTheseUniversitaire(Integer id) {
        theseService.deleteTheseUniversitaire(id);
    }
    /* ============ Fin méthodes pour la gestion des theseUniversitaires ============*/
}

