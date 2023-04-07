package teka.web.referral_modulev0.models.core.utils;

import jakarta.persistence.*;
import lombok.Data;
import teka.web.referral_modulev0.models.core.users.Person;

@Data
@Entity
@Table(name = "observation")
public class Observation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "obs_id")
    private Long obsId;

    private String observation;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "encounter_id", referencedColumnName = "id")
    private Encounter encounter;
}