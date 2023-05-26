package com.kuppuch.KuppuchBot.domain.entity;

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

    @JoinColumn(name="role_chat", referencedColumnName = "id" )
    @OneToOne(cascade =CascadeType.ALL)
    private Chat roleChat;

    @OneToOne(mappedBy = "role")
    private User user;

    @JoinColumn(name = "literature_role",referencedColumnName = "id")
    @OneToOne(cascade = CascadeType.ALL)
    private Literature literature;

    private Integer roleCode;
    private String roleName;
    private boolean isActive;

}
