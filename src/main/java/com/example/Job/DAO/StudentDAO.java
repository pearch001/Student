package com.example.Job.DAO;

import com.example.Job.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDAO extends JpaRepository<Student,Long> {
    @Query("SELECT s FROM "
            + "student s WHERE s.firstName = ?1")
    Student selectByFirstname(String firstName);
    @Query("SELECT CASE WHEN COUNT(s) > 0 THEN TRUE ELSE FALSE END FROM "
            + "student s WHERE s.firstName = ?1")
    Boolean findByFirstname(String firstName);
    @Query("SELECT CASE WHEN COUNT(s) > 0 THEN TRUE ELSE FALSE END FROM "
            + "student s WHERE s.email = ?1")
    Boolean findByEmail(String email);
}
