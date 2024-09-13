package org.yassine.service.Implementation.Utilisateur;


import org.yassine.metier.Professeur;
import org.yassine.persistance.Interface.Utilisateur.ProfesseurDaoInterface;

import java.util.List;

public class ProfesseurServiceImp implements ProfesseurDaoInterface {

    private ProfesseurDaoInterface professeurDao;

    public ProfesseurServiceImp(ProfesseurDaoInterface professeurDao) {
        this.professeurDao = professeurDao;
    }

    @Override
    public Professeur getProfesseurById(Integer id) {
        return professeurDao.getProfesseurById(id);
    }

    @Override
    public List<Professeur> getProfesseurByName(String name) {
        return professeurDao.getProfesseurByName(name);
    }

    @Override
    public List<Professeur> getAllProfesseurs() {
        return professeurDao.getAllProfesseurs();
    }

    @Override
    public void createProfesseur(Professeur professeur) {
        if (professeur.getName().isEmpty()) {
            System.out.println("Le nom du professeur est obligatoire");
        } else if (professeur.getEmail().isEmpty()) {
            System.out.println("L'email du professeur est obligatoire");
        }
        if (!professeur.getEmail().contains("@")) {
            System.out.println("L'adresse email n'est pas valide");
        }

        professeurDao.createProfesseur(professeur);
    }

    @Override
    public void updateProfesseur(Integer id, Professeur professeur) {
        Professeur professeurUpdate = professeurDao.getProfesseurById(id);
        if (professeurUpdate == null) {
            System.out.println("Professeur avec ID " + id + " non trouve !");
        }

        professeurUpdate.setName(professeur.getName());
        professeurUpdate.setEmail(professeur.getEmail());

        professeurDao.updateProfesseur(id, professeurUpdate);
    }

    @Override
    public void deleteProfesseur(Integer id) {

        Professeur professeurDelete = professeurDao.getProfesseurById(id);

        if (professeurDelete == null) {
            System.out.println("Professeur avec ID " + id + " non trouve !");
        }
        professeurDao.deleteProfesseur(id);

    }
}
