package com.example.dtodemo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dtodemo.Dto.CombineStudent;
import com.example.dtodemo.Dto.Student;
import com.example.dtodemo.Dto.StudentInformation;
import com.example.dtodemo.Service.CombineStudentService;

@RestController
@RequestMapping("/api")
public class CombineStudentController {
    
    @Autowired
    CombineStudentService css;

    @GetMapping("/getCombineStudents")
    public ResponseEntity<List<CombineStudent>> getAllStu(){
        try {
            return new ResponseEntity<>(css.getAllStudent(), HttpStatus.FOUND);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addStudent")
    public ResponseEntity<Student> addStudent(@RequestBody Student stu){
        try {
            return new ResponseEntity<>(css.addStudent(stu), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/addStudentInfo")
    public ResponseEntity<StudentInformation> addStudentInfo(@RequestBody StudentInformation stuInfo){
        try {
            return new ResponseEntity<>(css.addStudentInfo(stuInfo), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/removeStudent/{studentId}")
    public ResponseEntity<String> removeStudent(@PathVariable Integer studentId){
        try {
            return new ResponseEntity<>(css.removeStudent(studentId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }

    @PostMapping("/insertCombineStudent")
    public ResponseEntity<CombineStudent> insertCombineStudent(@RequestBody CombineStudent cbs){
        try {
            return new ResponseEntity<CombineStudent>(css.addCombineStudent(cbs), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<CombineStudent>(HttpStatus.NOT_ACCEPTABLE);
        }

    }

    @PutMapping("/updateCombineStudent")
    public ResponseEntity<CombineStudent> updateCombineStudent(@RequestBody CombineStudent cbs){
        try {
            return new ResponseEntity<CombineStudent>(css.updateCombineStudent(cbs), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
