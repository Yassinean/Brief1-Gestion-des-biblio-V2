package org.example.persistance.Interface;

import org.example.metier.Utilisateur;

import java.util.UUID;

public interface UtilisateurDaoInterface {
    public void createUtilisateur(Utilisateur utilisateur);
    public void updateUtilisateur();
    public boolean deleteUtilisateur(Integer utilisateurId);
    public void getUtilisateur();
    public void getAllUtilisateurs();
}
