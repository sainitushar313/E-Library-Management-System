package com.assignment.tusharsainiassignment.controller;

import com.assignment.tusharsainiassignment.model.Cart;
import com.assignment.tusharsainiassignment.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class ViewOrderController {

    private CartService cartService;

    @Autowired
    public ViewOrderController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/viewOrder")
    public String viewOrder(Model model) {
        // Assuming cartService has a method to fetch book details from the cart table
        List<Cart> bookList = cartService.getBooksFromCart();
        model.addAttribute("bookList", bookList);
        return "viewOrder"; // Return the name of the Thymeleaf template (viewOrder.html)
    }
}
