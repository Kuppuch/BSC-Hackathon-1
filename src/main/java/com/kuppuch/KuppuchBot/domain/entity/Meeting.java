package com.kuppuch.KuppuchBot.domain.entity;

import java.time.LocalDateTime;
import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode
@Table(name ="meeting")
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "meeting_room_ig")
    @ManyToOne()
    private MeetingRoom meetingId;

    private String title;

    private String text;

    @JoinColumn(name = "meeting_id")
    @ManyToOne
    private UserMeeting userMeeting;

    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;
}
