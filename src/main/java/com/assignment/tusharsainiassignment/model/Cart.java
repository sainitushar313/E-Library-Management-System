package com.assignment.tusharsainiassignment.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cartid")
    private Integer cartId;

    @Column(name = "rollno")
    private Integer rollNo;
    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "issuedate")
    private LocalDate issuedate;

    @Column(name = "expirydate")
    private LocalDate expirydate;

    @Column(name = "fine")
    private Integer fine;


    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getRollno() {
        return rollNo;
    }

    public void setRollno(Integer rollno) {
        this.rollNo = rollno;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getIssuedate() {
        return issuedate;
    }

    public void setIssuedate(LocalDate issuedate) {
        this.issuedate = issuedate;
    }

    public LocalDate getExpirydate() {
        return expirydate;
    }

    public void setExpirydate(LocalDate expirydate) {
        this.expirydate = expirydate;
    }

    public Integer getFine() {
        return fine;
    }

    public void setFine(Integer fine) {
        this.fine = fine;
    }
}
