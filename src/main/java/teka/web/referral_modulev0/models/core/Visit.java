package teka.web.referral_modulev0.models.core;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import teka.web.referral_modulev0.models.core.enums.VisitStatus;
import teka.web.referral_modulev0.models.core.enums.VisitType;
import teka.web.referral_modulev0.models.core.users.Person;
import teka.web.referral_modulev0.models.core.users.Secretary;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "visits")
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "secretary_id", nullable = false)
    private Secretary secretary;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @Enumerated(EnumType.STRING)
    @Column(name = "visit_type", nullable = false)
    private VisitType visitType;

    @Enumerated(EnumType.STRING)
    @Column(name = "visit_status", nullable = false)
    private VisitStatus visitStatus;

    @CreationTimestamp
    @Column(name = "visit_time", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "visit_reason")
    private String reason;


}
