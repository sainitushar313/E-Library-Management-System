package com.assignment.tusharsainiassignment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/main")
    public String mainPage() {
        return "HomePage";
    }
    @GetMapping("/homepage")
    public String homePage() {
        return "homepage";
    }

    @GetMapping("/placeorderpage")
    public String placeOrder() {
        return "placeorder";
    }

    @GetMapping("/main/adminloginpage")
    public String adminMainPage() {
        return "adminloginpage";
    }

    @GetMapping("/adminloginpage/addbooks")
    public String addBooks() {
        return "addbooks";
    }

    @GetMapping("/booksearch")
    public String bookSearch() {
        return "booksearch";
    }

    @GetMapping("/bookupdate")
    public String bookUpdate() {
        return "bookupdate";
    }
    @GetMapping("/vieworder")
    public String viewOrder() {
        return "vieworder";
    }

    @GetMapping("/main/studentloginpage")
    public String StudentMainPage() {
        return "studentloginpage";
    }

    @GetMapping("/studentloginpage/studentregistration")
    public String StudentRegistrationPage() {
        return "studentregistration";
    }

}
