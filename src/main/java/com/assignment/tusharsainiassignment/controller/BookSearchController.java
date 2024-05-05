package com.assignment.tusharsainiassignment.controller;

import com.assignment.tusharsainiassignment.model.Book;
import com.assignment.tusharsainiassignment.repository.AddBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.Optional;

@Controller
public class BookSearchController {
    private final AddBookRepository addBookRepository;

    @Autowired
    public BookSearchController(AddBookRepository addBookRepository) {
        this.addBookRepository = addBookRepository;
    }

    @GetMapping("/search-book-by-title")
    public ModelAndView getBookDetails(@RequestParam String bookTitle) {
        Optional<Book> optionalBook = addBookRepository.findByTitle(bookTitle);
        ModelAndView modelAndView = new ModelAndView("searchbooksuccess");
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            modelAndView.addObject("book", book); // Add book details as model attribute
        } else {
            modelAndView.addObject("error", "Book with ID " + bookTitle + " not found.");
        }
        return modelAndView;
    }
}