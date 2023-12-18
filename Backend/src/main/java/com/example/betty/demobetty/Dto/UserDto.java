package com.example.betty.demobetty.Dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String id;


    public String getId() {
        return id;
    }

    private String userName;
    private String emailAddress;

    public String getContact() {
        return contact;
    }

    public String getUserName() {
        return userName;
    }
    private String contact;

    public void setId(String id) {
        this.id = id;
    }


    public String getEmailAddress() {
        return emailAddress;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }


}
