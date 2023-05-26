package com.kuppuch.KuppuchBot.domain.entity;

import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;

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

    private Integer chatPlaceCode;

    @ManyToOne
    @JoinColumn(name="chat_id")
    private Roles role;

}
