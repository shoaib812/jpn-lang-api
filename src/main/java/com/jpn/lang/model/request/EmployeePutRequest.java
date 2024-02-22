package com.jpn.lang.model.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeePutRequest {
    private String username;

    private String mail;

    private String dob;

    private String address;
}
