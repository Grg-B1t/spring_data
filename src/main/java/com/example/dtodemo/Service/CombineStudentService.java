package com.example.dtodemo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dtodemo.Dao.DaoImplement;
import com.example.dtodemo.Dto.CombineStudent;
import com.example.dtodemo.Dto.Student;
import com.example.dtodemo.Dto.StudentInformation;

@Service
public class CombineStudentService implements CombineStudentServiceInterface {

    @Autowired
    DaoImplement da;
    
    @Override
    public List<CombineStudent> getAllStudent() {
        return da.getAllStudent();
    }

    @Override
    public Student addStudent(Student stu) {
        return da.addStudent(stu);
    }

    @Override
    public StudentInformation addStudentInfo(StudentInformation stuInfo) {
        return da.addStudentInformation(stuInfo);
    }

    @Override
    public String removeStudent(Integer studentId) {
        
        return da.deleteStudent(studentId);
    }

    @Override
    public CombineStudent addCombineStudent(CombineStudent cbs) {
        return da.insertCombineStudent(cbs);
    }

    @Override
    public CombineStudent updateCombineStudent(CombineStudent cbs) {
        return da.updateCombineStudent(cbs);
    }
    
}
