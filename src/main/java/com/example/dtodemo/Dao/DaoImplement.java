package com.example.dtodemo.Dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.dtodemo.Dto.CombineStudent;
import com.example.dtodemo.Dto.Student;
import com.example.dtodemo.Dto.StudentInformation;

@Repository
public class DaoImplement implements DaoInterface {
    private JdbcTemplate jt;

    private final String getAllStudentQuery = "select student.first_name, student.last_name, student.grade, StudentInfo.student_address, StudentInfo.student_guardian, StudentInfo.student_major from student inner join StudentInfo on StudentInfo.student_id = student.id";
    private final String addStudentQuery = "insert into student (id, first_name, last_name, grade) values (?, ?, ?, ?)";
    private final String addStudentInfoQuery = "insert into studentinfo (student_address, student_guardian, student_major, student_id) values (?, ?, ?, ?)";
    private final String deleteStudentQuery1 = "delete from studentinfo where student_id = ?";
    private final String deleteStudentQuery2 = "delete from student where id = ?";
    private final String updateStudentQuery = "update student set first_name = ?, last_name = ?, grade = ? where id = ?";
    private final String updateStudentInfoQuery = "update studentinfo set student_address = ?, student_guardian = ?, student_major = ? where student_id = ?";

    @Autowired
    public void dataSource(DataSource ds){
        this.jt = new JdbcTemplate(ds);
    }



    @Override
    public List<CombineStudent> getAllStudent() {
        List<CombineStudent> stuList = jt.query(getAllStudentQuery, new CombineStudentMapper());
        return stuList;
    }



    @Override
    public Student addStudent(Student stu) {
        Object[] obj = new Object[]{stu.getId(), stu.getFirstName(), stu.getLastName(), stu.getGrade()};
        jt.update(addStudentQuery, obj);
        return stu;
    }



    @Override
    public StudentInformation addStudentInformation(StudentInformation stuInfo) {
        Object[] obj = new Object[]{stuInfo.getStudentAddress(), stuInfo.getGaurdianName(), stuInfo.getStudentMajor(), stuInfo.getStudent_id()};
        jt.update(addStudentInfoQuery, obj);
        return stuInfo;
    }



    @Override
    public String deleteStudent(Integer studentId) {
        jt.update(deleteStudentQuery1, studentId);
        jt.update(deleteStudentQuery2, studentId);
        return "Student data is removed from the database!";
    }



    @Override
    public CombineStudent insertCombineStudent(CombineStudent cbs) {
        Object[] student = new Object[]{cbs.getId(), cbs.getFirstName(), cbs.getLastName(), cbs.getGrade()};
        jt.update(addStudentQuery, student);

        Object[] studentInfo = new Object[]{cbs.getStudentAddress(), cbs.getGaurdianName(), cbs.getStudentMajor(), cbs.getId()};
        jt.update(addStudentInfoQuery, studentInfo);
        
        return cbs;
    }



    @Override
    public CombineStudent updateCombineStudent(CombineStudent cbs) {
        Object[] studentObj = new Object[]{cbs.getFirstName(), cbs.getGaurdianName(), cbs.getGrade(), cbs.getId()};
        Object[] studentInfoObj = new Object[]{cbs.getStudentAddress(), cbs.getGaurdianName(), cbs.getStudentMajor(), cbs.getId()};
        
        jt.update(updateStudentQuery, studentObj);
        jt.update(updateStudentInfoQuery, studentInfoObj);

        return cbs;
    }
}
