package edu.esprit.iservices;



import edu.esprit.entities.Reclamation;

import java.util.List;

public interface IReclamationService {
    void addReclamation(Reclamation reclamation);
    void updateReclamation(Reclamation reclamation);
    void deleteReclamation(Reclamation reclamation);
    List<Reclamation> getReclamations();
    Reclamation findReclamationById(int id);
    Reclamation findReclamationByIdUser(int idUser);
    Reclamation findReclamationByTypeObjet(String typeObjet);
}
