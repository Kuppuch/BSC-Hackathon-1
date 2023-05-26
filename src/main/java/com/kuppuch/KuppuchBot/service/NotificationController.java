package com.kuppuch.KuppuchBot.service;

import com.google.gson.Gson;
import com.kuppuch.KuppuchBot.domain.entity.Notification;
import com.kuppuch.KuppuchBot.domain.entity.User;
import com.kuppuch.KuppuchBot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class NotificationController {

    @Autowired
    UserRepository userRepository;

    public List<Notification> getNotification(long tgID) {
        Optional<User> userOptional = userRepository.findUserByTelegrammId(String.valueOf(tgID));
        if (userOptional.isPresent()){
            User user = userOptional.get();
            String queryParam = "?user="+user.getPostAddress();
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.getForEntity("http://address:8080/path"+queryParam, String.class);
//        if (response.getStatusCode().isError) {
            String responseData = response.getBody();
            Gson gson = new Gson();
            List<Notification> notification = gson.fromJson(responseData, ArrayList.class);
//        }
            return notification;

        }
        return null;
    }
}
