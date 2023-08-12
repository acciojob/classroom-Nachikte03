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
        return studentMap.put(student.getName(),student);
    }

    public Teacher addTeacher(Teacher teacher){
        return teachermap.put(teacher.getName(),teacher);
    }

    public String addStudentTeacherPair(String student,String teacher){
        List<String> list = new ArrayList<>();
        if(teacherStudent.containsKey(teacher)){
            list = teacherStudent.get(teacher);
        }
        if(studentMap.containsKey(student)){
            list.add(student);
        }
        teacherStudent.put(teacher,list);
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

    public String deleteTeacherByName(String teacher){
        teacherStudent.remove(teacher);
        List<String> list = teacherStudent.get(teacher);
        for(String student:list){
            if(studentMap.containsKey(student)){
                studentMap.remove(student);
            }
        }
        teachermap.remove(teacher);
        return teacher;
    }

    public String deleteAllTeachers(){
        for(String teacher:teachermap.keySet()){
            deleteTeacherByName(teacher);
        }
        return "OK";
    }
}
