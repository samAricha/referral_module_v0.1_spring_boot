package teka.web.referral_modulev0.repositories.core.utils;

import org.springframework.data.jpa.repository.JpaRepository;
import teka.web.referral_modulev0.models.core.utils.Observation;

public interface ObservationRepository extends JpaRepository<Observation, Long> {
}
