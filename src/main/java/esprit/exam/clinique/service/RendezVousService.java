package esprit.exam.clinique.service;

import esprit.exam.clinique.entities.Medecin;
import esprit.exam.clinique.entities.Patient;
import esprit.exam.clinique.entities.RendezVous;
import esprit.exam.clinique.entities.enums.Specialite;
import esprit.exam.clinique.repository.MedecinRepository;
import esprit.exam.clinique.repository.PatientRepository;
import esprit.exam.clinique.repository.RendezVousRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RendezVousService implements IRendezVousService {

    private final MedecinRepository medecinRepository;
    private final PatientRepository patientRepository;
    private final RendezVousRepository rendezVousRepository;

    @Override
    public void addRDVAndAssignMedAndPatient(RendezVous rendezVous, Long idMedecin, Long idPatient) {
        Medecin medecin = medecinRepository.findById(idMedecin).orElse(null);
        Patient patient = patientRepository.findById(idPatient).orElse(null);

        rendezVous.setMedecin(medecin);
        rendezVous.setPatient(patient);
        rendezVousRepository.save(rendezVous);
    }

    @Override
    public List<RendezVous> getRendezVousByCliniqueAndSpecialite(Long idClinique, Specialite specialite) {
        return rendezVousRepository.findByMedecinCliniquesIdCliniqueAndMedecinSpecialite(idClinique,specialite);
    }

    @Override
    public int getNbrRendezVousMedecin(Long idMedecin) {
        return rendezVousRepository.getcountRendezVousByMedecin(idMedecin);
    }

    @Override
    public int getRevenusMedecin(Long idMedecin, LocalDate startDate, LocalDate endDate) {
        Medecin medecin = medecinRepository.findById(idMedecin).orElse(null);

        assert medecin != null;
        return rendezVousRepository.countByMedecin_IdMedecinAndAndDateRDVBetween(idMedecin,startDate,endDate) * medecin.getPrixConsultation();
    }
}
