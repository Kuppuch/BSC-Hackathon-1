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
public class Roles {

    @Id
    @GeneratedValue
    private Long id;


    @ManyToMany(mappedBy = "role")
    private Set<Chat> roleChat;

    @ManyToMany(mappedBy = "role")
    private Set<User> user;



    @OneToMany(mappedBy = "role")
    private List<Literature> literature;

    private Integer roleCode;
    private String roleName;
    private boolean isActive;

}
