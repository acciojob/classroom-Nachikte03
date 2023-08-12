package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class StudentService {




    @Autowired
    StudentRepository studentRepository;



    public Student addStudent(Student student){
        return studentRepository.addStudent(student);
    }

    public Teacher addTeacher(Teacher teacher){
        return studentRepository.addTeacher(teacher);

    }

    public String addStudentTeacherPair(String student,String teacher){
        return studentRepository.addStudentTeacherPair(student,teacher);

    }

    public Student getStudentByName(String name){
        return studentRepository.getStudentByName(name);


    }

    public Teacher getTeacherByName(String name){
        return studentRepository.getTeacherByName(name);


    }
    public List<String> getStudentsByTeacherName(String teacher){
        return studentRepository.getStudentsByTeacherName(teacher);
    }

    public List<String> getAllStudents(){
        return studentRepository.getAllStudents();
    }

    public String deleteTeacherByName(String teacher){
        return studentRepository.deleteTeacherByName(teacher);

    }

    public String deleteAllTeachers(){
        return studentRepository.deleteAllTeachers();

    }
}
