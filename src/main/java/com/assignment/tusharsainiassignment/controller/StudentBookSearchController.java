package com.assignment.tusharsainiassignment.controller;

import com.assignment.tusharsainiassignment.model.Book;
import com.assignment.tusharsainiassignment.service.SearchBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class StudentBookSearchController {

    @Autowired
    private SearchBookService searchBookService;


    @Autowired
    public StudentBookSearchController(SearchBookService searchBookService) {
        this.searchBookService = searchBookService;
    }

    @GetMapping("/bookSearch")
    public String searchBooks(@RequestParam(required = false) String title,
                              @RequestParam(required = false) String author,
                              Model model) {
        List<Book> books = searchBookService.searchBooks(title, author);
        if (books.isEmpty()) {
            model.addAttribute("message", "No books found for the given search criteria.");
            return "studentbooksearch";
        } else {
            model.addAttribute("books", books);
            model.addAttribute("title", title);
            model.addAttribute("author", author);
            return "studentbooksearchsuccess";
        }
    }



}
