package org.yassine.persistance.Interface.Utilisateur;



import org.yassine.metier.Professeur;

import java.util.List;

public interface ProfesseurDaoInterface {
    void createProfesseur(Professeur professeur);
    void updateProfesseur(Integer id , Professeur professeur);
    void deleteProfesseur(Integer professeurId);

    Professeur getProfesseurById(Integer id);
    List<Professeur> getProfesseurByName(String name);

    List<Professeur> getAllProfesseurs();

}
