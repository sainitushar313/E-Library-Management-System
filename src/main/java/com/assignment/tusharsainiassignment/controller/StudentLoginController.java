package com.assignment.tusharsainiassignment.controller;

import com.assignment.tusharsainiassignment.service.StudentLoginAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class StudentLoginController {

    @Autowired
    private StudentLoginAuthService studentLoginAuthServices;

    @GetMapping("/studentbooksearch")
    public String studentBookSearch() {
        return "studentbooksearch";
    }
    @GetMapping("/returnbook")
    public String studentReturnBook() {
        return "returnbook";
    }

    @GetMapping("/studentregistration")
    public String studentRegistration() {
        return "studentregistration";
    }

    @GetMapping("/studentdashboard")
    public String studentdashRegistration() {
        return "studentdashboard";
    }


    @PostMapping("/studentloginpage")
    public String studentLogin(@RequestParam String username, @RequestParam String password, RedirectAttributes redirectAttributes) {
        if (studentLoginAuthServices.authenticate(username, password)) {
            return "redirect:/studentdashboard";
        } else {
            redirectAttributes.addAttribute("error", true);
            return "studentloginpage";
        }

    }
}
