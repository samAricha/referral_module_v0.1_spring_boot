package teka.web.referral_modulev0.controllers.location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import teka.web.referral_modulev0.dto.CountyDto;
import teka.web.referral_modulev0.dto.SubCountyDto;
import teka.web.referral_modulev0.services.location.CountiesService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/location")
public class CountiesController {

    @Autowired
    CountiesService countiesService;

    @GetMapping("/counties")
    public List<CountyDto> getCounties(){
        return countiesService.getAllCounties();
    }

    @GetMapping("/subcounties")
    public List<SubCountyDto> getSubCounties(){
        return countiesService.getAllSubCounties();
    }

    @GetMapping("/county/{id}")
    public ResponseEntity<Object> getCountyById(@PathVariable Long id) {
        Optional<CountyDto> county = countiesService.getCountyById(id);
        if (county.isPresent()) {
            return ResponseEntity.ok().body(county.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/subcounty/{id}")
    public ResponseEntity<Object> getSubCountyById(@PathVariable Long id) {
        Optional<SubCountyDto> subCounty = countiesService.getSubCountyById(id);
        if (subCounty.isPresent()) {
            return ResponseEntity.ok().body(subCounty.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
