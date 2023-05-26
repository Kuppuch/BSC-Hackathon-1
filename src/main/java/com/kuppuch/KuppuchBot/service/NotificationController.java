package com.kuppuch.KuppuchBot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.google.gson.Gson;
import com.kuppuch.KuppuchBot.domain.entity.Meeting;
import com.kuppuch.KuppuchBot.domain.entity.Notification;
import com.kuppuch.KuppuchBot.domain.entity.User;
import com.kuppuch.KuppuchBot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class NotificationController {

    @Autowired
    UserRepository userRepository;

    String url ="http://localhost:1398/bsc-wire-mock/?userId=1";

    public MeetingList getNotification(long tgID) {
        Optional<User> userOptional = userRepository.findUserByTelegrammId(String.valueOf(tgID));
        if (userOptional.isPresent()){
            User user = userOptional.get();
            String queryParam = "?user="+user.getId();
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);

            String responseData = response.getBody();
            Gson gson = new Gson();

            MeetingList meetings =gson.fromJson(responseData, MeetingList.class);


            return meetings;

        }
        return null;
    }
}
