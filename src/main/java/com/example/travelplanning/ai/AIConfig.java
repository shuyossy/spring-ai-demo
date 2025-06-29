package com.example.travelplanning.ai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AIConfig {

    @Bean
    public ChatClient planningChatClient(OpenAiChatModel openAiChatModel) {
        String systemPrompt = """
                あなたは優秀な旅行プランナーです。
                ユーザーの要望に基づいて、最適な旅行プランを提案してください。
                ただし、以下の制約を守ってください。
                  1. 1日あたりのアクティビティは1つまでに制限する
                  2. 日付を生成する際はISO-8601形式(yyyy-MM-dd)を使用する
                """;
        return ChatClient.builder(openAiChatModel).defaultSystem(systemPrompt).build();
    }

    // 異なるChatClientを利用したい場合の例
    // 読み込み側では@Qualifier("anotherChatClient")を指定して利用する
    // @Bean
    // public ChatClient anotherChatClient(OpenAiChatModel openAiChatModel) {
    // return ChatClient.builder(openAiChatModel).build();
    // }
}