package org.yassine.service.Implementation.Document;

import org.yassine.metier.JournalScientifique;
import org.yassine.persistance.Interface.Document.JournalScientifiqueDaoInterface;
import org.yassine.service.Interface.Document.JournalScientifiqueService;

import java.util.List;

public class JournalScientifiqueServiceImp implements JournalScientifiqueService {

    private JournalScientifiqueDaoInterface journalScientifiqueDao;

    public JournalScientifiqueServiceImp(JournalScientifiqueDaoInterface journalScientifiqueDao){
        this.journalScientifiqueDao = journalScientifiqueDao;
    }

    @Override
    public JournalScientifique getJournalScientifiqueById(Integer id) {
        return journalScientifiqueDao.displayJournalScientifique(id);
    }

    @Override
    public List<JournalScientifique> getJournalScientifiqueByTitre(String titre) {
        return journalScientifiqueDao.searchJournalScientifique(titre);
    }

    @Override
    public List<JournalScientifique> getAllJournalScientifiques() {
        return journalScientifiqueDao.displayAllJournalScientifiques();
    }

    @Override
    public void createJournalScientifique(JournalScientifique js) {
        journalScientifiqueDao.createJournalScientifique(js);
    }

    @Override
    public void updateJournalScientifique(Integer id, JournalScientifique js) {
        JournalScientifique magazineUpdate = journalScientifiqueDao.displayJournalScientifique(id);
        if (magazineUpdate == null){
            System.out.println("JournalScientifique avec ID " + id + " non trouve !");
        }

        magazineUpdate.setTitre(js.getTitre());
        magazineUpdate.setAuteur(js.getAuteur());
        magazineUpdate.setDatePublication(js.getDatePublication());
        magazineUpdate.setNombreDePages(js.getNombreDePages());

        journalScientifiqueDao.updateJournalScientifique(magazineUpdate);
    }

    @Override
    public void deleteJournalScientifique(Integer id) {

        JournalScientifique livreDelete = journalScientifiqueDao.displayJournalScientifique(id);

        if (livreDelete == null){
            System.out.println("JournalScientifique avec ID " + id + " non trouve !");
        }
        journalScientifiqueDao.deleteJournalScientifique(id);

    }
}
