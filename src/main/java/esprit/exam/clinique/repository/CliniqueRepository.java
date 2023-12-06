package esprit.exam.clinique.repository;

import esprit.exam.clinique.entities.Clinique;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CliniqueRepository extends JpaRepository<Clinique,Long> {
}
