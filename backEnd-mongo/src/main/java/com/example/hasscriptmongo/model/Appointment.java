package com.example.hasscriptmongo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.UUID;

@Document
@Data
public class Appointment {
    @Id
    private String id;
    private String userId;
    private String cityName;
    private String hospitalName;
    private String departmentName;
    private String doctorName;
    private String description;
    private Boolean isActive;
    private String createdAt;
}
