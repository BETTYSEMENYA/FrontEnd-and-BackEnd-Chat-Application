package com.example.betty.demobetty.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Chat {

    @Id
    @UuidGenerator
    private String chat_id;;

    private String firstUserName;
    private String secondUserName;

    public Chat(String message) {this.firstUserName = message;
    }


//    @ManyToOne
//    private User user;
//    private Long id;

//    public Chat(String message) {
//        this.firstUserName = message;
//    }
//    public void setId(Long id) {
//        this.id = id;
//    }

}
