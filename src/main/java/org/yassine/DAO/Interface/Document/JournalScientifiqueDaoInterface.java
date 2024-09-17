package org.yassine.DAO.Interface.Document;

import org.yassine.model.JournalScientifique;

import java.util.List;

public interface JournalScientifiqueDaoInterface {

    void createJournalScientifique(JournalScientifique js);

    void updateJournalScientifique(Integer id ,JournalScientifique js);

    void deleteJournalScientifique(Integer jsId);

    JournalScientifique displayJournalScientifique(Integer jsId);

    List<JournalScientifique> displayAllJournalScientifiques();

    List<JournalScientifique> searchJournalScientifique(String titre);
}
