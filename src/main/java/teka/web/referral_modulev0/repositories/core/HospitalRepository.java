package teka.web.referral_modulev0.repositories.core;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import teka.web.referral_modulev0.dto.SubCountyDto;
import teka.web.referral_modulev0.models.core.Hospital;
import teka.web.referral_modulev0.models.core.HospitalLevel;

import java.util.List;
import java.util.Optional;


public interface HospitalRepository extends JpaRepository<Hospital, Long> {

    Optional<Hospital> findByLocationAndLevel(SubCountyDto location, Optional<HospitalLevel> level);

    @Query("SELECT h FROM Hospital h JOIN h.location l JOIN h.level lv WHERE lv = :level AND l.constituency_name = :constituencyName")

    List<Hospital>findByLevelAndLocation_ConstituencyName(@Param("level")Optional<HospitalLevel> level, @Param("constituencyName") String constituencyName);

    @Query("SELECT h FROM Hospital h JOIN h.location l JOIN h.level lv WHERE lv = :level AND l.county_id = :countyId")
    Optional<List<Hospital>> findByLevelAndLocation_CountyId(@Param("level")Optional<HospitalLevel> level,@Param("countyId") int county_id);
}
