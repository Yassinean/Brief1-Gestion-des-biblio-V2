package org.example.service.Interface;

import org.example.metier.Abstract.Document;

import java.util.List;

public interface DocumentService {
    Document getDocumentById(Integer id);
    List<Document> getAllDocuments();
    void createDocument(Document document);
    void updateDocument(Integer id , Document document);
    void deleteDocument(Integer id);
}
