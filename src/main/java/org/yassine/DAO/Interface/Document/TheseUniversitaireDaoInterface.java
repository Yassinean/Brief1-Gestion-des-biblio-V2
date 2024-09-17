package org.yassine.DAO.Interface.Document;

import org.yassine.model.TheseUniversitaire;

import java.util.List;

public interface TheseUniversitaireDaoInterface {

    void createTheseUniversitaire(TheseUniversitaire these);

    void updateTheseUniversitaire(TheseUniversitaire these);

    void deleteTheseUniversitaire(Integer theseId);

    TheseUniversitaire displayTheseUniversitaire(Integer theseId);

    List<TheseUniversitaire> displayAllTheseUniversitaires();

    List<TheseUniversitaire> searchTheseUniversitaire(String titre);

}
