package org.yassine.utilitaire;

import java.util.regex.Pattern;

public class InputValidator {

    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return Pattern.compile(emailRegex).matcher(email).matches();
    }

    public static boolean isValidTitre(String titre) {
        return titre != null && !titre.trim().isEmpty();
    }

    public static boolean isValidAuteur(String auteur) {
        return auteur != null && !auteur.trim().isEmpty();
    }
}

