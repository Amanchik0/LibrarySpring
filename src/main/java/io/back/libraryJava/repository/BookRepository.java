// io/back/libraryJava/repository/BookRepository.java
package io.back.libraryJava.repository;

import io.back.libraryJava.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    // Можете добавить дополнительные методы запросов, если нужно
}
