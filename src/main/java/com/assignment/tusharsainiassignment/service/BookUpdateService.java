package com.assignment.tusharsainiassignment.service;

import com.assignment.tusharsainiassignment.model.Book;
import com.assignment.tusharsainiassignment.repository.AddBookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class BookUpdateService {
    @Autowired
     AddBookRepository addBookRepository;

    @Autowired
    public BookUpdateService(AddBookRepository addBookRepository) {
        this.addBookRepository = addBookRepository;
    }

    @Transactional
    public void updateBoookDetails(Long id, String title, String author, double cost, int quantity) {
        // Retrieve the book entity from the repository
        Optional<Book> optionalBook = addBookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            // Update the book details
            book.setTitle(title);
            book.setAuthor(author);
            book.setCost(cost);
            book.setQuantity(quantity);
            // Save the updated book entity
            addBookRepository.save(book);
        } else {
            // Handle case where book with given ID is not found
            // You can throw an exception or log an error message
        }
    }
}
