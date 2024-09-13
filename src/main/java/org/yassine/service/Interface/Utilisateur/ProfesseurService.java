package org.yassine.service.Interface.Utilisateur;


import org.yassine.metier.Professeur;

import java.util.List;

public interface ProfesseurService {
    Professeur getProfesseurById(Integer id);
    List<Professeur> getProfesseurByName(String name);
    List<Professeur> getAllProfesseurs();
    void createProfesseur(Professeur professeur);
    void updateProfesseur(Integer id , Professeur professeur);
    void deleteProfesseur(Integer id);
}
