package esprit.exam.clinique.controller;
import esprit.exam.clinique.entities.Clinique;
import esprit.exam.clinique.entities.Medecin;
import esprit.exam.clinique.repository.RendezVousRepository;
import esprit.exam.clinique.service.ICliniqueService;
import esprit.exam.clinique.service.IMedecinService;
import esprit.exam.clinique.service.IRendezVousService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/medecin")
public class MedecinController {
    private final IMedecinService iMedecinService;
    private final IRendezVousService iRendezVousService;

    @PostMapping("/ajouterMedecinAndAssignToClinique/{idClinique}")
    Medecin ajouterMedecinAndAssignToClinique(@RequestBody Medecin medecin, @PathVariable Long idClinique){
        return iMedecinService.addMedecinAndAssignToClinique(medecin,idClinique);
    }

    @GetMapping("/revenuMedecin/{idMedecin}/{startDate}/{endDate}")
    public int CalculRevenuMedecin(@PathVariable Long idMedecin, @PathVariable LocalDate startDate,@PathVariable LocalDate endDate){

        return iRendezVousService.getRevenusMedecin(idMedecin,startDate,endDate);
    }
}
