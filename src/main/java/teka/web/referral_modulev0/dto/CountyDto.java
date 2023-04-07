package teka.web.referral_modulev0.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "counties")
public class CountyDto {

    @Id
    private int id;
    private String county_name;


}
