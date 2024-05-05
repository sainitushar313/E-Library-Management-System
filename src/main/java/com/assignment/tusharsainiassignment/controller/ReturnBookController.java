package com.assignment.tusharsainiassignment.controller;

import com.assignment.tusharsainiassignment.service.CartService;
import com.assignment.tusharsainiassignment.service.StudentRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ReturnBookController {
    private final CartService cartService;
    @Autowired
    StudentRegistrationService studentRegistrationService;

    @Autowired
    public ReturnBookController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/returnbook")
    public String searchBooksByRollNo(@RequestParam("rollno") Integer rollno, Model model) {

        model.addAttribute("bookList", cartService.findBooksByRollNo(rollno));
        model.addAttribute("rollno", rollno);
        return "returnbook";
    }




}


