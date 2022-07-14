package com.example.dtodemo.Dto;

public class StudentInformation {
    private String studentAddress;
    private String GaurdianName;
    private String studentMajor;
    private Integer student_id;

    public Integer getStudent_id() {
        return student_id;
    }
    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }
    public StudentInformation() {
    }
    public StudentInformation(String studentAddress, String gaurdianName, String studentMajor, Integer student_id) {
        this.studentAddress = studentAddress;
        GaurdianName = gaurdianName;
        this.studentMajor = studentMajor;
        this.student_id = student_id;
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
