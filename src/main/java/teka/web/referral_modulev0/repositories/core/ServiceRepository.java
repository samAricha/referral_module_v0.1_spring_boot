package teka.web.referral_modulev0.repositories.core;

import org.springframework.data.jpa.repository.JpaRepository;
import teka.web.referral_modulev0.models.core.HospitalLevel;
import teka.web.referral_modulev0.models.core.Service;

import java.util.List;
import java.util.Optional;

public interface ServiceRepository extends JpaRepository<Service, Long> {

    List<Service> findServicesByLevel(Optional<HospitalLevel> level);
}
