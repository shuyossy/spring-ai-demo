package com.example.travelplanning;

import java.time.LocalDate;

import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.travelplanning.dto.TravelPlan;
import com.example.travelplanning.form.TravelPlanForm;
import com.example.travelplanning.service.TravelPlanService;

@Component
public class StartupRunner implements CommandLineRunner {
    @Autowired
    TravelPlanService travelPlanService;

    @Override
    public void run(String... args) {
        TravelPlanForm form = new TravelPlanForm();
        form.setDestination("東京");
        form.setStartDate(LocalDate.of(2024, 1, 1));
        form.setEndDate(LocalDate.of(2024, 1, 3));

        TravelPlan travelPlan = travelPlanService.generatePlan(form);
        System.out.println("生成された旅行プラン: " + travelPlan);
    }

}
