package com.kuppuch.KuppuchBot.service;

import javax.annotation.PostConstruct;
import javax.swing.text.html.Option;

import com.kuppuch.KuppuchBot.domain.entity.User;
import com.kuppuch.KuppuchBot.repository.UserRepository;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.HashMap;
import java.util.Optional;

@Component
@Log4j
public class TelegramBot extends TelegramLongPollingBot {

    @Value("${bot.name}")
    private String botName;
    @Value("${bot.token}")
    private String botToken;
    private UpdateController updateController;

    @Autowired
    UserRepository userRepository;

    private HashMap<Long, Boolean> emailChecker = new HashMap<>();

    public TelegramBot(UpdateController updateController) {
        this.updateController = updateController;
    }

    @PostConstruct
    public  void init(){
        updateController.registerBot(this);
    }

    @Override
    public String getBotUsername() {
        return botName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatID = update.getMessage().getChatId();
            String messageContent = "";
            String rejectAuth = "Необходимо авторизоваться\n Ожидается ввод Email";

            switch (messageText) {
                case "/start":
                    if (!updateController.checkMail(update.getMessage().getChatId().toString())) {
                        messageContent = rejectAuth;
                        emailChecker.put(update.getMessage().getChatId(), true);
                    } else {
                        messageContent = "Привет, " + update.getMessage().getChat().getFirstName() + "\n" +
                                "Вы состоите в ЦК <b>[Заглушка]</b>\n" +
                                "Вам могут понадобиться следующие ссылки: \n" +
                                "<a href='https://meet.jit.si/SK_ISPI'>Заглушка</a>";
                    }
                    buildMessage(messageContent, chatID);
                    break;
                case "/importamt_people":
                    if (!updateController.checkMail(update.getMessage().getChatId().toString())) {
                        messageContent = rejectAuth;
                    } else {
                        updateController.checkMail(update.getMessage().getChatId().toString());
                        messageContent = "Some text";
                    }
                    buildMessage(messageContent, chatID);
                    break;
                case "/chats":
                    if (!updateController.checkMail(update.getMessage().getChatId().toString())) {
                        messageContent = rejectAuth;
                    } else {
                        updateController.checkMail(update.getMessage().getChatId().toString());
                        messageContent = "В этих чатах вас ждут:\n" +
                                "Чат ЦК " + "Аналитики" + "\n" +
                                "Чат off-topic " + "Аналитики" + "\n";
                    }
                    buildMessage(messageContent, chatID);
                    break;
                case "/logins":
                    if (!updateController.checkMail(update.getMessage().getChatId().toString())) {
                        messageContent = rejectAuth;
                    } else {
                        updateController.checkMail(update.getMessage().getChatId().toString());
                        messageContent = "Храните ваши логины в безопасности и не передавайте третим лицам\n" +
                                "Пользователь - " + "Заглушка" + "\n" +
                                "login - " + "Заглушка" + "\n" +
                                "Job Title - " + "Заглушка" + "\n" +
                                "Manager - " + "Заглушка" + "\n" +
                                "Локация - " + "Заглушка" + "\n" +
                                "Email - " + "Заглушка" + "\n";
                    }
                    buildMessage(messageContent, chatID);
                    break;
                case "/notification":
                    if (!updateController.checkMail(update.getMessage().getChatId().toString())) {
                        messageContent = rejectAuth;
                    } else {
                        updateController.checkMail(update.getMessage().getChatId().toString());
                        messageContent = "В ближайшую неделю вас ожидают следующие встречи:\n\n" +
                                "<b>Понедельник</b>\n" +
                                "15:00 - 16:00 1-1\n" +
                                "\n" +
                                "<b>Вторник</b>\n" +
                                "15:00 - 16:00 1-2\n";
                    }
                    buildMessage(messageContent, chatID);
                    break;
                case "/library_bsc":
                    if (!updateController.checkMail(update.getMessage().getChatId().toString())) {
                        messageContent = rejectAuth;
                    } else {
                        updateController.checkMail(update.getMessage().getChatId().toString());
                        messageContent = "Предлгаю ознакомиться со следующей литературой\n" +
                                "<a href='https://habr.com/ru/articles/692524/'>Как аналитику стать разработчиком</a>";
                    }
                    buildMessage(messageContent, chatID);
                    break;
                case "/search":
                    if (!updateController.checkMail(update.getMessage().getChatId().toString())) {
                        messageContent = rejectAuth;
                    } else {
                        updateController.checkMail(update.getMessage().getChatId().toString());
                        messageContent = "Тут мы тестируем параметры\n" + update.getMessage().getText();
                    }
                    buildMessage(messageContent, chatID);
                    break;
                case "/feedback":
                    if (!updateController.checkMail(update.getMessage().getChatId().toString())) {
                        messageContent = rejectAuth;
                    } else {
                        updateController.checkMail(update.getMessage().getChatId().toString());
                        messageContent = "Тут тоже мы тестируем параметры\n" + update.getMessage().getText();
                    }
                    buildMessage(messageContent, chatID);
                    break;
                default:
                    messageContent = "Извините, команда не распознана";
                    boolean ok = emailChecker.get(update.getMessage().getChatId());
                    if (ok) {
                        Optional<User> userOptional =  userRepository.findUserByPostAddress(update.getMessage().getText());
                       if (userOptional.isPresent()) {
                           User user = userOptional.get();
                           user.setActive(true);
                           user.setTelegrammId(update.getMessage().getChatId().toString());
                           userRepository.save(user);
                           if(userRepository.findById(user.getId()).get().isActive() &&
                           userRepository.findById(user.getId()).get().getTelegrammId().length()>0){
                               messageContent = "Добро пожаловать!";
                           }else {
                               messageContent = "Доступ заперщен!";
                           }

                       }
                    }
                    buildMessage(messageContent, chatID);
            }
        }
    }

    public void buildMessage(String messageContent, long chatID) {
        SendMessage message = new SendMessage();
        message.setParseMode("html");
        message.setText(messageContent);
        message.setChatId(String.valueOf(chatID));
        sendAnswerMessage(message);
    }

    public void sendAnswerMessage(SendMessage message) {
        if (message != null) {
            try {
                execute(message);
            } catch (TelegramApiException e) {
                log.error(e.getMessage());
            }
        }
    }

    public boolean checkEmployee(boolean checkEmail) {
        if (1 != 1) {
            return false;
        }
        return true;
    }
}
