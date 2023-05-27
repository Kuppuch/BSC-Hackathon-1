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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    @NotNull
    @Length(max = 256)
    private String firstName;
    @Column(name = "last_name")
    @NotNull
    @Length(max = 256)
    private String lastName;


    @JoinColumn(name="role_id")
    @ManyToOne()
    private Role role;


    @OneToMany(mappedBy = "user")
    private Set<Office> office_code;


    @OneToMany(mappedBy = "user")
    private List<Mentoring> userMentoring;

    @OneToMany(mappedBy = "user_mentor")
    private List<Mentoring> userMentings;


    @OneToMany(mappedBy = "user")
    private List<LoginUser> loginUsers;

    @ManyToMany
    @JoinTable(
            name = "user_onboard_page",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "page_id")
    )
    private Set<UserOnboard> userOnboard;


    @Column(name = "telegramm_id")
    private String telegrammId;

    @Column(name = "active", nullable = false)
    private boolean isActive;

    @Column(name = "post_address")
    private String postAddress;


    public User() {
    }

    public User(String firstName, String lastName, String telegrammId, boolean isActive, String postAddress) {
        FirstName = firstName;
        LastName = lastName;
        this.telegrammId = telegrammId;
        this.isActive = isActive;
        this.postAddress = postAddress;
    }

    public User(String firstName, String lastName) {
        FirstName = firstName;
        LastName = lastName;
    }
}
