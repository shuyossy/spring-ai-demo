package com.example.travelplanning.ai.tools;

import java.time.LocalDate;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;

public class WeatherTool {
    // ランダムに天気を生成する（デモ用）ツール
    @Tool(description = "指定した場所と日付の天気を取得する")
    public String getWeather(@ToolParam(description = "場所") String location, @ToolParam(description = "日付（ISO-8601形式 yyyy-MM-dd）") LocalDate date) {
        String[] weathers = {"晴れ", "曇り", "雨"};
        int randomIndex = (int) (Math.random() * weathers.length);
        return weathers[randomIndex];
    }  
}
