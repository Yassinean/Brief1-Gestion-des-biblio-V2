package org.yassine.DAO.Interface.Utilisateur;

import org.yassine.model.Etudiant;

import java.util.List;

public interface EtudiantDaoInterface {
    void createEtudiant(Etudiant etudiant);
    void updateEtudiant(Integer id, Etudiant etudiant);
    void deleteEtudiant(Integer etudiantId);
    Etudiant getEtudiantById(Integer etudiantId);
    List<Etudiant> getEtudiantByName(String name);
    List<Etudiant> getAllEtudiants();
}
