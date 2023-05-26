package com.kuppuch.KuppuchBot.domain.entity;

import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode
@Table(name ="mentoring")
public class Mentoring {

    @Id
    @GeneratedValue
    private Long id;

    private Integer mentorId;
    private Integer noobId;

    @OneToOne(mappedBy = "userMentoring")
    private User user;

}
