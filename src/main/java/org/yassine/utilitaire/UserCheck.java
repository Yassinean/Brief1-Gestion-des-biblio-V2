package org.yassine.utilitaire;

import org.yassine.metier.Abstract.Document;
import org.yassine.metier.Abstract.DroitAccess;
import org.yassine.metier.Abstract.Utilisateur;
import org.yassine.metier.Etudiant;
import org.yassine.metier.Professeur;

public class UserCheck {
    private UserCheck() {
    }

    public static boolean checkUserAccess(Document document, Utilisateur utilisateur) {
        DroitAccess access = document.getDroitAcces();
        if (access == DroitAccess.tout) {
            return true;
        } else if (access == DroitAccess.Professeur && utilisateur instanceof Professeur) {
            return true;
        } else if (access == DroitAccess.Etudiant && utilisateur instanceof Etudiant) {
            return true;
        } else {
            return false;
        }
    }
}