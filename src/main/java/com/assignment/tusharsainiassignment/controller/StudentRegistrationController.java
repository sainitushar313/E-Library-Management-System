package com.assignment.tusharsainiassignment.controller;

import com.assignment.tusharsainiassignment.model.Student;
import com.assignment.tusharsainiassignment.service.StudentRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentRegistrationController {
    @Autowired
    StudentRegistrationService studentRegistrationService;


    @GetMapping("/studentregistration/studentloginpage")
    public String studentLoginPage() {
        return "studentloginpage";
    }


    @PostMapping("/studentregistration")
    public String  registerStudent(Student student) {
        studentRegistrationService.saveStudent(student);
        return "redirect:/studentregistration/studentloginpage";
    }



}
