package com.kuppuch.KuppuchBot.domain.entity;

import java.util.List;
import java.util.Set;
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


    @ManyToMany
    @JoinTable(
        name = "user_role",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Roles> role;


    @OneToMany(mappedBy = "user")
    private Set<Office> office_code;


    @OneToMany(mappedBy = "user")
    private List<Mentoring> userMentoring;

    @OneToMany(mappedBy = "user_mentor")
    private List<Mentoring> userMentings;


    @OneToMany(mappedBy = "user")
    private List<LoginUsers> loginUsers;

    @JoinColumn(name = "user_onboard")
    @OneToOne
    private UserOnboard userOnboard;


    @Column(name = "telegramm_id")
    private String telegrammId;

    @Column(name = "active", nullable = false)
    private boolean isActive;

    @Column(name = "post_address")
    private String postAddress;


    public User() {
    }
}
