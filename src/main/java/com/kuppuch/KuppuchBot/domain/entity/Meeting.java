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
    @GeneratedValue
    private Long id;

    @JoinColumn(name = "meeting_time", referencedColumnName = "id")
    @OneToOne(cascade = CascadeType.ALL)
    private MeetingRoom roomId;

    private String title;

    private String text;

    @OneToOne(mappedBy = "id")
    private UserMeeting userMeeting;

    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;
}
