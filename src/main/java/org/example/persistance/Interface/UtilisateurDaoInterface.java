package org.example.persistance.Interface;

import org.example.metier.Utilisateur;

import java.util.UUID;

public interface UtilisateurDaoInterface {
    void createUtilisateur(Utilisateur utilisateur);
    void updateUtilisateur();
    void deleteUtilisateur(Integer utilisateurId);
    Utilisateur getUtilisateur(Integer utilisateurId);
    void getAllUtilisateurs();
}
