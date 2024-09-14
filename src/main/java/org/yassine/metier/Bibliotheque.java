package org.yassine.metier;



import org.yassine.service.Interface.Document.JournalScientifiqueService;
import org.yassine.service.Interface.Document.LivreService;
import org.yassine.service.Interface.Document.MagazineService;
import org.yassine.service.Interface.Document.TheseUniversitaireService;
import org.yassine.service.Interface.Utilisateur.EtudiantService;
import org.yassine.service.Interface.Utilisateur.ProfesseurService;

import java.util.List;

public class Bibliotheque {

    private static Bibliotheque instance;

    private final ProfesseurService professeurService;
    private final EtudiantService etudiantService;
    private final LivreService livreService;
    private final MagazineService magazineService;
    private final JournalScientifiqueService journalService;
    private final TheseUniversitaireService theseService;


    public Bibliotheque(LivreService livreService, MagazineService magazineService, JournalScientifiqueService journalService, TheseUniversitaireService theseService ,ProfesseurService professeurService, EtudiantService etudiantService) {
        this.livreService = livreService;
        this.magazineService = magazineService;
        this.journalService = journalService;
        this.theseService = theseService;
        this.professeurService = professeurService;
        this.etudiantService = etudiantService;
    }

    public static Bibliotheque getInstance(LivreService livreService, MagazineService magazineService, JournalScientifiqueService journalService, TheseUniversitaireService theseService ,ProfesseurService professeurService, EtudiantService etudiantService) {
        if (instance == null) {
            instance = new Bibliotheque(livreService, magazineService, journalService, theseService,professeurService, etudiantService);
        }
        return instance;
    }


    /* ============ Méthodes pour la gestion des professeurs ============*/
    public Professeur getProfesseurById(Integer id) {
        return professeurService.getProfesseurById(id);
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
    /* ============ Fin méthodes pour la gestion des professeur ============*/

    /* ============ Méthodes pour la gestion des etudiants ============*/
    public Etudiant getEtudiantById(Integer id) {
        return etudiantService.getEtudiantById(id);
    }

    public List<Etudiant> getAllEtudiants() {
        return etudiantService.getAllEtudiants();
    }

    public void createEtudiant(Etudiant etudiant) {
        etudiantService.createEtudiant(etudiant);
    }

    public void updateEtudiant(Etudiant etudiant) {
        etudiantService.updateEtudiant(etudiant);
    }

    public void deleteEtudiant(Integer id) {
        etudiantService.deleteEtudiant(id);
    }
    /* ============ Fin méthodes pour la gestion des etudiants ============*/

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
    /* ============ Fin méthodes pour la gestion des magazines ============*/

    /* ============ Méthodes pour la gestion des journalScientifiques ============*/
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

