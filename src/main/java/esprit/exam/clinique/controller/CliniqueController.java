package esprit.exam.clinique.controller;

import esprit.exam.clinique.entities.Clinique;
import esprit.exam.clinique.service.ICliniqueService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clinique")
public class CliniqueController {
    private final ICliniqueService iCliniqueService;

    @PostMapping("/ajouterClinique")
    Clinique ajouterClinique(@RequestBody Clinique clinique){
        return iCliniqueService.addClinique(clinique);
    }
}
