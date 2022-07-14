package com.example.dtodemo.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CombineStudent {
   // @JsonIgnore
    private Integer id;
    private String firstName;
    private String lastName;
    private Double grade;
    private String studentAddress;
    private String GaurdianName;
    private String studentMajor;
    public CombineStudent() {
    }
    public CombineStudent(Integer id, String firstName, String lastName, Double grade, String studentAddress,
            String gaurdianName, String studentMajor) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
        this.studentAddress = studentAddress;
        this.GaurdianName = gaurdianName;
        this.studentMajor = studentMajor;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Double getGrade() {
        return grade;
    }
    public void setGrade(Double grade) {
        this.grade = grade;
    }
    public String getStudentAddress() {
        return studentAddress;
    }
    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }
    public String getGaurdianName() {
        return GaurdianName;
    }
    public void setGaurdianName(String gaurdianName) {
        GaurdianName = gaurdianName;
    }
    public String getStudentMajor() {
        return studentMajor;
    }
    public void setStudentMajor(String studentMajor) {
        this.studentMajor = studentMajor;
    }
    
}
