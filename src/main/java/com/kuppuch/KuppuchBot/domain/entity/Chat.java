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
    @GeneratedValue
    private Long id;

    private String name;

    private String link;

    private String chatPlaceCode;

    @ManyToMany
    @JoinColumn(name="role_id")
    private Set<Roles> role;

}
