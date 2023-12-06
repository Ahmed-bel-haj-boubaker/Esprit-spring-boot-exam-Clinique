package esprit.exam.clinique.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import esprit.exam.clinique.entities.enums.Specialite;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idMedecin")
public class Medecin implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idMedecin;

    String nomMedecin;

    @Enumerated(EnumType.STRING)
    Specialite specialite;

    int telephone;

    int prixConsultation;

    @ManyToMany(mappedBy = "medecins")
    Set<Clinique> cliniques;

    @OneToMany(mappedBy = "medecin")
    Set<RendezVous> rendezVous;
}
