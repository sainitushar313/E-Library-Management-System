package com.assignment.tusharsainiassignment.service;

import com.assignment.tusharsainiassignment.model.Student;
import com.assignment.tusharsainiassignment.repository.StudentRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class StudentLoginAuthService {

    @Autowired
    private StudentRegistrationRepository studentRegistrationRepository;

    public boolean authenticate(String username, String password) {
        Optional<Student> userOptional = studentRegistrationRepository.findByUsername(username);
        if (userOptional.isPresent()) {
            Student student = userOptional.get();
            return student.getPassword().equals(password);
        }
        return false;
    }


}
