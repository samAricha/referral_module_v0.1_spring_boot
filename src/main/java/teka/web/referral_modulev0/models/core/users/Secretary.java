package teka.web.referral_modulev0.models.core.users;

import jakarta.persistence.*;
import lombok.Data;
import teka.web.referral_modulev0.dto.SubCountyDto;
import teka.web.referral_modulev0.models.core.Hospital;

@Data
@Entity
@Table(name = "secretary")
public class Secretary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;

    private String position;

    @OneToOne
    @JoinColumn(name = "hospital_id", referencedColumnName = "id")
    private Hospital hospital;


}