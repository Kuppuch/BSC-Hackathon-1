package com.kuppuch.KuppuchBot.domain.entity;

import java.util.Set;
import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode
@Table(name = "page")
public class Page {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer confluenceId;

    private  Integer pageTypeCode;

    private String pageName;

    @JoinColumn(name = "page_types")
    @OneToOne(cascade = CascadeType.ALL)
    private PageType pageTypes;

    @OneToMany(mappedBy = "pageId")
    private Set<Task> tasks;


    @OneToOne(mappedBy = "onboardPage")
    private UserOnboard userOnboard;


}
