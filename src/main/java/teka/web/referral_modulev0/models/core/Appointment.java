package teka.web.referral_modulev0.models.core;

import jakarta.persistence.*;
import lombok.Data;
import teka.web.referral_modulev0.models.core.enums.AppointmentStatus;
import teka.web.referral_modulev0.models.core.enums.AppointmentType;
import teka.web.referral_modulev0.models.core.users.Patient;
import teka.web.referral_modulev0.models.core.users.Physician;
import org.hibernate.annotations.CreationTimestamp;
import teka.web.referral_modulev0.models.referral.Referral;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "referral_id")
    private Referral referral;

    @ManyToOne
    @JoinColumn(name = "physician_id")
    private Physician physician;

//    @Column(name = "appointment_date")
//    private LocalDateTime appointmentDate;

    @Column(name = "appointment_date")
    private LocalDate appointmentDate;

    @Column(name = "appointment_time")
    private LocalTime appointmentTime;

    @Column(name = "appointment_type")
    @Enumerated(EnumType.STRING)
    private AppointmentType appointmentType;

    @Column(name = "appointment_status")
    @Enumerated(EnumType.STRING)
    private AppointmentStatus appointmentStatus;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;


}