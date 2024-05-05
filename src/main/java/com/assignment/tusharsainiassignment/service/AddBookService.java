package com.assignment.tusharsainiassignment.service;

import com.assignment.tusharsainiassignment.model.Book;
import com.assignment.tusharsainiassignment.repository.AddBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddBookService{
    @Autowired
    private AddBookRepository addBookRepository;

    public void saveBook(Book book) {
        addBookRepository.save(book);
    }

}
