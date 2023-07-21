package com.example.slackmessage.service;

import com.slack.api.Slack;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SlackMessageService {
    private final String slackBotToken;
    private final String targetChannel;

    public SlackMessageService(@Value("${slack.bot-token}") String slackBotToken, @Value("${slack.target-channel}") String targetChannel){
        this.slackBotToken = slackBotToken;
        this.targetChannel = targetChannel;
    }


    public void sendSlackMessage(String message){
        Slack slack = Slack.getInstance();

        try{
            slack.methods().chatPostMessage(
                    ChatPostMessageRequest.builder()
                            .token(slackBotToken)
                            .channel(targetChannel)
                            .text(message)
                            .build()
            );
            System.out.println("메시지 전송 성공");
        } catch (IOException | SlackApiException e){
            System.out.println("메시지 전송 실패" + e.getMessage());
        }


    }

}
