package io.back.libraryJava.repo;

import io.back.libraryJava.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findByName(String name);

    Optional<User> findUserByEmail(String email);

    Optional<User> findUserById(Long id);
}
