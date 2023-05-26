package com.kuppuch.KuppuchBot.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

@Entity
@Data
@EqualsAndHashCode
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "first_name")
    @NotNull
    @Length(max = 256)
    private String FirstName;
    @Column(name = "last_name")
    @NotNull
    @Length(max = 256)
    private String LastName;

    @JoinColumn(name = "user_roles", referencedColumnName = "id")
    @OneToOne(cascade = CascadeType.ALL)
    private Roles role;

    @JoinColumn(name = "office_code", referencedColumnName = "id")
    @OneToOne(cascade = CascadeType.ALL)
    private Office office_code;

    @JoinColumn(name = "user_mentoring",  referencedColumnName = "id")
    @OneToOne(cascade = CascadeType.ALL)
    private Mentoring userMentoring;

    @JoinColumn(name="login_user", referencedColumnName = "id")
    @OneToOne(cascade = CascadeType.ALL)
    private LoginUsers loginUsers;

    @JoinColumn(name = "onboard_page", referencedColumnName = "id")
    @OneToOne(cascade = CascadeType.ALL)
    private UserOnboard userOnboard;


    @Column(name ="telegramm_id")
    private String telegrammId;

    @Column(name = "active", nullable = false)
    private boolean isActive;

    @Column(name = "post_address")
    private String postAddress;



    public User() {
    }


}
