package teka.web.referral_modulev0.repositories.location;

import org.springframework.data.jpa.repository.JpaRepository;
import teka.web.referral_modulev0.dto.SubCountyDto;

public interface SubCountiesRepository extends JpaRepository<SubCountyDto, Long> {
}
