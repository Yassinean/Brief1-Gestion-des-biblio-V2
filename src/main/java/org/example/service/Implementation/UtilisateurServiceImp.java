package org.example.service.Implementation;

import org.example.metier.Abstract.Utilisateur;
import org.example.persistance.Interface.UtilisateurDaoInterface;
import org.example.service.Interface.UtilisateurService;

import java.util.List;

public class UtilisateurServiceImp implements UtilisateurService {

    private UtilisateurDaoInterface utilisateurDao;

    public UtilisateurServiceImp(UtilisateurDaoInterface utilisateurDao){
        this.utilisateurDao = utilisateurDao;
    }

    @Override
    public Utilisateur getUtilisateurById(Integer id) {
        return utilisateurDao.getUtilisateur(id);
    }

    @Override
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurDao.getAllUtilisateurs();
    }

    @Override
    public void createUtilisateur(Utilisateur utilisateur) {
        if (utilisateur.getName().isEmpty()){
            System.out.println("Le nom de l'utilisateur est obligatoire");
        } else if (utilisateur.getEmail().isEmpty()) {
            System.out.println("L'email de l'utilisateur est obligatoire");
        }
        if (!utilisateur.getEmail().contains("@")){
            System.out.println("L'adresse email n'est pas valide");
        }

        utilisateurDao.createUtilisateur(utilisateur);
    }

    @Override
    public void updateUtilisateur(Integer id, Utilisateur utilisateur) {
        Utilisateur utilisateurUpdate = utilisateurDao.getUtilisateur(id);
        if (utilisateurUpdate == null){
            System.out.println("Utilisateur avec ID " + id + " non trouve !");
        }

        utilisateurUpdate.setName(utilisateur.getName());
        utilisateurUpdate.setEmail(utilisateur.getEmail());

        utilisateurDao.updateUtilisateur(utilisateurUpdate);
    }

    @Override
    public void deleteUtilisateur(Integer id) {

        Utilisateur utilisateurDelete = utilisateurDao.getUtilisateur(id);

        if (utilisateurDelete == null){
            System.out.println("Utilisateur avec ID " + id + " non trouve !");
        }
        utilisateurDao.deleteUtilisateur(id);

    }
}
