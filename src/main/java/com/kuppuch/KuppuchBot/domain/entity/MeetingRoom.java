package com.kuppuch.KuppuchBot.domain.entity;

import java.util.Set;
import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode
@Table(name="meeting_room")
public class MeetingRoom {

    @Id
    @GeneratedValue
    private Long id;

    private String name;


    @OneToMany(mappedBy = "meetingId")
    private Set<Meeting> meeting;

}
