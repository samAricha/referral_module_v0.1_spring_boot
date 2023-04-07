package teka.web.referral_modulev0.dto;

import lombok.Data;
import teka.web.referral_modulev0.models.core.Hospital;

@Data
public class PhysicianDto {

    private Hospital hospital;
    private String specialty;
}
