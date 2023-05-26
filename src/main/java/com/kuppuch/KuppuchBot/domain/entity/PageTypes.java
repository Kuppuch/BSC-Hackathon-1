package com.kuppuch.KuppuchBot.domain.entity;

import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode
@Table(name ="page_types")
public class PageTypes {

    @Id
    @GeneratedValue
    private Long id;

    private Integer pageTypeCode;

    private String pageTypeName;

    @OneToOne(mappedBy = "id")
    private Page page;
}
