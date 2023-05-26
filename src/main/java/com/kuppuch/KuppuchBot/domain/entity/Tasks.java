package com.kuppuch.KuppuchBot.domain.entity;

import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode
@Table(name ="task")
public class Tasks {

    @Id
    @GeneratedValue
    private Long id;

    @JoinColumn(name = "page_id")
    @ManyToOne()
    private Page pageId;

    private String text;

    @JoinColumn(name = "status_code")
    @OneToOne(cascade = CascadeType.ALL)
    private Statuses statusCode;

}
