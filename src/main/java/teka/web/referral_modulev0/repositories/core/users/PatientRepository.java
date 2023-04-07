package teka.web.referral_modulev0.repositories.core.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import teka.web.referral_modulev0.models.core.users.Patient;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

//    List<Patient> findByPatientNumberContainingIgnoreCaseOrPersonFirstNameContainingIgnoreCaseOrPersonLastNameContainingIgnoreCase(String patientNumber, String firstName, String lastName);
    Patient findOneByPersonId(Long personId);
}
