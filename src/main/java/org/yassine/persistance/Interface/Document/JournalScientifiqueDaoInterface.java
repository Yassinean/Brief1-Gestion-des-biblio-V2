package org.yassine.persistance.Interface.Document;

import org.yassine.metier.JournalScientifique;

import java.util.List;

public interface JournalScientifiqueDaoInterface {

    void createJournalScientifique(JournalScientifique journal);

    void updateJournalScientifique(JournalScientifique journal);

    void deleteJournalScientifique(Integer journalId);

    JournalScientifique displayJournalScientifique(Integer journalId);

    List<JournalScientifique> displayAllJournalScientifiques();

    List<JournalScientifique> searchJournalScientifique(String titre);


}
