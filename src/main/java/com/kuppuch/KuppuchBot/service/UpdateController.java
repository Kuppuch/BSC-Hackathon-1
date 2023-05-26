package com.kuppuch.KuppuchBot.service;

import java.util.Optional;

import com.kuppuch.KuppuchBot.domain.entity.User;
import com.kuppuch.KuppuchBot.repository.UserRepository;
import com.kuppuch.KuppuchBot.utils.MessageUtils;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@Log4j
public class UpdateController {

    private TelegramBot telegrambot;
    private MessageUtils messageUtils;
    private UserRepository userRepository;

    public UpdateController(MessageUtils messageUtils) {
        this.messageUtils = messageUtils;
    }

    public void registerBot(TelegramBot telegramBot) {
        this.telegrambot = telegramBot;
    }

    public void choseOffice(Update update){
    }

    public  boolean checkMail(Update update){
        if(update.hasMessage() && update.getMessage().hasText()){
            String email = update.getMessage().getText();
            Long chatId = update.getMessage().getChatId();
            if(email.endsWith("@bscmsc.ru")){
                Optional<User> user = userRepository.findUserByPostAddress(email);
                return user.isPresent();
            }
        }

        return false;
    }






}
