package teka.web.referral_modulev0.models.core;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import teka.web.referral_modulev0.dto.SubCountyDto;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "hospitals")
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private SubCountyDto location;

    @ManyToOne
    @JoinColumn(name = "level_id")
    private HospitalLevel level;


}