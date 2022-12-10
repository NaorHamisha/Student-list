package com.example.studentlist.BL;

import android.os.Build;

import com.example.studentlist.model.Student;

import java.sql.Struct;
import java.util.LinkedList;
import java.util.List;

public class StudentsBL {
    private static final StudentsBL _instance = new StudentsBL();

    public static StudentsBL instance() {
        return _instance;
    }

    private List<Student> studentList;

    private StudentsBL() {
        studentList = new LinkedList<>();

        addStudent(new Student("Naor", "78788778" , "adre", "052405", true));
        addStudent(new Student("Yam" , "878789", "adffre", "05245605", false));
        addStudent(new Student("Nadav" , "123456", "fdgdfgd", "05245353405", true));
        addStudent(new Student("Hadar" , "885998", "dfgasdfg", "05253453405", false));
    }

    public List<Student> getAllStudents() {
        return studentList;
    }

    public void addStudent(Student st) {
        studentList.add(st);
    }

    public void addStudent(String name, String id, String address, String phone, Boolean isChecked) {
        Student st = new Student(name, id, address, phone, isChecked);
        studentList.add(st);
    }

    public void editStudent(String prevId, Student newStudent) {
        for (Student std: studentList) {
            if (std.id.equals(prevId)) {
                std.id = newStudent.id;
                std.name = newStudent.name;
                std.phone = newStudent.phone;
                std.address = newStudent.address;
                std.cb = newStudent.cb;

                break;
            }
        }
    }

    public void deleteStudentByID(String id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).id.equals(id)) {
                studentList.remove(i);
                break;
            }
        }
    }
}
