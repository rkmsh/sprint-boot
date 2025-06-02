package com.rkmsh.request_handler.requestResponseModels;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonRequestModel {
    private String name;
    private String role;
    private String email;
    private String phoneNumber;

    CommonRequestModel() {
        // Default constructor
    }
    public CommonRequestModel(String name, String role, String email, String phoneNumber) {
        this.name = name;
        this.role = role;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
