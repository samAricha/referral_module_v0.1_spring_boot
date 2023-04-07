package teka.web.referral_modulev0.models.core.utils;

import jakarta.persistence.*;

@Entity
@Table(name = "concepts")
public class Concept {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "concept_name")
    private String name;

    // getters and setters
}