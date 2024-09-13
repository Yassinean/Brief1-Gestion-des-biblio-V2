package org.yassine.service.Implementation.Document;

import org.yassine.metier.Magazine;
import org.yassine.persistance.Interface.Document.MagazineDaoInterface;
import org.yassine.service.Interface.Document.MagazineService;

import java.util.List;

public class MagazineServiceImp implements MagazineService {

    private MagazineDaoInterface magazineDao;

    public MagazineServiceImp(MagazineDaoInterface magazineDao) {
        this.magazineDao = magazineDao;
    }

    @Override
    public Magazine getMagazineById(Integer id) {
        return magazineDao.displayMagazine(id);
    }

    @Override
    public List <Magazine> getMagazineByTitre(String titre) {
        return (List<Magazine>) magazineDao.searchMagazine(titre);
    }

    @Override
    public List<Magazine> getAllMagazines() {
        return magazineDao.displayAllMagazines();
    }

    @Override
    public void createMagazine(Magazine magazine) {
        magazineDao.createMagazine(magazine);
    }

    @Override
    public void updateMagazine(Integer id, Magazine magazine) {
        magazineDao.updateMagazine(id, magazine);
    }

    @Override
    public void deleteMagazine(Integer id) {
        magazineDao.deleteMagazine(id);
    }
}
