package com.gamingclub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gamingclub.Model.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByPhone(String phone);
}
