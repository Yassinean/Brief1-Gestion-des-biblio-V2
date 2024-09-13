package org.yassine.presentation;

import org.yassine.metier.*;
import org.yassine.service.Implementation.Document.JournalScientifiqueServiceImp;
import org.yassine.service.Implementation.Document.LivreServiceImp;
import org.yassine.service.Implementation.Document.MagazineServiceImp;
import org.yassine.service.Implementation.Document.TheseUniversitaireServiceImp;
import org.yassine.service.Interface.Document.JournalScientifiqueService;
import org.yassine.service.Interface.Document.LivreService;
import org.yassine.service.Interface.Document.MagazineService;
import org.yassine.service.Interface.Document.TheseUniversitaireService;
import org.yassine.service.Interface.Utilisateur.EtudiantService;
import org.yassine.service.Interface.Utilisateur.ProfesseurService;


import java.util.List;
import java.util.Scanner;

public class ConsoleUI {

    private static ConsoleUI instance;
    private Scanner scanner;
    private Bibliotheque bibliotheque;


    private ConsoleUI(Bibliotheque bibliotheque) {
        scanner = new Scanner(System.in);
        this.bibliotheque = bibliotheque;
    }

    public static ConsoleUI getInstance(Bibliotheque bibliotheque, LivreService livreService, MagazineService magazineService, JournalScientifiqueService journalScientifiqueService, TheseUniversitaireService theseUniversitaireService, ProfesseurService professeurService, EtudiantService etudiantService) {
        if (instance == null) {
            instance = new ConsoleUI(bibliotheque);
        }
        return instance;
    }

