package esprit.exam.clinique.controller;
import esprit.exam.clinique.entities.RendezVous;
import esprit.exam.clinique.entities.enums.Specialite;
import esprit.exam.clinique.repository.RendezVousRepository;
import esprit.exam.clinique.service.IRendezVousService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/rendezVous")
public class RendezVousController {

    private final IRendezVousService iRendezVousService;
    private final RendezVousRepository rendezVousRepository;

    @PostMapping("/addRDVAndAssignMedAndPatient/{idMedecin}/{idPatient}")
    public void addRDVAndAssignMedAndPatient(@RequestBody RendezVous rendezVous,@PathVariable Long idMedecin, @PathVariable Long idPatient){
        iRendezVousService.addRDVAndAssignMedAndPatient(rendezVous,idMedecin,idPatient);
    }
    @GetMapping("/{idClinique}/{specialite}")
    public List<RendezVous> getRendezVousByCliniqueAndSpecialite(@PathVariable Long idClinique,@PathVariable Specialite specialite){
        return iRendezVousService.getRendezVousByCliniqueAndSpecialite(idClinique,specialite);
    }
    @GetMapping("/getNbrRdv/{idMedecin}")
    public  int getNbrRendezVousMedecin(@PathVariable Long idMedecin){
        return iRendezVousService.getNbrRendezVousMedecin(idMedecin);
    }

    @Scheduled(cron = "*/30 * * * * *")
    public void retrieveRDV(){
        List<RendezVous> rendezVousList = rendezVousRepository.findAll();
        for (RendezVous rendezVous : rendezVousList){
            if (rendezVous.getDateRDV().isAfter(LocalDate.now())){
                log.info("La liste des rendez vous : "+rendezVous.getDateRDV()+ ": Medecin : "+rendezVous.getMedecin().getNomMedecin()+ ": Patient : "+ rendezVous.getPatient().getNomPatient());
            }
        }
    }

}
