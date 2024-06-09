package com.example.demo.controller;

import com.example.demo.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("stu")
public class StuController {

    private List<Student> students = new ArrayList<>();

    @GetMapping
    public List<Student> studentList(){
        return students;
    }

    @PostMapping
    public Student save(@RequestBody Student studentRequest){
        students.add(studentRequest);
        return studentRequest;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") int id){
        students.remove(id);
    }

    @PutMapping("{id}")
    public Student update(@PathVariable("id") int id,@RequestBody  Student student){
        int count = 0;
       Student student1 = new Student();
        for (Student stu: students){
           if(stu.getId() == id){
               student1 = stu;
               count = students.indexOf(stu);
           }
       }
        if(student.getFirstname() != null){
            student1.setFirstname(student.getFirstname());
        } else if(student.getLastname() != null){
            student1.setLastname(student.getLastname());
        }
        students.set(count, student1);
        return student1;
    }

    //Todo Implement GetMapping find Student By Id
    @GetMapping("{id}")
    public Student findStudentById(@PathVariable("id") int id){
        return null;
    }

}
