package com.kuppuch.KuppuchBot.domain.entity;

import java.util.List;
import java.util.Set;
import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode
@Table(name ="roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToMany(mappedBy = "role")
    private Set<Chat> chats;

    @OneToMany(mappedBy = "role")
    private List<User> user;

    @OneToMany(mappedBy = "role")
    private List<Literature> literature;

    private String roleName;
    private boolean isActive;

}
