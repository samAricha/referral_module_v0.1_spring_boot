package teka.web.referral_modulev0.services.faker;


import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teka.web.referral_modulev0.models.core.Hospital;
import teka.web.referral_modulev0.models.core.users.Patient;
import teka.web.referral_modulev0.models.core.users.Person;
import teka.web.referral_modulev0.models.core.users.Physician;
import teka.web.referral_modulev0.models.core.users.Secretary;
import teka.web.referral_modulev0.models.core.utils.Encounter;
import teka.web.referral_modulev0.models.core.utils.Observation;
import teka.web.referral_modulev0.repositories.core.HospitalRepository;
import teka.web.referral_modulev0.repositories.core.users.PersonRepository;
import teka.web.referral_modulev0.repositories.core.users.PhysicianRepository;
import teka.web.referral_modulev0.repositories.core.users.SecretaryRepository;
import teka.web.referral_modulev0.repositories.core.utils.EncounterRepository;
import teka.web.referral_modulev0.repositories.core.utils.ObservationRepository;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class CoreFakePersonsDataService {


    private final PersonRepository personRepository;
    private final PhysicianRepository physicianRepository;
    private final SecretaryRepository secretaryRepository;
    private final HospitalRepository hospitalRepository;
    private final EncounterRepository encounterRepository;
    private final ObservationRepository observationRepository;
    private final Faker faker;

    @Autowired
    public CoreFakePersonsDataService(PersonRepository personRepository,
                                      PhysicianRepository physicianRepository,
                                      SecretaryRepository secretaryRepository,
                                      HospitalRepository hospitalRepository,
                                      EncounterRepository encounterRepository,
                                      ObservationRepository observationRepository) {
        this.personRepository = personRepository;
        this.physicianRepository = physicianRepository;
        this.secretaryRepository = secretaryRepository;
        this.hospitalRepository = hospitalRepository;
        this.encounterRepository = encounterRepository;
        this.observationRepository = observationRepository;
        this.faker = new Faker();

    }


    public void generateFakeData() {
        List<Hospital> hospitals = new ArrayList<>();
        hospitals = hospitalRepository.findAll();


        // Generate persons
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Person person = new Person();
            person.setUsername(faker.name().username());
            person.setIdNumber((int)faker.number().randomNumber());
            person.setGender(faker.options().option("Male", "Female"));
            personRepository.save(person);
            persons.add(person);
        }

        // Generate physicians
        List<Physician> physicians = new ArrayList<>();
        // Generate secretaries
        List<Secretary> secretaries = new ArrayList<>();
        // Generate patients
        List<Patient> patients = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Hospital hospital = getRandomHospital();
            Physician physician = new Physician();
            physician.setPerson(persons.get(faker.number().numberBetween(0, persons.size())));
            physician.setSpeciality(faker.options().option("Cardiologist", "Neurologist", "Pediatrician"));
            physician.setHospital(hospital);
            physicianRepository.save(physician);
            physicians.add(physician);



            Secretary secretary = new Secretary();
            secretary.setPerson(persons.get(faker.number().numberBetween(0, persons.size())));
            secretary.setPosition(faker.options().option("Receptionist", "Secretary"));
            secretary.setHospital(hospital);
            secretaryRepository.save(secretary);
            secretaries.add(secretary);

            Patient patient = new Patient();
            patient.setPerson(persons.get(faker.number().numberBetween(0, persons.size())));
            patient.setPatientNumber("pt"+faker.number().numberBetween(0, persons.size()));
            patients.add(patient);
        }


        // Generate encounters and observations
        for (int i = 0; i < 2; i++) {
            Patient patient = patients.get(i);
            Hospital hospital = hospitals.get(i);
            Physician physician = physicians.get(i);
            //setting up encounter
            Encounter encounter = new Encounter();
            encounter.setPatient(patient);
            encounter.setHospital(hospital);
            encounter.setPhysician(physician);
            encounterRepository.save(encounter);
            //setting up observation
            for (int j = 0; j < faker.number().numberBetween(1, 10); j++) {
                Observation observation = new Observation();
                //observation.setPerson(patient);
                observation.setEncounter(encounter);
                observation.setObservation(faker.lorem().word());
                observationRepository.save(observation);
            }
        }
    }

    private Hospital getRandomHospital(){
        Random random = new Random();
        int index = random.nextInt(30);

        Optional<Hospital> hospital = hospitalRepository.findById(Long.valueOf(index));
        return hospital.orElse(null);

    }


}
