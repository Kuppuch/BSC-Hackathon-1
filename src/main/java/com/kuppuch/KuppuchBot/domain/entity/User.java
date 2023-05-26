package com.kuppuch.KuppuchBot.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.kuppuch.KuppuchBot.domain.model.Office;
import com.kuppuch.KuppuchBot.domain.model.Role;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

@Entity
@Data
@EqualsAndHashCode
@Table(name ="users")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    @Length(max = 256)
    private String name;
    private Boolean newEmployee;
    private Role role;
    private Office office;

}
