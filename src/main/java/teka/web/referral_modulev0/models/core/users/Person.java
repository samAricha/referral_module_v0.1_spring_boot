package teka.web.referral_modulev0.models.core.users;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import teka.web.referral_modulev0.models.core.enums.Gender;

import java.time.LocalDateTime;

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

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;


}