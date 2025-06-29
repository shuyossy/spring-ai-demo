package com.example.travelplanning.dto;

import java.time.LocalDate;
import java.util.List;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TravelPlan {
    private String destination;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<PlanItem> items;
}
