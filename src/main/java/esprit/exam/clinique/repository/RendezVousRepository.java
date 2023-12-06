package esprit.exam.clinique.repository;

import esprit.exam.clinique.entities.RendezVous;
import esprit.exam.clinique.entities.enums.Specialite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface RendezVousRepository extends JpaRepository<RendezVous,Long> {


    //keyword
    List<RendezVous>findByMedecinCliniquesIdCliniqueAndMedecinSpecialite( Long idClinique, Specialite specialite);

    @Query("SELECT r FROM RendezVous r JOIN r.medecin.cliniques c WHERE c.idClinique = :idClinique AND r.medecin.specialite = :specialite")
    List<RendezVous> getRendezVousByCliniqueAndSpecialite(@Param("idClinique") Long idClinique, @Param("specialite") Specialite specialite);


    @Query("select count(r) from RendezVous r where r.medecin.idMedecin= :idMedecin")
    int getcountRendezVousByMedecin(@Param("idMedecin") Long idMedecin);

    int countByMedecin_IdMedecinAndAndDateRDVBetween(Long idMedecin, LocalDate startDate,LocalDate endDate);
}
