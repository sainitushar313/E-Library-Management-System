package com.assignment.tusharsainiassignment.controller;

import com.assignment.tusharsainiassignment.model.Book;
import com.assignment.tusharsainiassignment.repository.AddBookRepository;
import com.assignment.tusharsainiassignment.service.BookUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.Optional;

@Controller
public class BookUpdateController {

    @Autowired
    BookUpdateService bookUpdateService;
    @Autowired
    AddBookRepository addBookRepository;
    @Autowired
    public BookUpdateController(BookUpdateService bookUpdateService) {
        this.bookUpdateService = bookUpdateService;
    }

    @GetMapping("/search-boook-by-title")
    public ModelAndView getBoookDetails(@RequestParam String bookTitle) {
        Optional<Book> optionalBook = addBookRepository.findByTitle(bookTitle);
        ModelAndView modelAndView = new ModelAndView("bookupdateform");
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            modelAndView.addObject("book", book); // Add book details as model attribute
        } else {
            modelAndView.addObject("error", "Book with ID " + bookTitle + " not found.");
        }
        return modelAndView;
    }

    @PostMapping("/update-book-details")
    public String updateBookDetails(@RequestParam Long id,
                                    @RequestParam String title,
                                    @RequestParam String author,
                                    @RequestParam double cost,
                                    @RequestParam int quantity) {
        bookUpdateService.updateBoookDetails(id, title, author, cost, quantity);

        return "redirect:/bookupdateform.html";
    }


}
