package com.jpn.lang.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="EMPLOYEE")
public class Employee {

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long employeeId;

    @Setter
    @Getter
    @Column(name="USERNAME")
    private String username;

    @Setter
    @Getter
    @Column(name="MAIL")
    private String mail;

    @Setter
    @Getter
    @Column(name="DOB")
    private String dob;

    @Setter
    @Getter
    @Column(name="ADDRESS")
    private String address;
}

