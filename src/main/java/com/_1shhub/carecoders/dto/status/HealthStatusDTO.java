package com._1shhub.carecoders.dto.status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HealthStatusDTO {
    private Long statusId;
    private String bloodPressure;
    private String bloodSugar;
    private double weight;
}
