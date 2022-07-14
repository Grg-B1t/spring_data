package com.example.dtodemo.Dto;

public class Student {
    private Integer id;
    private String firstName;
    private String lastName;
    private Double grade;
    public Student() {
    }
    public Student(Integer id, String firstName, String lastName, Double grade) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
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
    
}
