package org.yassine.service.Implementation.Document;

import org.yassine.metier.Livre;
import org.yassine.persistance.Interface.Document.LivreDaoInterface;
import org.yassine.service.Interface.Document.LivreService;

import java.util.List;

public class LivreServiceImp implements LivreService {
    private LivreDaoInterface livreDao;

    public LivreServiceImp(LivreDaoInterface livreDao) {
        this.livreDao = livreDao;
    }

    @Override
    public Livre getLivreById(Integer id) {
        return livreDao.displayLivre(id);
    }

    @Override
    public List<Livre> getLivreByTitre(String titre) {
        return livreDao.searchLivre(titre); // No need for casting
    }

    @Override
    public List<Livre> getAllLivres() {
        return livreDao.displayAllLivres();
    }

    @Override
    public void createLivre(Livre livre) {
        livreDao.createLivre(livre);
    }

    @Override
    public void updateLivre(Integer id, Livre livre) {
        livreDao.updateLivre(id , livre);
    }

    @Override
    public void deleteLivre(Integer id) {
        livreDao.deleteLivre(id);
    }
}