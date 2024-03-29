package com.nihongo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="EMPLOYEES")
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

