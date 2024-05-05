package com.assignment.tusharsainiassignment.controller;

import com.assignment.tusharsainiassignment.model.Book;
import com.assignment.tusharsainiassignment.service.AddBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddBookController {

    @Autowired
    AddBookService addBookService;
    @GetMapping("/addbooks")
    public String addBook() {
        return "addbooks";
    }


    @PostMapping("/submit-form")
    public String submitForm(Book book) {
        addBookService.saveBook(book);
        return "bookaddsuccess";
    }
}
