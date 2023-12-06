package esprit.exam.clinique.service;

import esprit.exam.clinique.entities.RendezVous;
import esprit.exam.clinique.entities.enums.Specialite;

import java.time.LocalDate;
import java.util.List;

public interface IRendezVousService {
    void addRDVAndAssignMedAndPatient(RendezVous rendezVous, Long idMedecin, Long idPatient);
    public List<RendezVous> getRendezVousByCliniqueAndSpecialite(Long idClinique, Specialite specialite);
    int getNbrRendezVousMedecin(Long idMedecin);
    int getRevenusMedecin(Long idMedecin, LocalDate startDate,LocalDate endDate);
}
