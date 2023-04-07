package teka.web.referral_modulev0.repositories.core.users;

import org.springframework.data.jpa.repository.JpaRepository;
import teka.web.referral_modulev0.models.core.users.Patient;
import teka.web.referral_modulev0.models.core.users.Person;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    //List<Person> findByIdNumberContainingIgnoreCaseOrPersonFirstNameContainingIgnoreCaseOrPersonLastNameContainingIgnoreCase(String patientNumber, String firstName, String lastName);
    //List<Person> findByIdNumberContainingIgnoreCaseOrUsernameContainingIgnoreCase(String idNumber, String username);

    Person findByIdNumber(int idNumber);



}
