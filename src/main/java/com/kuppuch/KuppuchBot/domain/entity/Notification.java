package com.kuppuch.KuppuchBot.domain.entity;

import java.time.LocalDateTime;
import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode
@Table(name = "notification")
public class Notification {

    @Id
    @GeneratedValue
    private Long id;

    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @OneToOne(cascade = CascadeType.ALL)
    private User userId;

    @JoinColumn(name = "meeting_id", referencedColumnName = "id")
    @OneToOne(cascade = CascadeType.ALL)
    private Meeting meetingId;

    private LocalDateTime notificationTime;
}
