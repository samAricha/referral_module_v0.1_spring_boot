package teka.web.referral_modulev0.models.core;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "hospital_levels")
public class HospitalLevel {

    @Id
    private int level;

    @Column(name = "name", nullable = false)
    private String name;

    // constructors, getters and setters
}
