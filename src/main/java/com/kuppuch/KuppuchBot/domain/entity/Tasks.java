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

    @JoinColumn(name = "page_id", referencedColumnName = "id")
    @OneToOne(cascade = CascadeType.ALL)
    private Page pageId;

    private String text;

    @JoinColumn(name = "status_code", referencedColumnName = "id")
    @OneToOne(cascade = CascadeType.ALL)
    private Statuses statusCode;

}
