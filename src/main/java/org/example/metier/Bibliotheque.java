package org.example.metier;

import org.example.metier.Abstract.Document;
import org.example.metier.Abstract.Utilisateur;
import org.example.service.Interface.DocumentService;
import org.example.service.Interface.UtilisateurService;

import java.util.ArrayList;
import java.util.List;

public class Bibliotheque {

    private static Bibliotheque instance;

    private final UtilisateurService utilisateurService;
    private final DocumentService documentService;

    public Bibliotheque(UtilisateurService utilisateurService, DocumentService documentService /* Ajouter d'autres services ici */) {
        this.utilisateurService = utilisateurService;
        this.documentService = documentService;
    }

    public static Bibliotheque getInstance(UtilisateurService utilisateurService,DocumentService documentService /* Ajouter d'autres services ici */) {
        if (instance == null) {
            instance = new Bibliotheque(utilisateurService , documentService /* Passer d'autres services ici */);
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

    /* ============ Méthodes pour la gestion des documents ============*/
    public Document getDocumentById(Integer id){
        return documentService.getDocumentById(id);
    }
    public List<Document> getAllDocuments(){
        return documentService.getAllDocuments();
    }
    public void createDocument(Document document){
        documentService.createDocument(document);
    }
    public void updateDocument(Integer id,Document document){
        documentService.updateDocument(id,document);
    }
    public void deleteDocument(Integer id){
        documentService.deleteDocument(id);
    }
}

