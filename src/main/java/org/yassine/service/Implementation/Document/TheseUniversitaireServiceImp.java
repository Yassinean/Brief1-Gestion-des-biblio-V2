package org.yassine.service.Implementation.Document;


import org.yassine.model.TheseUniversitaire;
import org.yassine.DAO.Interface.Document.TheseUniversitaireDaoInterface;
import org.yassine.service.Interface.Document.TheseUniversitaireService;

import java.util.List;

public class TheseUniversitaireServiceImp implements TheseUniversitaireService {

    private TheseUniversitaireDaoInterface theseUniversitaireDao;

    public TheseUniversitaireServiceImp(TheseUniversitaireDaoInterface theseUniversitaireDao){
        this.theseUniversitaireDao = theseUniversitaireDao;
    }

    @Override
    public TheseUniversitaire getTheseUniversitaireById(Integer id) {
        return theseUniversitaireDao.displayTheseUniversitaire(id);
    }

    @Override
    public List<TheseUniversitaire> getTheseUniversitaireByTitre(String titre) {
        return theseUniversitaireDao.searchTheseUniversitaire(titre);
    }

    @Override
    public List<TheseUniversitaire> getAllTheseUniversitaires() {
        return theseUniversitaireDao.displayAllTheseUniversitaires();
    }

    @Override
    public void createTheseUniversitaire(TheseUniversitaire livre) {
        theseUniversitaireDao.createTheseUniversitaire(livre);
    }

    @Override
    public void updateTheseUniversitaire(Integer id, TheseUniversitaire livre) {
        TheseUniversitaire theseUpdate = theseUniversitaireDao.displayTheseUniversitaire(id);
        if (theseUpdate == null){
            System.out.println("These Universitaire avec ID " + id + " non trouve !");
        }

        theseUpdate.setTitre(livre.getTitre());
        theseUpdate.setAuteur(livre.getAuteur());
        theseUpdate.setDatePublication(livre.getDatePublication());
        theseUpdate.setNombreDePages(livre.getNombreDePages());

        theseUniversitaireDao.updateTheseUniversitaire(theseUpdate);
    }

    @Override
    public void deleteTheseUniversitaire(Integer id) {

        TheseUniversitaire livreDelete = theseUniversitaireDao.displayTheseUniversitaire(id);

        if (livreDelete == null){
            System.out.println("TheseUniversitaire avec ID " + id + " non trouve !");
        }
        theseUniversitaireDao.deleteTheseUniversitaire(id);

    }
}
