package teka.web.referral_modulev0.repositories.core;

import org.springframework.data.jpa.repository.JpaRepository;
import teka.web.referral_modulev0.models.core.Visit;

public interface VisitRepository extends JpaRepository<Visit, Long> {
}
