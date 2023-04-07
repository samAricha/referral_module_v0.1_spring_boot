package teka.web.referral_modulev0.repositories.core.users;

import org.springframework.data.jpa.repository.JpaRepository;
import teka.web.referral_modulev0.models.core.users.Physician;

public interface PhysicianRepository extends JpaRepository<Physician, Long> {
}
