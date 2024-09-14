package com.example.webAppbot.runner;

import com.example.webAppbot.controller.TgController;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Component
@RequiredArgsConstructor
public class BotRunner {

    private final TgController tgController;


    @EventListener({ApplicationReadyEvent.class})
    public void run(){
        try {
            TelegramBotsApi telegramBotsApi=new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(tgController);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }


}
