package esprit.exam.clinique.service;

import esprit.exam.clinique.entities.Clinique;
import esprit.exam.clinique.repository.CliniqueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CliniqueService implements ICliniqueService{
    private final CliniqueRepository cliniqueRepository;
    @Override
    public Clinique addClinique(Clinique clinique) {
        return cliniqueRepository.save(clinique);
    }
}
