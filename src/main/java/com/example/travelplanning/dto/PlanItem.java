package com.example.travelplanning.dto;

import java.time.LocalDate;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlanItem {
    private LocalDate date;
    private String time;
    private String activity;
    private String description;
}
