package com.substring.foodie.controller.example;

import com.substring.foodie.payload.example.Department;
import com.substring.foodie.payload.example.DummyDataGenerator;
import com.substring.foodie.payload.example.Student;
import com.substring.foodie.payload.example.Subject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    //singe student get krne ka url
    @RequestMapping("/single")
    public Student getStudent(){

        Department department = new Department();
        department.setDepartmentCode("cs");
        department.setDepartmentName("Computer Science");

        //subject : Data Structure
        Subject subject1 = new Subject();
        subject1.setSubjectCode("KCS251");
        subject1.setTitle("Data Structure");

        Subject subject2 = new Subject();
        subject2.setSubjectCode("KYJA248");
        subject2.setTitle("Database Management System");

        List<Subject> subjects = new ArrayList<>();
        subjects.add(subject1);
        subjects.add(subject2);


        Student student = new Student();
        student.setName("Akshansh Sharma");
        student.setAge(22);
        student.setDepartment(department);
        student.setSubjects(subjects);

        System.out.println("method run..");

        return student;
    }

    @RequestMapping("/all")
    public List<Student> getStudents(){
        List<Student> students = DummyDataGenerator.generateDummyStudents();
        return students;
    }

    @RequestMapping("/wish/{message}/for/{userName}")
    public String wish(@PathVariable("message") String userMessage ,@PathVariable String userName){
        return "wishing " + userMessage + " " + userName;

    }

    @RequestMapping("/wish")
    public String wishQuery(@RequestParam(value="message" , required = false , defaultValue = "Happy holiday") String userMessage , @RequestParam String userName){
        return "wishing " + userMessage + " " + userName;

    }
}
