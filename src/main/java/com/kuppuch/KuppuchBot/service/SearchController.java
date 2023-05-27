package com.kuppuch.KuppuchBot.service;

import com.kuppuch.KuppuchBot.domain.entity.User;
import com.kuppuch.KuppuchBot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SearchController {
    @Autowired
    UserRepository userRepository;

    public String searchUser(String request) {
        String messageText = "";

        Optional<List<User>> findUserByFirstNameOptional = userRepository.findUserByFirstName(request);
        if (findUserByFirstNameOptional.isPresent() && findUserByFirstNameOptional.get().size() > 0) {
            messageText += "По именам найдены следующие совпадения: \n";
            for (User user : findUserByFirstNameOptional.get()) {
                messageText += user.getFirstName() + " " + user.getLastName() + " " + user.getPostAddress() + "\n";
            }
        } else {
            messageText += "По именам совпадений не найдено \n";
        }

        Optional<List<User>> findUserByLastNameOptional = userRepository.findUserByLastName(request);
        if (findUserByLastNameOptional.isPresent() && findUserByLastNameOptional.get().size() > 0) {
            messageText += "По фамилиям найдены следующие совпадения: \n";
            for (User user : findUserByLastNameOptional.get()) {
                messageText += user.getFirstName() + " " + user.getLastName() + " " + user.getPostAddress() + "\n";
            }
        } else {
            messageText += "По фамилиям совпадений не найдено \n";
        }

        return messageText;
    }
}
