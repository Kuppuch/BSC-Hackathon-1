package com.kuppuch.KuppuchBot.service;

import java.util.List;

import com.kuppuch.KuppuchBot.domain.entity.Meeting;

public class MeetingList {
    private List<Meeting> events;

    public List<Meeting> getEvents(){
        return events;
    }

    public void setEvents(List<Meeting> events){
        this.events = events;
    }
}
