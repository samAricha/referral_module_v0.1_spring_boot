package teka.web.referral_modulev0.kmhfl.models;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FacilityTypeModel {
    private String id;
    private String ownerTypeName;
    private LocalDateTime created;
    private LocalDateTime updated;
    private boolean deleted;
    private boolean active;
    private String search;
    private String name;
    private String abbreviation;
    private String subDivision;
    private int createdBy;
    private int updatedBy;
    private String ownerType;
    private String preceding;
    private String parent;
}
