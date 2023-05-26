package com.kuppuch.KuppuchBot.domain.entity;

import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@Entity
@Data
@EqualsAndHashCode
@Table(name = "user_onboard")
public class UserOnboard {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany(mappedBy = "userOnboard")
    private Set<User> user;

    @JoinColumn(name = "onboardPage")
    @OneToOne(cascade = CascadeType.ALL)
    private Page onboardPage;


}
