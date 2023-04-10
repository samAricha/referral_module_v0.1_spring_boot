package teka.web.referral_modulev0.kmhfl.models;

import lombok.Data;

@Data
public class ServiceCategoryModel {

    private String id;
    private String created;
    private String updated;
    private boolean deleted;
    private boolean active;
    private String search;
    private String name;
    private String description;
    private String abbreviation;
    private int created_by;
    private int updated_by;
    private String parent;


}
