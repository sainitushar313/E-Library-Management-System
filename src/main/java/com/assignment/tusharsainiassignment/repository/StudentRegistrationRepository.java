package com.assignment.tusharsainiassignment.repository;

import com.assignment.tusharsainiassignment.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface StudentRegistrationRepository extends JpaRepository<Student,Long> {
    Optional<Student> findByUsername(String username);
}
