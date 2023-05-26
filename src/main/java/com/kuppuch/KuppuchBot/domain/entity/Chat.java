package com.kuppuch.KuppuchBot.domain.entity;

import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@Entity
@Data
@EqualsAndHashCode
@Table(name ="chat")
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String link;

    private String chatPlaceCode;

    @ManyToMany
    @JoinColumn(name="role_id")
    private Set<Role> role;

    public Chat(String name, String link, String chatPlaceCode, Set<Role> role) {
        this.name = name;
        this.link = link;
        this.chatPlaceCode = chatPlaceCode;
        this.role = role;
    }
}
