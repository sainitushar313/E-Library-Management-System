package com.assignment.tusharsainiassignment.repository;

import com.assignment.tusharsainiassignment.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StudentSearchBookRepository extends JpaRepository<Book,Long> {
    List<Book> findByTitleContainingIgnoreCaseAndAuthorContainingIgnoreCase(String title, String author);

}
