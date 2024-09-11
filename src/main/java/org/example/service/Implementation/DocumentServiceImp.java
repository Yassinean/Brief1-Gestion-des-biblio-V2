package org.example.service.Implementation;

import org.example.metier.Abstract.Document;
import org.example.metier.Abstract.Utilisateur;
import org.example.persistance.Interface.DocumentDaoInterface;
import org.example.service.Interface.DocumentService;

import java.util.List;

public class DocumentServiceImp implements DocumentService {

    private DocumentDaoInterface documentDao;

    public DocumentServiceImp(DocumentDaoInterface documentDao){
        this.documentDao = documentDao;
    }

    @Override
    public Document getDocumentById(Integer id) {
        return documentDao.displayDocument(id);
    }

    @Override
    public List<Document> getAllDocuments() {
        return documentDao.displayAllDocuments();
    }

    @Override
    public void createDocument(Document document) {
        documentDao.createDocument(document);
    }

    @Override
    public void updateDocument(Integer id, Document document) {
        Document documentUpdate = documentDao.displayDocument(id);
        if (documentUpdate == null){
            System.out.println("Utilisateur avec ID " + id + " non trouve !");
        }

        documentUpdate.setTitre(document.getTitre());
        documentUpdate.setAuteur(document.getAuteur());
        documentUpdate.setDatePublication(document.getDatePublication());
        documentUpdate.setNombreDePages(document.getNombreDePages());

        documentDao.updateDocument(documentUpdate);
    }

    @Override
    public void deleteDocument(Integer id) {

        Document documentDelete = documentDao.displayDocument(id);

        if (documentDelete == null){
            System.out.println("Utilisateur avec ID " + id + " non trouve !");
        }
        documentDao.deleteDocument(id);

    }
}
