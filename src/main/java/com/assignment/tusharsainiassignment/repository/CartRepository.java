package com.assignment.tusharsainiassignment.repository;

import com.assignment.tusharsainiassignment.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart,Integer> {
    List<Cart> findBooksByRollNo(Integer rollNo);


    void deleteByRollNoAndTitle(Integer rollno, String title);
}
