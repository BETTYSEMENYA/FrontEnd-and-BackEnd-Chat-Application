package com.example.betty.demobetty.Repository;
import com.example.betty.demobetty.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByContactOrEmailAddress(String contact, String emailAddress);
    Optional<User> findByEmailAddress(String email);
}
