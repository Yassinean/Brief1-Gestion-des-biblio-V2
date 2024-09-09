package org.example.persistance.Interface;

import java.util.UUID;

public interface EtudiantDaoInterface {
    public void createEtudiant(String id ,String email, String name);
    public void updateEtudiant();
    public boolean deleteEtudiant(String name);
    public void getEtudiant();
    public void getAllEtudiants();
}
