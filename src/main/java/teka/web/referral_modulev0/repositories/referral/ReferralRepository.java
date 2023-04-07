package teka.web.referral_modulev0.repositories.referral;

import org.springframework.data.jpa.repository.JpaRepository;
import teka.web.referral_modulev0.models.referral.Referral;

public interface ReferralRepository extends JpaRepository<Referral, Long> {
}
