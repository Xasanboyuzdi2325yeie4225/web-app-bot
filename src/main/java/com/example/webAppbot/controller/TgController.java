package com.example.webAppbot.controller;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class TgController extends TelegramLongPollingBot {

    private final String TOKEN = "token";
    private final String USERNAME = "username";


    @Override
    public void onUpdateReceived(Update update) {
        SendMessage sendMessage=new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId().toString());
        sendMessage.setText(update.getMessage().getText()+" dedi");
        executor(sendMessage);
    }


    public void executor(SendMessage message) {
        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public String getBotToken() {
        return TOKEN;
    }

    @Override
    public String getBotUsername() {
        return USERNAME;
    }
}
