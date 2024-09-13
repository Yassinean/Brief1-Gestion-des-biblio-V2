package org.yassine.service.Interface.Document;



import org.yassine.metier.TheseUniversitaire;

import java.util.List;

public interface TheseUniversitaireService {
    TheseUniversitaire getTheseUniversitaireById(Integer id);
    TheseUniversitaire getTheseUniversitaireByTitre(String titre);
    List<TheseUniversitaire> getAllTheseUniversitaires();
    void createTheseUniversitaire(TheseUniversitaire document);
    void updateTheseUniversitaire(Integer id , TheseUniversitaire document);
    void deleteTheseUniversitaire(Integer id);
}
