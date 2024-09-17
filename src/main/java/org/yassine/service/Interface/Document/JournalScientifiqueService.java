package org.yassine.service.Interface.Document;



import org.yassine.model.JournalScientifique;

import java.util.List;

public interface JournalScientifiqueService {
    JournalScientifique getJournalScientifiqueById(Integer id);
    List<JournalScientifique> getJournalScientifiqueByTitre(String titre);
    List<JournalScientifique> getAllJournalScientifiques();
    void createJournalScientifique(JournalScientifique document);
    void updateJournalScientifique(Integer id , JournalScientifique document);
    void deleteJournalScientifique(Integer id);
}
