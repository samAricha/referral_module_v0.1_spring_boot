package teka.web.referral_modulev0.services.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teka.web.referral_modulev0.dto.SecretaryDto;
import teka.web.referral_modulev0.dto.SubCountyDto;
import teka.web.referral_modulev0.models.core.Hospital;
import teka.web.referral_modulev0.models.core.users.Patient;
import teka.web.referral_modulev0.models.core.users.Person;
import teka.web.referral_modulev0.models.core.users.Physician;
import teka.web.referral_modulev0.models.core.users.Secretary;
import teka.web.referral_modulev0.repositories.core.users.PatientRepository;
import teka.web.referral_modulev0.repositories.core.users.PersonRepository;
import teka.web.referral_modulev0.repositories.core.users.PhysicianRepository;
import teka.web.referral_modulev0.repositories.core.users.SecretaryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    PhysicianRepository physicianRepository;
    @Autowired
    SecretaryRepository secretaryRepository;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    PatientRepository patientRepository;

    public List<Physician> getAllPhysicians(){
        return physicianRepository.findAll();
    }

    public Optional<Physician> getPhysicianById(Long id){
        return physicianRepository.findById(id);
    }

    public List<Secretary> getAllSecretaries(){
        return secretaryRepository.findAll();
    }

    public SubCountyDto getPhysicianSubCounty(Long physicianId){
        Optional<Physician> physician = physicianRepository.findById(physicianId);
        Hospital hospital = physician.get().getHospital();
        SubCountyDto location = hospital.getLocation();
        return location;
    }

    public Optional<Person> getPersonById(Long id){
        return personRepository.findById(id);
    }

    public Patient getPatientByPersonId(Long id){
        return patientRepository.findOneByPersonId(id);
    }

    public Person savePerson(Person person){
       return personRepository.save(person);
    }

    public Patient savePatient(Patient patient){
        return patientRepository.save(patient);
    }
    public Physician savePhysician(Physician physician){
        return physicianRepository.save(physician);
    }
    public Secretary saveSecretary(Secretary secretary){
        return secretaryRepository.save(secretary);
    }

    public Optional<Patient> getPatientById(long id){
        return patientRepository.findById(id);
    }


    public Optional<Secretary> getSecretaryById(long id){
        return secretaryRepository.findById(id);
    }
}
