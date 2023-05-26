package com.kuppuch.KuppuchBot.service;

import com.kuppuch.KuppuchBot.domain.entity.Chat;
import com.kuppuch.KuppuchBot.domain.entity.Role;
import com.kuppuch.KuppuchBot.domain.entity.User;
import com.kuppuch.KuppuchBot.repository.ChatRepository;
import com.kuppuch.KuppuchBot.repository.RoleRepository;
import com.kuppuch.KuppuchBot.repository.UserRepository;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.management.ObjectName;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
@Log4j
public class UserController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    ChatRepository chatRepository;

    public void getUserByTgID(long tgID) {
        userRepository.getById(tgID);
    }

    public List<Chat> getUserChats(long tgID) {
        Optional<User> userOptional = userRepository.findUserByTelegrammId(String.valueOf(tgID));
        List<Chat> chats = new ArrayList<>();
        if (userOptional.isPresent()) {
            Role role = userOptional.get().getRole();
            Optional<List<Chat>> chatsOptional = chatRepository.findChatsByRole(role);
            if (chatsOptional.isPresent()) {
                for (Chat chat : chatsOptional.get()) {
                    chats.add(chat);
                }
            }
        }

        return chats;
    }
}
