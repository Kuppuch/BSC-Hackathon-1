package com.kuppuch.KuppuchBot.service;

import com.kuppuch.KuppuchBot.domain.entity.LoginUser;
import com.kuppuch.KuppuchBot.domain.entity.User;
import com.kuppuch.KuppuchBot.repository.LoginUserRepository;
import com.kuppuch.KuppuchBot.repository.UserRepository;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Log4j
public class LoginController {

    @Autowired
    LoginUserRepository loginUserRepository;

    @Autowired
    UserRepository userRepository;

    public List<LoginUser> getUserLogins(long tgID) {
        Optional<User> user = userRepository.findUserByTelegrammId(String.valueOf(tgID));
        if (user.isPresent()) {
            Optional<List<LoginUser>> loginUsersOptional = loginUserRepository.findAllByUser(user.get());
            if (loginUsersOptional.isPresent()) {
                return loginUsersOptional.get();
            }
        }
        return null;
    }
}
