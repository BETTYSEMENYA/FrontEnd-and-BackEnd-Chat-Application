package com.example.betty.demobetty.Controller;

import com.example.betty.demobetty.Entity.Chat;
import com.example.betty.demobetty.Repository.chatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/chats")
public class chatController {

    @Autowired
    private chatRepository ChatRepository;

    @GetMapping
    public ResponseEntity<List<Chat>> getAllChats() {
        List<Chat> chats = ChatRepository.findAll();
        return ResponseEntity.ok(chats);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Chat> getChatById(@PathVariable Long id) {
        Optional<Chat> optionalChat = ChatRepository.findById(id);
        return optionalChat.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Chat> createChat(@RequestBody Chat newChat) {
        Chat savedChat = ChatRepository.save(newChat);
        return ResponseEntity.status(201).body(savedChat);
    }


//    @PutMapping("/{id}")
//    public ResponseEntity<Chat> updateChat(@PathVariable Long id, @RequestBody Chat updatedChat) {
//        if (ChatRepository.existsById(id)) {
//            updatedChat.setId(id);
//            Chat savedChat = ChatRepository.save(updatedChat);
//            return ResponseEntity.ok(savedChat);
//        }
//        return ResponseEntity.notFound().build();
//    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChat(@PathVariable Long id) {
        if (ChatRepository.existsById(id)) {
            ChatRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
