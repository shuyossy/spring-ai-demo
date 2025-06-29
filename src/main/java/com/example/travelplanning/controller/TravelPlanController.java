package com.example.travelplanning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.travelplanning.dto.TravelPlan;
import com.example.travelplanning.form.TravelPlanForm;
import com.example.travelplanning.service.TravelPlanService;

@Controller
public class TravelPlanController {

    private final TravelPlanService travelPlanService;

    @Autowired
    public TravelPlanController(TravelPlanService travelPlanService) {
        this.travelPlanService = travelPlanService;
    }

    @GetMapping("/")
    public String showPlanForm(Model model) {
        model.addAttribute("travelPlanForm", new TravelPlanForm());
        return "travel-plan";
    }

    @PostMapping("/generate")
    @ResponseBody
    public TravelPlan generatePlan(@RequestBody TravelPlanForm form) {
        return travelPlanService.generatePlan(form);
    }
}
