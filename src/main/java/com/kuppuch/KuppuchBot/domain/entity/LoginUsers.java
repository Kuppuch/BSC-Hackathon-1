package com.kuppuch.KuppuchBot.domain.entity;

import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode
@Table(name ="login_users")
public class LoginUsers {

    @Id
    @GeneratedValue
    private Long id;

    private String login;

    @JoinColumn(name = "user_id")
    @ManyToOne()
    private User user;

}
