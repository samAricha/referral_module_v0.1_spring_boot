package teka.web.referral_modulev0.models.core.users;


import jakarta.persistence.*;
import lombok.Data;
import teka.web.referral_modulev0.models.core.Hospital;

@Data
@Entity
@Table(name = "referral_coordinator")
public class ReferralCoordinator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @OneToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    @Column(name = "coordinator_name")
    private String contactName;

    @Column(name = "coordinator_email")
    private String contactEmail;

    @Column(name = "coordinator_phone")
    private String contactPhone;

    @Column(name = "department")
    private String department;


}
