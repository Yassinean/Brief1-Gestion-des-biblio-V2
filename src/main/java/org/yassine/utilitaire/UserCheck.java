package org.yassine.utilitaire;

import org.yassine.model.Abstract.Document;
import org.yassine.model.Abstract.DroitAccess;
import org.yassine.model.Abstract.Utilisateur;
import org.yassine.model.Etudiant;
import org.yassine.model.Professeur;

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