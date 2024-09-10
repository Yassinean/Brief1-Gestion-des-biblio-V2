package org.example.persistance.Interface;

import org.example.metier.Document;

import java.util.List;

public interface DocumentDaoInterface {

    void createDocument(Document document);
    void updateDocument(Document document);
    void deleteDocument(Integer documentId);
    void displayDocument(Integer documentId);
    List<Document> displayAllDocuments();
    List<Document>searchDocument(String titre);

}
