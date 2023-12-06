package esprit.exam.clinique.repository;

import esprit.exam.clinique.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
}
