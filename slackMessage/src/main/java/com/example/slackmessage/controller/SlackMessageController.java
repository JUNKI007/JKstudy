package com.example.slackmessage.controller;

import com.example.slackmessage.service.SlackMessageService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SlackMessageController {

    private final SlackMessageService slackMessageService;

    public SlackMessageController(SlackMessageService slackMessageService){
        this.slackMessageService = slackMessageService;
    }

    @Scheduled(cron = "*/2 * * * * *")
    public void sendSlackMessageRegularly(){
        slackMessageService.sendSlackMessage("행복한 금요일 입니다.");
    }
}
