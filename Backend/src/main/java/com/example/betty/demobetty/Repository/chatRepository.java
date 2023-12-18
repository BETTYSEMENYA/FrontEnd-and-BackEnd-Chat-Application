package com.example.betty.demobetty.Repository;

import com.example.betty.demobetty.Entity.Chat;

import org.springframework.data.jpa.repository.JpaRepository;

public interface chatRepository  extends JpaRepository<Chat,Long > {
}
