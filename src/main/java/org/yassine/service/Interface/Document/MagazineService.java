package org.yassine.service.Interface.Document;



import org.yassine.metier.Magazine;

import java.util.List;

public interface MagazineService {
    Magazine getMagazineById(Integer id);
    List<Magazine> getAllMagazines();
    void createMagazine(Magazine document);
    void updateMagazine(Integer id , Magazine document);
    void deleteMagazine(Integer id);
}
