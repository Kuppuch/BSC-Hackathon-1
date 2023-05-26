package com.kuppuch.KuppuchBot.service;

import com.kuppuch.KuppuchBot.domain.entity.Role;
import com.kuppuch.KuppuchBot.domain.entity.User;
import com.kuppuch.KuppuchBot.repository.RoleRepository;
import com.kuppuch.KuppuchBot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.Optional;

@Component
public class RoleController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    public Role getRole(long tgID) {
        Optional<User> userOption = userRepository.findUserByTelegrammId(String.valueOf(tgID));
        if (userOption.isPresent()) {
            Optional<Role> roleOptional = roleRepository.findRoleById(userOption.get().getRole().getId());
            if (roleOptional.isPresent()) {
                return roleOptional.get();
            }
        }
        return null;
    }
}
