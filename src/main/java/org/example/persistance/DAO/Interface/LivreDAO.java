package org.example.persistance.DAO.Interface;

import org.example.persistance.DTO.LivreDTO;

import java.util.List;

public interface LivreDAO {
    LivreDTO getLivre(int id);
    void createLivre(String titre);
    void updateLivre(String titre);
    void deleteLivre(String titre);
    List<LivreDTO> getAllLivres();
}
