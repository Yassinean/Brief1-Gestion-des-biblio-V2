package org.yassine.persistance.Interface.Document;

import org.yassine.metier.Livre;

import java.util.List;

public interface LivreDaoInterface {

    void createLivre(Livre livre);

    void updateLivre(Livre livre);

    void deleteLivre(Integer livreId);

    Livre displayLivre(Integer livreId);

    List<Livre> displayAllLivres();

    List<Livre> searchLivre(String titre);

}
