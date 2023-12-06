package esprit.exam.clinique.service;

import esprit.exam.clinique.entities.Clinique;
import esprit.exam.clinique.entities.Medecin;
import esprit.exam.clinique.repository.CliniqueRepository;
import esprit.exam.clinique.repository.MedecinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MedecinService implements IMedecinService {
    private final MedecinRepository medecinRepository;
    private  final CliniqueRepository cliniqueRepository;
    @Override
    public Medecin addMedecinAndAssignToClinique(Medecin medecin, Long idClinique) {

        Clinique clinique= cliniqueRepository.findById(idClinique).orElse(null);

        clinique.getMedecins().add(medecin);
        return medecinRepository.save(medecin);
    }
}
