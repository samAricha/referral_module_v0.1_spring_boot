package teka.web.referral_modulev0.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "subcounties")
public class SubCountyDto {

    @Id
    private int id;
    private int county_id;
    private String constituency_name;
    private String ward;
    private String alias;


}
