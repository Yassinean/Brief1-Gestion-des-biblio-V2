package org.yassine.service.Interface.Utilisateur;

import org.yassine.metier.Abstract.Utilisateur;

import java.util.*;

public interface UtilisateurService {
    Utilisateur getUtilisateurById(Integer id);
    List<Utilisateur> getAllUtilisateurs();
    void createUtilisateur(Utilisateur utilisateur);
    void updateUtilisateur(Integer id , Utilisateur utilisateur);
    void deleteUtilisateur(Integer id);
}
