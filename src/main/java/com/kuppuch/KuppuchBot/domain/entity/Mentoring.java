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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @JoinColumn(name="user_mentoring")
    @ManyToOne()
    private User user;

    @JoinColumn(name="user_mentyy")
    @ManyToOne()
    private User user_mentor;

}
