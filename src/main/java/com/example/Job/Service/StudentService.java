package com.example.Job.Service;

import com.example.Job.DAO.StudentDAO;
import com.example.Job.Entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Table;
import java.util.Objects;
import java.util.Optional;
@Slf4j
@Service
@Transactional
public class StudentService implements StudentInt {
    @Autowired
    private StudentDAO studentDAO;
    public void saveStudent(Student student){
        studentDAO.save(student);
    }
    public Student loadStudent(String firstName){
        Boolean value = studentDAO.findByFirstname(firstName);
        log.info(firstName);
        if (!value){
            throw new IllegalStateException("User not found");
        }
        return studentDAO.selectByFirstname(firstName);
    }

    @Override
    public void deleteStudent(String firstName) {
        Boolean value = studentDAO.findByFirstname(firstName);
        if (!value){
            throw new IllegalStateException("User not found");
        }
        Student student = studentDAO.selectByFirstname(firstName);
        studentDAO.delete(student);
    }

    @Override
    public Student updateStudent(String firstName, String email, String lastName) {

        Boolean value = studentDAO.findByFirstname(firstName);
        if (!value){
            throw new IllegalStateException("User not found");
        }
        Student student = studentDAO.selectByFirstname(firstName);
        if (email != null && email.length() > 0 && !Objects.equals(email,student.getEmail())){
            Boolean emailValue = studentDAO.findByEmail(email);
            log.info(email);
            log.info(String.valueOf(emailValue));
            if(emailValue){
                throw new IllegalStateException("Email has ben taken");
            }
            student.setEmail(email);
        }

        if (lastName != null && lastName.length() > 0 && !Objects.equals(lastName,student.getLastName())){

            student.setLastName(lastName);
        }
        return student;
    }
}
