package com.example.Job.DAO;

import com.example.Job.Entity.Student;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class StudentDAOTest {
    @Autowired
    private StudentDAO studentDAO;


    @Test
    void selectByFirstname() {
        //given
        Student student = new Student("preye","kunu","pk@gmail.com");
        studentDAO.save(student);
        //when
        Student student1 = studentDAO.selectByFirstname("preye");
        //then
        assertEquals(student,student1);
    }

    @Test
    void findByFirstname() {
    }

    @Test
    void findByEmail() {
    }
}