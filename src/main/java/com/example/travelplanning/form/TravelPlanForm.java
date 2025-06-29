package com.example.travelplanning.form;

import java.time.LocalDate;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TravelPlanForm {
    private String destination;
    private LocalDate startDate;
    private LocalDate endDate;
}
