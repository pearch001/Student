package com.example.Job.Service;

import com.example.Job.Entity.Student;

public interface StudentInt {
    void  saveStudent(Student student);
    Student loadStudent(String firstName);
    void deleteStudent(String firstName);
    Student updateStudent(String firstName,String email, String lastName);
}
