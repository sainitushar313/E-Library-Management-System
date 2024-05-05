package com.assignment.tusharsainiassignment.service;

import com.assignment.tusharsainiassignment.model.Student;
import com.assignment.tusharsainiassignment.repository.StudentRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentRegistrationService {

    @Autowired
    StudentRegistrationRepository studentRegistrationRepository;

    public void saveStudent(Student student) {
        studentRegistrationRepository.save(student);
    }

}
