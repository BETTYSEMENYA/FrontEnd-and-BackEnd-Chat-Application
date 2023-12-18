package com.example.betty.demobetty.Controller;

import com.example.betty.demobetty.Entity.Chat;
import com.example.betty.demobetty.Entity.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin(origins = "http://localhost:4200/")
public class WebSocketController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Chat greeting(Message message) throws Exception {
       Thread.sleep(1000); // simulated delay
        return new Chat("Hello, " + message.getSenderEmail() + "!");
    }
}
