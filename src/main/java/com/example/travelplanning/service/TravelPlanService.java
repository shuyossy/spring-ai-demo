package com.example.travelplanning.service;

import java.util.Map;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.travelplanning.ai.tools.WeatherTool;
import com.example.travelplanning.dto.TravelPlan;
import com.example.travelplanning.form.TravelPlanForm;

@Service
public class TravelPlanService {
    private final ChatClient planningChatClient;

    // @Qualifierを使用して特定のChatClientを注入(ChatClientひとつの場合は不要)
    @Autowired
    public TravelPlanService(@Qualifier("planningChatClient") ChatClient planningChatClient) {
        this.planningChatClient = planningChatClient;
    }

    public TravelPlan generatePlan(TravelPlanForm form) {
        String userPrompt = """
                以下の情報を元に、旅行プランを提案してください。
                目的地: {destination}
                開始日: {startDate}
                終了日: {endDate}
                """;

        TravelPlan travelPlan = this.planningChatClient.prompt()
                .user(u -> u.text(userPrompt).params(Map.of("destination", form.getDestination(),
                        "startDate", form.getStartDate().toString(), "endDate", form.getEndDate().toString())))
                .tools(new WeatherTool())
                .call().entity(TravelPlan.class);

        return travelPlan;
    }
}
