package org.example.persistance.Interface;

import org.example.metier.Utilisateur;

import java.util.List;

public interface UtilisateurDaoInterface {
    void createUtilisateur(Utilisateur utilisateur);
    void updateUtilisateur(Utilisateur utilisateur);
    void deleteUtilisateur(Integer utilisateurId);
    Utilisateur getUtilisateur(Integer utilisateurId);
    List<Utilisateur> getAllUtilisateurs();
}
