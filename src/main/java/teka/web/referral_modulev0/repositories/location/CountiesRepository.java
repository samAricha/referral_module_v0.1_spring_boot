package teka.web.referral_modulev0.repositories.location;

import org.springframework.data.jpa.repository.JpaRepository;
import teka.web.referral_modulev0.dto.CountyDto;

public interface CountiesRepository extends JpaRepository<CountyDto, Long> {
}
