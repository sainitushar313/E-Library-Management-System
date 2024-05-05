package com.assignment.tusharsainiassignment.controller;

import com.assignment.tusharsainiassignment.model.Admin;
import com.assignment.tusharsainiassignment.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.Optional;

@Controller
public class AdminLoginController {

    @Autowired
    AdminRepository adminRepository;

    @PostMapping("/adminloginpage")
    public String adminLogin(String username, String password) {
        Optional<Admin> userOptional = adminRepository.findByUsername(username);

        if (userOptional.isPresent()) {
            Admin user = userOptional.get();
            if (password.equals(user.getPassword())) {
                return "dashboard";
            }
        }

        return "adminloginpage"; }
}
