package org.yassine.service.Interface.Document;



import org.yassine.model.Livre;

import java.util.List;

public interface LivreService {
    Livre getLivreById(Integer id);
    List<Livre> getLivreByTitre(String titre);
    List<Livre> getAllLivres();
    void createLivre(Livre document);
    void updateLivre(Integer id , Livre document);
    void deleteLivre(Integer id);
}
