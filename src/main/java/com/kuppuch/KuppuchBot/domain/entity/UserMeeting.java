package com.kuppuch.KuppuchBot.domain.entity;

import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode
@Table(name ="user_meeting")
public class UserMeeting {

    @Id
    @GeneratedValue
    private Long id;

    @JoinColumn(name = "meetting_id", referencedColumnName = "id")
    @OneToOne(cascade = CascadeType.ALL)
    private Meeting meetingId;

    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @OneToOne(cascade = CascadeType.ALL)
    private User userId;
}
