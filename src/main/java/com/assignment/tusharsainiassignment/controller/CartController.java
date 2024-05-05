package com.assignment.tusharsainiassignment.controller;

import com.assignment.tusharsainiassignment.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


@Controller
public class CartController {

    @Autowired
    private CartService cartService;


    @GetMapping("/placeorder")
    public String placeorder(@RequestParam("bookTitle") String bookTitle,
                             @RequestParam("bookAuthor") String bookAuthor,
                             Model model) {
        model.addAttribute("bookTitle", bookTitle);
        model.addAttribute("bookAuthor", bookAuthor);
        return "placeorder";
    }

    @PostMapping("/placeOrder")
    public ModelAndView placeOrder( @RequestParam("rollno") Integer rollno,
                                    @RequestParam("bookTitle") String bookTitle,
                                   @RequestParam("bookAuthor") String bookAuthor) {


        LocalDate currentDate = LocalDate.now();
        LocalDate expireDate = currentDate.plus(15, ChronoUnit.DAYS); // Example: Expire date after 15 days

        cartService.saveBook(rollno,bookTitle, bookAuthor, currentDate, expireDate);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("afterclickplaceorder"); // Set the view name
        modelAndView.addObject("bookTitle", bookTitle);
        modelAndView.addObject("bookAuthor", bookAuthor);
        modelAndView.addObject("currentDate", currentDate);
        modelAndView.addObject("expireDate", expireDate);
        return modelAndView;
    }


    @DeleteMapping("/books")
    public ResponseEntity<String> deleteBookByRollNoAndTitle(
            @RequestParam("rollno") Integer rollno,
            @RequestParam("title") String title) {
        cartService.deleteBookByRollNoAndTitle(rollno, title);
        return ResponseEntity.ok().body("Book deleted successfully.");
    }


}
