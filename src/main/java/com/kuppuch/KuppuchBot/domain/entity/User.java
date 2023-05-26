package com.kuppuch.KuppuchBot.domain.entity;

import java.time.LocalDate;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.soap.Name;

import com.kuppuch.KuppuchBot.domain.model.Office;
import com.kuppuch.KuppuchBot.domain.model.UserType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

@Entity
@Data
@EqualsAndHashCode
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "name")
    @NotNull
    @Length(max = 256)
    private String name;
    @Column(name = "new_employee", nullable = false)
    private Boolean newEmployee;
    @Column(name = "user_type")
    private UserType role;
    @Column(name = "office")
    private Office office;
    private LocalDate hireDate;
    private LocalDate birthDate;


    public User() {
    }

    public User(Long id, String name, Boolean newEmployee, UserType role, Office office, LocalDate hireDate, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.newEmployee = newEmployee;
        this.role = role;
        this.office = office;
        this.hireDate = hireDate;
        this.birthDate = birthDate;
    }
}
