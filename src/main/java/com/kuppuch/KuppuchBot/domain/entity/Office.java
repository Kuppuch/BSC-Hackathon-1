package com.kuppuch.KuppuchBot.domain.entity;

import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode
@Table(name = "office_code")
public class Office {

    @Id
    @GeneratedValue
    private Long id;

    private Integer officeCode;

    private String city;

    private String officeName;

    @OneToOne(mappedBy = "office_code")
    private User user;

    public Office() {
    }

    public Office(Long id, Integer officeCode, String city, String officeName) {
        this.id = id;
        this.officeCode = officeCode;
        this.city = city;
        this.officeName = officeName;
    }
}
