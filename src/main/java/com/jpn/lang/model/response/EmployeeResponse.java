package com.jpn.lang.model.response;

import lombok.Getter;
import lombok.Setter;

public class EmployeeResponse {

    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private String username;

    @Getter
    @Setter
    private String mail;

    @Getter
    @Setter
    private String dob;

    @Getter
    @Setter
    private String address;

}
