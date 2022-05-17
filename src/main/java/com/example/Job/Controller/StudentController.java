package com.example.Job.Controller;

import com.example.Job.Entity.Student;
import com.example.Job.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/save")
    public void saveUser(@RequestBody Student student){
        studentService.saveStudent(student);
    }


    @GetMapping("/load/{firstname}")
    public Student loadStudent(@PathVariable("firstname") String firstName){
        return studentService.loadStudent(firstName);
    }


    @DeleteMapping("/delete/{firstname}")
    public void deleteStudent(@PathVariable("firstname") String firstName){
        studentService.deleteStudent(firstName);
    }

    @PutMapping("/update/{firstname}")
    public Student updateStudent(@PathVariable("firstname") String firstname,
                                 @RequestParam(required = false) String email,
                                 @RequestParam(required = false) String lastName){
        return studentService.updateStudent(firstname,email,lastName);
    }
}
