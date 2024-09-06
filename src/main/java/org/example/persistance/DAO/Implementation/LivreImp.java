package org.example.persistance.DAO.Implementation;

import org.example.persistance.DAO.Interface.LivreDAO;
import org.example.persistance.DTO.LivreDTO;

import java.util.List;

public class LivreImp implements LivreDAO {
    @Override
    public LivreDTO getLivre(int id) {
        return null;
    }

    @Override
    public void createLivre(String titre) {

    }

    @Override
    public void updateLivre(String titre) {

    }

    @Override
    public void deleteLivre(String titre) {

    }

    @Override
    public List<LivreDTO> getAllLivres() {
        return List.of();
    }
}
