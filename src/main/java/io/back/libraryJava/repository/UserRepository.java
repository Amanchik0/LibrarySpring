// io/back/libraryJava/repository/UserRepository.java
package io.back.libraryJava.repository;

import io.back.libraryJava.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
