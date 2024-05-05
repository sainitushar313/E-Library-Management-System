package com.assignment.tusharsainiassignment.repository;

import com.assignment.tusharsainiassignment.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AddBookRepository extends JpaRepository<Book,Long> {

    Optional<Book> findByTitle(String bookTitle);
}
