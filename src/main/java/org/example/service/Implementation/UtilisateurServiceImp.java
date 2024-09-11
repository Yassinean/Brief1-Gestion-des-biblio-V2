package org.example.service.Implementation;

import org.example.metier.Abstract.Utilisateur;
import org.example.service.Interface.UtilisateurService;

import java.util.List;

public class UtilisateurServiceImp implements UtilisateurService {

    @Override
    public Utilisateur getUtilisateurById(Integer id) {
        return null;
    }

    @Override
    public List<Utilisateur> getAllUtilisateurs() {
        return List.of();
    }

    @Override
    public void createUtilisateur(Utilisateur utilisateur) {

    }

    @Override
    public void updateUtilisateur(Integer id, Utilisateur utilisateur) {

    }

    @Override
    public void deleteUtilisateur(Integer id) {

    }
}
