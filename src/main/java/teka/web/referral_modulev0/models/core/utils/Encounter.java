package teka.web.referral_modulev0.models.core.utils;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import teka.web.referral_modulev0.models.core.Hospital;
import teka.web.referral_modulev0.models.core.Visit;
import teka.web.referral_modulev0.models.core.users.Patient;
import teka.web.referral_modulev0.models.core.users.Person;
import teka.web.referral_modulev0.models.core.users.Physician;

import java.time.LocalDate;


@Data
@Entity
@Table(name = "encounter")
public class Encounter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "hospital_id", nullable = false)
    private Hospital hospital;

    @ManyToOne
    @JoinColumn(name = "physician_id", nullable = false)
    private Physician physician;

    @ManyToOne
    @JoinColumn(name = "visit_id", nullable = false)
    private Visit visit;


    @CreationTimestamp
    @Column(name = "encounter_date")
    private LocalDate date;

    @Column(name = "encounter_notes")
    private String notes;
}