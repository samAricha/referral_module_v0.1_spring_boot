package teka.web.referral_modulev0.dto;

import lombok.Data;
import teka.web.referral_modulev0.models.core.Appointment;
import teka.web.referral_modulev0.models.referral.Referral;

@Data
public class AppointmentDto {

    Referral referral;

    Appointment appointment;
}
