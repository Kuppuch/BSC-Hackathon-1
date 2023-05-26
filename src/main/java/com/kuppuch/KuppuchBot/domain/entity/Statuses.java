package com.kuppuch.KuppuchBot.domain.entity;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode
@Table(name ="statuses")
public class Statuses {

    @Id
    @GeneratedValue
    private Long id;

    private Integer statusCode;

    private Integer statusName;

    private boolean isActive;

    @OneToOne(mappedBy = "is")
    private Tasks task;
}
