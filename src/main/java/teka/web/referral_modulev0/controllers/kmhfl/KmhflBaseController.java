package teka.web.referral_modulev0.controllers.kmhfl;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import teka.web.referral_modulev0.kmhfl.models.FacilityModel;
import teka.web.referral_modulev0.kmhfl.models.FacilityTypeModel;
import teka.web.referral_modulev0.kmhfl.models.ServiceCategoryModel;
import teka.web.referral_modulev0.kmhfl.models.ServiceModel;
import teka.web.referral_modulev0.models.core.Service;
import teka.web.referral_modulev0.models.referral.Referral;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/kmhfl/api")
public class KmhflBaseController {

    @GetMapping("/services/service-categories")
    public List<ServiceCategoryModel> allServiceCategories(){
        ServiceCategoryModel serviceCategoryModel = new ServiceCategoryModel();
        List<ServiceCategoryModel> serviceCategories = new ArrayList<ServiceCategoryModel>();

       return serviceCategories;
    }
    @GetMapping("/services/services")
    public List<ServiceModel> allServices(){
        ServiceModel serviceModel = new ServiceModel();
        List<ServiceModel> serviceModels = new ArrayList<ServiceModel>();

        return serviceModels;
    }

    @GetMapping("/facilities/facility-types")
    public List<FacilityTypeModel> allFacilityTypes(){
        FacilityTypeModel facilityTypeModel= new FacilityTypeModel();
        List<FacilityTypeModel> facilityTypeModels = new ArrayList<FacilityTypeModel>();

        return facilityTypeModels;
    }

    @GetMapping("/facilities/facilities")
    public List<FacilityModel> allFacilities(){
        FacilityModel facilityModel= new FacilityModel();
        List<FacilityModel> facilities = new ArrayList<FacilityModel>();

        return facilities;
    }


}
