package com.example.dtodemo.Service;

import java.util.List;

import com.example.dtodemo.Dto.CombineStudent;
import com.example.dtodemo.Dto.Student;
import com.example.dtodemo.Dto.StudentInformation;

public interface CombineStudentServiceInterface {
    List<CombineStudent> getAllStudent();
    Student addStudent(Student stu);
    StudentInformation addStudentInfo(StudentInformation stuInfo);
    String removeStudent(Integer studentId);
    CombineStudent addCombineStudent(CombineStudent cbs);
    CombineStudent updateCombineStudent(CombineStudent cbs);
}
