package teka.web.referral_modulev0.dto;

import lombok.Data;
import teka.web.referral_modulev0.models.core.Hospital;
import teka.web.referral_modulev0.models.core.users.Patient;
import teka.web.referral_modulev0.models.core.users.Physician;
import teka.web.referral_modulev0.models.core.utils.Encounter;
import teka.web.referral_modulev0.models.referral.ReferralStatus;
import teka.web.referral_modulev0.models.referral.ReferralUrgency;

@Data
public class ReferralInfoDto {

    private Patient patient;
    private Hospital receivingHospital;

    private Hospital referringHospital;

    private Physician referringPhysician;

    private ReferralStatus referralStatus;

    private ReferralUrgency referralUrgency;

    private Encounter referringEncounter;

    private Encounter receivingEncounter;

    private String diagnosis;

    private String physicianNotes;

    private String referralReason;

}
