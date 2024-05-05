package com.assignment.tusharsainiassignment.service;

import com.assignment.tusharsainiassignment.model.Book;
import com.assignment.tusharsainiassignment.repository.StudentSearchBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SearchBookService {
    private StudentSearchBookRepository studentSearchBookRepository;

    @Autowired
    public SearchBookService(StudentSearchBookRepository studentSearchBookRepository) {
        this.studentSearchBookRepository = studentSearchBookRepository;
    }

    public List<Book> searchBooks(String title, String author) {
        return studentSearchBookRepository.findByTitleContainingIgnoreCaseAndAuthorContainingIgnoreCase(title, author);
    }


}
