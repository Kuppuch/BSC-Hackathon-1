package com.kuppuch.KuppuchBot.service;

import com.kuppuch.KuppuchBot.utils.MessageUtils;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@Log4j
public class UpdateController {

    private TelegramBot telegrambot;
    private MessageUtils messageUtils;

    public UpdateController(MessageUtils messageUtils) {
        this.messageUtils = messageUtils;
    }

    public void registerBot(TelegramBot telegramBot) {
        this.telegrambot = telegramBot;
    }

    public void choseOffice(Update update){


    }






}
