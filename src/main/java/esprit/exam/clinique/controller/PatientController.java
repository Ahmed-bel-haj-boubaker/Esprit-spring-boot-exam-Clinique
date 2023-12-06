package esprit.exam.clinique.controller;

import esprit.exam.clinique.entities.Patient;
import esprit.exam.clinique.service.IPatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/patient")
public class PatientController {
    private final IPatientService iPatientService;

    @PostMapping("/ajouterPatient")
    Patient addPatient(@RequestBody Patient patient){
        return iPatientService.addPatient(patient);
    }
}