    public void start() {
        boolean exit = false;
        while (!exit) {
            printMenu();
            int choice = getIntInput("Choisissez une option: ");
            switch (choice) {
                case 1:
                    gestionDocuments();
                    break;
                case 2:
                    gestionUtilisateurs();
                    break;
                case 3:
//                    gestionEmprunts();
                    break;
                case 4:
//                    gestionReservations();
                    break;
                case 0:
                    exit = true;
                    System.out.println("Au revoir!");
                    break;
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        }
        scanner.close();
    }

    private void printMenu() {
        System.out.println("\n=== SYSTÈME DE GESTION DE BIBLIOTHÈQUE ===");
        System.out.println("1. Gestion des documents");
        System.out.println("2. Gestion des utilisateurs");
        System.out.println("0. Quitter");
    }

    /* ====================== Gestion des documents ======================*/
    private void gestionDocuments() {
        System.out.println("\n=== GESTION DES DOCUMENTS ===");
        System.out.println("1. Ajouter un document");
        System.out.println("2. Modifier un document");
        System.out.println("3. Supprimer un document");
        System.out.println("4. Rechercher un document");
        System.out.println("5. Emprunter un document");
        System.out.println("6. Reserver un document");
        System.out.println("0. Retour au menu principal");

        int choice = getIntInput("Choisissez une option: ");
        switch (choice) {
            case 1:
                ajouterDocument();
                break;
            case 2:
                modifierDocument();
                break;
            case 3:
                supprimerDocument();
                break;
            case 4:
                rechercherDocument();
                break;
            case 5:
                emprunterDocument();
                break;
            case 6:
                reserverDocument();
                break;
            case 0:
                // Retour au menu principal
                break;
            default:
                System.out.println("Option invalide. Veuillez réessayer.");
        }
    }

    /* ============ Creation des documents ============*/
    private void ajouterDocument() {
        System.out.println("\n=== AJOUTER UN DOCUMENT ===");
        System.out.println("1. Livre");
        System.out.println("2. Magazine");
        System.out.println("3. Journal Scientifique");
        System.out.println("4. These Universitaire");

        int typeChoix = getIntInput("Choisissez le type de document: ");

        switch (typeChoix) {
            case 1:
                creerLivre();
                break;
            case 2:
                creerMagazine();
                break;
            case 3:
                creerJournalScientifique();
                break;
            case 4:
                creerTheseUniversitaire();
                break;
            default:
                System.out.println("Type de document invalide.");
                return;
        }

    }

    private void creerLivre() {
        System.out.println("=== AJOUTER UN LIVRE ===");
        String titre = getStringInput("Entrez le titre du livre: ");
        scanner.nextLine();
        String auteur = getStringInput("Entrez l'auteur du livre: ");
        scanner.nextLine();
        String datePublication = getStringInput("Entrez la date de publication du livre: ");
        scanner.nextLine();
        int nombreDePage = getIntInput("Entrez le nombre de page du livre: ");
        scanner.nextLine();
        String isbn = getStringInput("Entrez l'ISBN du livre: ");
        Livre livre = new Livre(titre, auteur, datePublication, nombreDePage, isbn);
        bibliotheque.createLivre(livre);
        System.out.println("Livre : " + titre + " est cree avec succes");
    }

    private void creerMagazine() {
        System.out.println("=== AJOUTER UN MAGAZINE ===");
        String titre = getStringInput("Entrez le titre du magazine: ");
        scanner.nextLine();
        String auteur = getStringInput("Entrez l'auteur du magazine: ");
        scanner.nextLine();
        String datePublication = getStringInput("Entrez la date de publication du magazine: ");
        scanner.nextLine();
        int nombreDePage = getIntInput("Entrez le nombre de page du magazine: ");
        scanner.nextLine();
        int numero = getIntInput("Entrez le numero du magazine: ");
        scanner.nextLine();
        Magazine magazine = new Magazine(titre, auteur, datePublication, nombreDePage, numero);
        bibliotheque.createMagazine(magazine);
        System.out.println("Magazine : " + titre + " est cree avec succes");
    }

    private void creerJournalScientifique() {
        System.out.println("=== AJOUTER UN JOURNAL SCIENTIFIQUE ===");
        String titre = getStringInput("Entrez le titre du jounal: ");
        scanner.nextLine();
        String auteur = getStringInput("Entrez l'auteur du journal: ");
        scanner.nextLine();
        String datePublication = getStringInput("Entrez la date de publication du journal: ");
        scanner.nextLine();
        int nombreDePage = getIntInput("Entrez le nombre de page du journal: ");
        scanner.nextLine();
        String domaine = getStringInput("Entrez le domaine du journal: ");
        scanner.nextLine();
        JournalScientifique journalS = new JournalScientifique(titre, auteur, datePublication, nombreDePage, domaine);
        bibliotheque.createJournalScientifique(journalS);
        System.out.println("Journal : " + titre + " est cree avec succes");
    }

    private void creerTheseUniversitaire() {
        System.out.println("=== AJOUTER UN THESE UNIVERSITAIRE ===");
        String titre = getStringInput("Entrez le titre du these: ");
        scanner.nextLine();
        String auteur = getStringInput("Entrez l'auteur du these: ");
        scanner.nextLine();
        String datePublication = getStringInput("Entrez la date de publication du these: ");
        scanner.nextLine();
        int nombreDePage = getIntInput("Entrez le nombre de page du these: ");
        scanner.nextLine();
        String universite = getStringInput("Entrez le universite du these: ");
        scanner.nextLine();
        String domaine = getStringInput("Entrez le domaine du these: ");
        scanner.nextLine();
        TheseUniversitaire theseU = new TheseUniversitaire(titre, auteur, datePublication, nombreDePage, universite, domaine);
        bibliotheque.createTheseUniversitaire(theseU);
        System.out.println("These : " + titre + " est cree avec succes");
    }
    /* ============ Fin creation des documents ============*/

    /* ============ Modification des documents ============*/
    private void modifierDocument() {
        System.out.println("\n=== MODIFIER UN DOCUMENT ===");
        System.out.println("1. Livre");
        System.out.println("2. Magazine");
        System.out.println("3. Journal Scientifique");
        System.out.println("4. These Universitaire");

        int typeChoix = getIntInput("Choisissez le type de document à modifier: ");

        switch (typeChoix) {
            case 1:
                modifierLivre();
                break;
            case 2:
                modifierMagazine();
                break;
            case 3:
                modifierJournalScientifique();
                break;
            case 4:
                modifierTheseUniversitaire();
                break;
            default:
                System.out.println("Type de document invalide.");
        }
    }

    private void modifierLivre() {
        System.out.println("=== MODIFIER UN LIVRE ===");
        int id = getIntInput("Entrez l'ID du livre à modifier: ");
        Livre livre = bibliotheque.getLivreById(id);
        if (livre != null) {
            System.out.println("1. Modifier le titre");
            System.out.println("2. Modifier l'auteur");
            System.out.println("3. Modifier la date de publication");
            System.out.println("4. Modifier le nombre de pages");
            System.out.println("5. Modifier l'ISBN");

            int choix = getIntInput("Choisissez l'attribut à modifier: ");
            switch (choix) {
                case 1:
                    String nouveauTitre = getStringInput("Entrez le nouveau titre: ");
                    livre.setTitre(nouveauTitre);
                    break;
                case 2:
                    String nouvelAuteur = getStringInput("Entrez le nouvel auteur: ");
                    livre.setAuteur(nouvelAuteur);
                    break;
                case 3:
                    String nouvelleDate = getStringInput("Entrez la nouvelle date de publication: ");
                    livre.setDatePublication(nouvelleDate);
                    break;
                case 4:
                    int nouveauNombreDePages = getIntInput("Entrez le nouveau nombre de pages: ");
                    livre.setNombreDePages(nouveauNombreDePages);
                    break;
                case 5:
                    String nouvelIsbn = getStringInput("Entrez le nouvel ISBN: ");
                    livre.setIsbn(nouvelIsbn);
                    break;
                default:
                    System.out.println("Option invalide.");
                    return;
            }
            bibliotheque.updateLivre(id, livre);
            System.out.println("Livre : " + livre.getTitre() + " modifié avec succès.");
        } else {
            System.out.println("Livre introuvable.");
        }
    }

    private void modifierMagazine() {
        System.out.println("=== MODIFIER UN MAGAZINE ===");
        int id = getIntInput("Entrez l'ID du magazine à modifier: ");
        Magazine magazine = bibliotheque.getMagazineById(id);
        if (magazine != null) {
            System.out.println("1. Modifier le titre");
            System.out.println("2. Modifier l'auteur");
            System.out.println("3. Modifier la date de publication");
            System.out.println("4. Modifier le nombre de pages");
            System.out.println("5. Modifier le numero");

            int choix = getIntInput("Choisissez l'attribut à modifier: ");
            switch (choix) {
                case 1:
                    String nouveauTitre = getStringInput("Entrez le nouveau titre: ");
                    magazine.setTitre(nouveauTitre);
                    break;
                case 2:
                    String nouvelAuteur = getStringInput("Entrez le nouvel auteur: ");
                    magazine.setAuteur(nouvelAuteur);
                    break;
                case 3:
                    String nouvelleDate = getStringInput("Entrez la nouvelle date de publication: ");
                    magazine.setDatePublication(nouvelleDate);
                    break;
                case 4:
                    int nouveauNombreDePages = getIntInput("Entrez le nouveau nombre de pages: ");
                    magazine.setNombreDePages(nouveauNombreDePages);
                    break;
                case 5:
                    int nouvelNumero = getIntInput("Entrez le nouvel Numero: ");
                    magazine.setNumero(nouvelNumero);
                    break;
                default:
                    System.out.println("Option invalide.");
                    return;
            }
            bibliotheque.updateMagazine(id, magazine);
            System.out.println("Magazine : " + magazine.getTitre() + " modifié avec succès.");
        } else {
            System.out.println("Magazine introuvable.");
        }
    }

    private void modifierJournalScientifique() {
        System.out.println("=== MODIFIER UN JOURNAL SCIENTIFIQUE ===");
        int id = getIntInput("Entrez l'ID  du journal à modifier: ");
        JournalScientifique journal = bibliotheque.getJournalScientifiqueById(id);
        if (journal != null) {
            System.out.println("1. Modifier le titre");
            System.out.println("2. Modifier l'auteur");
            System.out.println("3. Modifier la date de publication");
            System.out.println("4. Modifier le nombre de pages");
            System.out.println("5. Modifier le domaine de recherche");

            int choix = getIntInput("Choisissez l'attribut à modifier: ");
            switch (choix) {
                case 1:
                    String nouveauTitre = getStringInput("Entrez le nouveau titre: ");
                    journal.setTitre(nouveauTitre);
                    break;
                case 2:
                    String nouvelAuteur = getStringInput("Entrez le nouvel auteur: ");
                    journal.setAuteur(nouvelAuteur);
                    break;
                case 3:
                    String nouvelleDate = getStringInput("Entrez la nouvelle date de publication: ");
                    journal.setDatePublication(nouvelleDate);
                    break;
                case 4:
                    int nouveauNombreDePages = getIntInput("Entrez le nouveau nombre de pages: ");
                    journal.setNombreDePages(nouveauNombreDePages);
                    break;
                case 5:
                    String nouvelDomaine = getStringInput("Entrez le nouvel domaine de recherche: ");
                    journal.setDomaine(nouvelDomaine);
                    break;
                default:
                    System.out.println("Option invalide.");
            }
            bibliotheque.updateJournalScientifique(id, journal);
            System.out.println("Jounal : " + journal.getTitre() + " modifié avec succès.");
        } else {
            System.out.println("Journal introuvable.");
        }
    }

    private void modifierTheseUniversitaire() {
        System.out.println("=== MODIFIER UN THESE UNIVERSITAIRE ===");
        int id = getIntInput("Entrez l'ID  du these à modifier: ");
        TheseUniversitaire these = bibliotheque.getTheseUniversitaireById(id);
        if (these != null) {
            System.out.println("1. Modifier le titre");
            System.out.println("2. Modifier l'auteur");
            System.out.println("3. Modifier la date de publication");
            System.out.println("4. Modifier le nombre de pages");
            System.out.println("5. Modifier l'universite'");
            System.out.println("6. Modifier le domaine de recherche");

            int choix = getIntInput("Choisissez l'attribut à modifier: ");
            switch (choix) {
                case 1:
                    String nouveauTitre = getStringInput("Entrez le nouveau titre: ");
                    these.setTitre(nouveauTitre);
                    break;
                case 2:
                    String nouvelAuteur = getStringInput("Entrez le nouvel auteur: ");
                    these.setAuteur(nouvelAuteur);
                    break;
                case 3:
                    String nouvelleDate = getStringInput("Entrez la nouvelle date de publication: ");
                    these.setDatePublication(nouvelleDate);
                    break;
                case 4:
                    int nouveauNombreDePages = getIntInput("Entrez le nouveau nombre de pages: ");
                    these.setNombreDePages(nouveauNombreDePages);
                    break;
                case 5:
                    String nouvelUniversite = getStringInput("Entrez le nouvel universite: ");
                    these.setDomaine(nouvelUniversite);
                    break;
                case 6:
                    String nouvelDomaine = getStringInput("Entrez le nouvel domaine de recherche: ");
                    these.setDomaine(nouvelDomaine);
                    break;
                default:
                    System.out.println("Option invalide.");
            }
            bibliotheque.updateTheseUniversitaire(id, these);
            System.out.println("These : " + these.getTitre() + " modifié avec succès.");
        } else {
            System.out.println("Theses introuvable.");
        }
    }

    /* ============ Fin modification des documents ============*/

    /* ============ Suppression des documents ============*/

    private void supprimerDocument() {
        System.out.println("=== SUPPRIMER UN DOCUMENT ===");
        System.out.println("1. Livre");
        System.out.println("2. Magazine");
        System.out.println("3. Journal Scientifique");
        System.out.println("4. These Universitaire");

        int typeChoix = getIntInput("Choisissez le type de document à modifier: ");

        switch (typeChoix) {
            case 1:
                supprimerLivre();
                break;
            case 2:
                supprimerMagazine();
                break;
            case 3:
                supprimerJournalScientifique();
                break;
            case 4:
                supprimerTheseUniversitaire();
                break;
            default:
                System.out.println("Type de document invalide.");
        }
    }

    private void supprimerLivre() {
        int idLivre = getIntInput("Entrer l'ID du livre que vous voulez supprimer");
        bibliotheque.deleteLivre(idLivre);
        System.out.println("Livre supprimee avec succes");
    }

    private void supprimerMagazine() {
        int idMagazine = getIntInput("Entrer l'ID du magazine que vous voulez supprimer");
        bibliotheque.deleteMagazine(idMagazine);
        System.out.println("Magazine supprimee avec succes");
    }

    private void supprimerJournalScientifique() {
        int idJournal = getIntInput("Entrer l'ID du journal que vous voulez supprimer");
        bibliotheque.deleteJournalScientifique(idJournal);
        System.out.println("Journale scientifique supprimee avec succes");
    }

    private void supprimerTheseUniversitaire() {
        int idThese = getIntInput("Entrer l'ID du these que vous voulez supprimer");
        bibliotheque.deleteTheseUniversitaire(idThese);
        System.out.println("These universitaire supprimee avec succes");
    }

    /* ============ Fin suppression des documents ============*/

    /* ============ Recherche des documents ============*/
    private void rechercherDocument() {
        System.out.println("=== RECHERCHER UN DOCUMENT ===");
        System.out.println("Sélectionnez le type de document à rechercher :");
        System.out.println("1. Livre");
        System.out.println("2. Magazine");
        System.out.println("3. Journal Scientifique");
        System.out.println("4. Thèse Universitaire");
        System.out.println("5. Retour au menu principal");

        int choix = scanner.nextInt();
        scanner.nextLine();

        switch (choix) {
            case 1:
                rechercherLivre();
                break;
            case 2:
                rechercherMagazine();
                break;
            case 3:
                rechercherJournalScientifique();
                break;
            case 4:
                rechercherTheseUniversitaire();
                break;
            case 5:
                System.out.println("Retour au menu principal.");
                return;
            default:
                System.out.println("Choix invalide, veuillez réessayer.");
                rechercherDocument();
                break;
        }
    }

    private void rechercherLivre() {
        System.out.println("Entrez le titre du livre à rechercher :");
        String titre = scanner.nextLine();
        List<Livre> resultats = (List<Livre>) bibliotheque.getLivreByTitre(titre);
        if (resultats.isEmpty()) {
            System.out.println("Aucun livre trouvé pour le titre : " + titre);
        } else {
            System.out.println("Livres trouvés :");
            for (Livre livre : resultats) {
                System.out.println(livre.afficherDetails());
            }
        }
    }

    private void rechercherMagazine() {
        System.out.println("Entrez le titre du magazine à rechercher :");
        String titre = scanner.nextLine();
        List<Magazine> resultats = (List<Magazine>) bibliotheque.getMagazineByTitre(titre);
        if (resultats.isEmpty()) {
            System.out.println("Aucun magazine trouvé pour le titre : " + titre);
        } else {
            System.out.println("Magazines trouvés :");
            for (Magazine magazine : resultats) {
                System.out.println(magazine.afficherDetails());
            }
        }
    }

    private void rechercherJournalScientifique() {
        System.out.println("Entrez le titre du journal scientifique à rechercher :");
        String titre = scanner.nextLine();

        List<JournalScientifique> resultats = (List<JournalScientifique>) bibliotheque.getJournalScientifiqueByTitre(titre);
        if (resultats.isEmpty()) {
            System.out.println("Aucun journal scientifique trouvé pour le titre : " + titre);
        } else {
            System.out.println("Journaux scientifiques trouvés :");
            for (JournalScientifique journal : resultats) {
                System.out.println(journal.afficherDetails());
            }
        }
    }

    private void rechercherTheseUniversitaire() {
        System.out.println("Entrez le titre de la thèse universitaire à rechercher :");
        String titre = scanner.nextLine();

        List<TheseUniversitaire> resultats = (List<TheseUniversitaire>) bibliotheque.getTheseUniversitaireByTitre(titre);
        if (resultats.isEmpty()) {
            System.out.println("Aucune thèse universitaire trouvée pour le titre : " + titre);
        } else {
            System.out.println("Thèses universitaires trouvées :");
            for (TheseUniversitaire these : resultats) {
                System.out.println(these.afficherDetails());
            }
        }
    }
    /* ============ Fin recherche des documents ============*/

    private void emprunterDocument() {
        System.out.println("=== EMPRUNTER UN DOCUMENT ===");
        // Implement search logic
    }

    private void reserverDocument() {
        System.out.println("=== RESERVER UN DOCUMENT ===");
        // Implement search logic
    }
    /* ====================== Fin gestion des documents ======================*/

    /* ====================== Gestion des utilisateur ======================*/
    private void gestionUtilisateurs() {
        System.out.println("\n=== GESTION DES Utilisateur ===");
        System.out.println("1. Ajouter un utilisateur");
        System.out.println("2. Modifier un utilisateur");
        System.out.println("3. Supprimer un utilisateur");
        System.out.println("4. Rechercher un utilisateur");
        System.out.println("0. Retour au menu principal");

        int choice = getIntInput("Choisissez une option: ");
        switch (choice) {
            case 1:
                ajouterUtilisateur();
                break;
            case 2:
//                modifierUtilisateur();
                break;
            case 3:
//                supprimerUtilisateur();
                break;
            case 4:
//                rechercherUtilisateur();
                break;
            case 0:
                // Retour au menu principal
                break;
            default:
                System.out.println("Option invalide. Veuillez réessayer.");
        }
    }

    /* ============ Creation des documents ============*/
    private void ajouterUtilisateur() {
        System.out.println("\n=== AJOUTER UN UTILISATEUR ===");
        System.out.println("1. Professeur");
        System.out.println("2. Etudiant");

        int typeChoix = getIntInput("Choisissez le type de document: ");

        switch (typeChoix) {
            case 1:
                creerProfesseur();
                break;
            case 2:
                creerEtudiant();
                break;
            default:
                System.out.println("Type d'utilisateur invalide.");
                return;
        }
    }

    private void creerProfesseur() {
        System.out.println("=== AJOUTER UN PROFESSEUR ===");
        String name = getStringInput("Entrez le nom du professeur: ");
        scanner.nextLine();
        String email = getStringInput("Entrez l'email du professeur: ");
        scanner.nextLine();
        String matiere = getStringInput("Entrez la matiere du professeur: ");
        scanner.nextLine();
        Professeur prof = new Professeur(name,email,matiere);
        bibliotheque.createProfesseur(prof);
        System.out.println("Professeur : Mr. " + name + " est ajoute avec succes");
    }

    private void creerEtudiant() {
        System.out.println("=== AJOUTER UN ETUDIANT ===");
        String name = getStringInput("Entrez le nom de l'etudiant : ");
        scanner.nextLine();
        String email = getStringInput("Entrez l'email de l'etudiant : ");
        scanner.nextLine();
        String branche = getStringInput("Entrez la branche de l'etudiant : ");
        scanner.nextLine();
        Etudiant etudiant = new Etudiant(name,email,branche);
        bibliotheque.createEtudiant(etudiant);
        System.out.println("Etudiant : Mr. " + name + " est ajoute avec succes");
    }

    /* ============ Fin creation des utilisateur ============*/
    /* ============ Modification des utilisateur ============*/
    private void modifierUtilisateur() {
        System.out.println("\n=== MODIFIER UN UTILISATEUR ===");
        System.out.println("1. Professeur");
        System.out.println("2. Etudiant");

        int typeChoix = getIntInput("Choisissez le type de document: ");

        switch (typeChoix) {
            case 1:
                modifierProfesseur();
                break;
            case 2:
                modifierEtudiant();
                break;
            default:
                System.out.println("Type d'utilisateur invalide.");
                return;
        }
    }

    private void modifierEtudiant() {
        System.out.println("=== MODIFIER UN ETUDIANT ===");
        int id = getIntInput("Entrez l'ID de l'etudiant à modifier: ");
        Etudiant etudiant = bibliotheque.getEtudiantById(id);
        if (etudiant != null) {
            System.out.println("1. Modifier le nom");
            System.out.println("2. Modifier l'email");
            System.out.println("3. Modifier la branche");

            int choix = getIntInput("Choisissez l'attribut à modifier: ");
            switch (choix) {
                case 1:
                    String nouveauName = getStringInput("Entrez le nouveau nom: ");
                    etudiant.setName(nouveauName);
                    break;
                case 2:
                    String nouvelEmail = getStringInput("Entrez le nouvel email: ");
                    etudiant.setEmail(nouvelEmail);
                    break;
                case 3:
                    String nouvelleBranche = getStringInput("Entrez la nouvelle branche: ");
                    etudiant.setBranche(nouvelleBranche);
                    break;
                default:
                    System.out.println("Option invalide.");
                    return;
            }
            bibliotheque.updateEtudiant(id, etudiant);
            System.out.println("Etudiant : Mr. " + etudiant.getName() + " modifié avec succès.");
        } else {
            System.out.println("Etudiant introuvable.");
        }
    }

    private void modifierProfesseur() {
        System.out.println("=== MODIFIER UN PROFESSEUR ===");
        int id = getIntInput("Entrez l'ID du professeur à modifier: ");
        Professeur professeur = bibliotheque.getProfesseurById(id);
        if (professeur != null) {
            System.out.println("1. Modifier le nom");
            System.out.println("2. Modifier l'email");
            System.out.println("3. Modifier la matiere");

            int choix = getIntInput("Choisissez l'attribut à modifier: ");
            switch (choix) {
                case 1:
                    String nouveauName = getStringInput("Entrez le nouveau nom: ");
                    professeur.setName(nouveauName);
                    break;
                case 2:
                    String nouvelEmail = getStringInput("Entrez le nouvel email: ");
                    professeur.setEmail(nouvelEmail);
                    break;
                case 3:
                    String nouvelleMatiere = getStringInput("Entrez la nouvelle matiere: ");
                    professeur.setMatiere(nouvelleMatiere);
                    break;
                default:
                    System.out.println("Option invalide.");
                    return;
            }
            bibliotheque.updateProfesseur(id, professeur);
            System.out.println("Professeur : Mr. " + professeur.getName() + " modifié avec succès.");
        } else {
            System.out.println("Professeur introuvable.");
        }
    }

    /* ============ Fin creation des documents ============*/


    /* ====================== Fin gestion des utilisateur ======================*/
    private int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Veuillez entrer un nombre valide.");
            System.out.print(prompt);
            scanner.next();
        }
        return scanner.nextInt();
    }

    public String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.next();
    }
}
