package com.example.hasscriptmongo.dto;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@Data
public class AppointmentDto {
    private String userId;
    private String cityName;
    private String hospitalName;
    private String departmentName;
    private String doctorName;
    private String description;
}
