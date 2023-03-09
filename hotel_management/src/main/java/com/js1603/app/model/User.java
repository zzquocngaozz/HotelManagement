package com.js1603.app.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class User {
    private int userId;
    private String userName;
    private String userEmail;
    private String userPassword;
    private int userRole;
    private String userDob;
    private String userPhone;
    private int userGender;
    private int userStatus;
}
