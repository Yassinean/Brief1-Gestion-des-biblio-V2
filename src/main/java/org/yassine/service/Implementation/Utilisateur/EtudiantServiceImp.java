package org.yassine.service.Implementation.Utilisateur;

import org.yassine.model.Etudiant;
import org.yassine.DAO.Interface.Utilisateur.EtudiantDaoInterface;
import org.yassine.service.Interface.Utilisateur.EtudiantService;

import java.util.List;

public class EtudiantServiceImp implements EtudiantService {

    private EtudiantDaoInterface etudiantDao;

    public EtudiantServiceImp(EtudiantDaoInterface etudiantDao){
        this.etudiantDao = etudiantDao;
    }

    @Override
    public Etudiant getEtudiantById(Integer id) {
        return etudiantDao.getEtudiantById(id);
    }

    @Override
    public List<Etudiant> getEtudiantByName(String name) {
        return etudiantDao.getEtudiantByName(name);
    }

    @Override
    public List<Etudiant> getAllEtudiants() {
        return etudiantDao.getAllEtudiants();
    }

    @Override
    public void createEtudiant(Etudiant etudiant) {
        if (etudiant.getName().isEmpty()){
            System.out.println("Le nom de l'etudiant est obligatoire");
        } else if (etudiant.getEmail().isEmpty()) {
            System.out.println("L'email de l'etudiant est obligatoire");
        }
        if (!etudiant.getEmail().contains("@")){
            System.out.println("L'adresse email n'est pas valide");
        }

        etudiantDao.createEtudiant(etudiant);
    }

    @Override
    public void updateEtudiant(Integer id, Etudiant etudiant) {
        Etudiant etudiantUpdate = etudiantDao.getEtudiantById(id);
        if (etudiantUpdate == null){
            System.out.println("Etudiant avec ID " + etudiant.getId() + " non trouve !");
        }

        etudiantDao.updateEtudiant(id , etudiantUpdate);
    }

    @Override
    public void deleteEtudiant(Integer id) {

        Etudiant etudiantDelete = etudiantDao.getEtudiantById(id);

        if (etudiantDelete == null){
            System.out.println("Etudiant avec ID " + id + " non trouve !");
        }
        etudiantDao.deleteEtudiant(id);

    }
}
