package com.example.dtodemo.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.dtodemo.Dto.*;

public class CombineStudentMapper implements RowMapper<CombineStudent>{

    @Override
    public CombineStudent mapRow(ResultSet rs, int rowNum) throws SQLException {
        CombineStudent c_stu = new CombineStudent();
        c_stu.setFirstName(rs.getString("first_name"));
        c_stu.setLastName(rs.getString("last_name"));
        c_stu.setGrade(rs.getDouble("grade"));
        c_stu.setStudentAddress(rs.getString("student_address"));
        c_stu.setGaurdianName(rs.getString("student_guardian"));
        c_stu.setStudentMajor(rs.getString("student_major"));
        return c_stu;
    }
    
}
