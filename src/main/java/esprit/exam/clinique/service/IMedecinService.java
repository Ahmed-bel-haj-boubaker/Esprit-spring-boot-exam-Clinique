package esprit.exam.clinique.service;

import esprit.exam.clinique.entities.Medecin;

public interface IMedecinService {

    Medecin addMedecinAndAssignToClinique(Medecin medecin,Long idClinique);
}
