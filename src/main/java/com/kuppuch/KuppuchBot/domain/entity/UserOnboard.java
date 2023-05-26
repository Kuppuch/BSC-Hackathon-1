package com.kuppuch.KuppuchBot.domain.entity;

import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode
@Table(name = "user_onboard")
public class UserOnboard {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(mappedBy = "userOnboard")
    private User user;

    @JoinColumn(name = "onboardPage")
    @OneToOne(cascade = CascadeType.ALL)
    private Page onboardPage;


}
