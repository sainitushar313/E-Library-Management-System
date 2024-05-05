package com.assignment.tusharsainiassignment.service;

import com.assignment.tusharsainiassignment.model.Cart;
import com.assignment.tusharsainiassignment.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;
    public void saveBook(Integer rollno,String title, String author, LocalDate currentDate, LocalDate expireDate) {
        Cart cart = new Cart();
        cart.setRollno(rollno);
        cart.setTitle(title);
        cart.setAuthor(author);
        cart.setIssuedate(currentDate);
        cart.setExpirydate(expireDate);

        cartRepository.save(cart);
    }


    public List<Cart> getBooksFromCart() {
        return cartRepository.findAll();
    }

    public Object findBooksByRollNo(Integer rollno) {
        return cartRepository.findBooksByRollNo(rollno);
    }


    @Transactional
    public void deleteBookByRollNoAndTitle(Integer rollno, String title) {
        cartRepository.deleteByRollNoAndTitle(rollno,title);
    }


}

