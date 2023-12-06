package esprit.exam.clinique.service;

import esprit.exam.clinique.entities.Patient;
import esprit.exam.clinique.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService implements IPatientService {

    private final PatientRepository patientRepository;

    @Override
    public Patient addPatient(Patient patient) {
       return patientRepository.save(patient);
    }
}
