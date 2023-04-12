package teka.web.referral_modulev0.repositories.referral;

import org.springframework.data.jpa.repository.JpaRepository;
import teka.web.referral_modulev0.models.core.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
