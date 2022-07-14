package com.example.dtodemo.Dao;

import java.util.List;

import com.example.dtodemo.Dto.CombineStudent;
import com.example.dtodemo.Dto.Student;
import com.example.dtodemo.Dto.StudentInformation;

public interface DaoInterface {
   List<CombineStudent> getAllStudent();
   Student addStudent(Student stu);
   StudentInformation addStudentInformation(StudentInformation stuInfo);
   String deleteStudent(Integer studentId);
   CombineStudent insertCombineStudent(CombineStudent cbs);
   CombineStudent updateCombineStudent(CombineStudent cbs);
}
