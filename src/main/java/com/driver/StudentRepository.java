package com.driver;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@org.springframework.stereotype.Repository
public class StudentRepository {




    HashMap<String,Student> studentMap;
    HashMap<String,Teacher> teachermap;
    HashMap<String, List<String>> teacherStudent;


    @Autowired
    public StudentRepository() {
        studentMap = new HashMap<>();
        teachermap = new HashMap<>();
        teacherStudent = new HashMap<>();
    }

    public Student addStudent(Student student){
        studentMap.put(student.getName(),student);
        return student;
    }

    public Teacher addTeacher(Teacher teacher){
        teachermap.put(teacher.getName(),teacher);
        teacherStudent.put(teacher.getName(),new ArrayList<String>());
        return teacher;
    }

    public String addStudentTeacherPair(String student,String teacher){
        List<String> list = teacherStudent.get(teacher);
        list.add(student);
        Teacher teacher1 = teachermap.get(teacher);
        teacher1.setNumberOfStudents(teacher1.getNumberOfStudents()+1);
        return teacher;
    }

    public Student getStudentByName(String name){
        return studentMap.get(name);

    }

    public Teacher getTeacherByName(String name){

        return teachermap.get(name);
    }
    public List<String> getStudentsByTeacherName(String teacher){
        return teacherStudent.get(teacher);
    }

    public List<String> getAllStudents(){
        List<String> list = new ArrayList<>();
        for(Student student:studentMap.values()){
            list.add(student.getName());
        }
        return list;
    }

    public Teacher deleteTeacherByName(String teacher){
        teacherStudent.remove(teacher);
        return teachermap.remove(teacher);
    }

    public String deleteAllTeachers(){
        teacherStudent.clear();
        teachermap.clear();
        return "OK";
    }
}
