package teka.web.referral_modulev0.models.referral;

import jakarta.persistence.*;
import lombok.Data;
import teka.web.referral_modulev0.models.core.Appointment;
import teka.web.referral_modulev0.models.core.Hospital;
import teka.web.referral_modulev0.models.core.Visit;
import teka.web.referral_modulev0.models.core.users.Patient;

@Data
@Entity
@Table(name = "referrals")
public class Referral {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long referralId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = true)
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "referring_hospital_id", nullable = false)
    private Hospital referringHospital;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiving_hospital_id", nullable = false)
    private Hospital receivingHospital;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

    @OneToOne
    @JoinColumn(name = "referring_visit_id")
    private Visit referringVisitId;

    @OneToOne
    @JoinColumn(name = "receiving_visit_id")
    private Visit receivingVisitId;

    @Column(name = "reason_for_referral")
    private String reasonForReferral;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ReferralStatus status;

    //HERE WE ARE TO ADD THE REFERRAL TYPE


}

