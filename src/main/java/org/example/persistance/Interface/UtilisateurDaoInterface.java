package org.example.persistance.Interface;

import org.example.metier.Utilisateur;

import java.util.List;
import java.util.UUID;

public interface UtilisateurDaoInterface {
    void createUtilisateur(Utilisateur utilisateur);
    void updateUtilisateur(Utilisateur utilisateur);
    void deleteUtilisateur(Integer utilisateurId);
    Utilisateur getUtilisateur(Integer utilisateurId);
    List<Utilisateur> getAllUtilisateurs();
}
