package teka.web.referral_modulev0.repositories.core;

import org.springframework.data.jpa.repository.JpaRepository;
import teka.web.referral_modulev0.models.core.HospitalLevel;

import java.util.Optional;


public interface HospitalLevelRepository extends JpaRepository<HospitalLevel, Long> {

    Optional<HospitalLevel> findByLevel(int level);

}
