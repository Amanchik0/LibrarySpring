// io/back/libraryJava/repository/CommentRepository.java
package io.back.libraryJava.repository;

import io.back.libraryJava.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    // Можете добавить дополнительные методы запросов, если нужно
}
