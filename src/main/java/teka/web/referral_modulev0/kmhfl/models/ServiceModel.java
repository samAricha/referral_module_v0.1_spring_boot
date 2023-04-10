package teka.web.referral_modulev0.kmhfl.models;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ServiceModel {
    private String id;
    private String categoryName;
    private LocalDateTime created;
    private LocalDateTime updated;
    private boolean deleted;
    private boolean active;
    private String search;
    private String name;
    private String description;
    private String abbreviation;
    private int code;
    private boolean hasOptions;
    private int createdBy;
    private int updatedBy;
    private String category;
    private String group;
    private String kephLevel;

    // Constructor, getters and setters
}
