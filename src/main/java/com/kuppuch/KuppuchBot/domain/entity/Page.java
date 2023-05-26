package com.kuppuch.KuppuchBot.domain.entity;

import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode
@Table(name = "page")
public class Page {

    @Id
    @GeneratedValue
    private Long id;

    private Integer confluenceId;

    private  Integer pageTypeCode;

    private String pageName;

    @JoinColumn(name = "page_types", referencedColumnName = "id")
    @OneToOne(cascade = CascadeType.ALL)
    private PageTypes pageTypes;

    @OneToOne(mappedBy = "id")
    private Tasks tasks;

    @OneToOne(mappedBy = "id")
    private LoginUsers loginUsers;

    @OneToOne(mappedBy = "id")
    private UserOnboard userOnboard;


}
