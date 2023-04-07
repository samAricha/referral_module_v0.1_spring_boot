package teka.web.referral_modulev0.models.core.users;

import jakarta.persistence.*;
import lombok.Data;
import teka.web.referral_modulev0.models.core.enums.Gender;

@Data
@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @Column(name = "id_number")
    private int idNumber;
    @Column(name = "phone", nullable = true)
    private int phone;

//    @Enumerated(EnumType.STRING)
    @Column(name = "person_gender")
    private String gender;

    @Column(name = "person_age")
    private Integer age;


}