package com.example.betty.demobetty.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
@Entity(name = "users")
@Table(name = "users")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {


    @Id
    @UuidGenerator
    private String id;

    @NotNull(message = "contact cannot be empty")
//    @Pattern(regexp = "[0-9]")
//    @Min(value = 10, message = "number must not be less than 10")
//    @Max(value = 10, message = "number must not be more than 10" )
    private String contact;

    @NotNull(message = "UserName cannot be empty")
//    @Pattern(regexp = "[A-Za-z]")
    private String userName;

    @Email(message = "not correct message")
    private String emailAddress;


    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getContact() {
        return contact;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
    public String getId() {
        return id;
    }


//    @OneToMany(mappedBy = "user")
//    private List<Chat> chats;

}
