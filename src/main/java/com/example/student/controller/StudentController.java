package com.example.student.controller;

import com.example.student.dto.StudentDto;
import com.example.student.services.StudentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/addStudent")
    public ResponseEntity<String> addStudent(@Valid @RequestBody StudentDto studentDto){
        studentService.saveData(studentDto);
        return ResponseEntity.status(201).body("student added successfully");
    }

    @GetMapping("/getStudents")
    public ResponseEntity<List<StudentDto>> getAllStudent(){
        List<StudentDto> students = studentService.getAllStudent();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{id}")
    public StudentDto getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    @DeleteMapping("/deleteStudents")
    public ResponseEntity<String> deleteAllStudents(){
        studentService.deleteStudents();
        return ResponseEntity.status(200).body("Students deleted successfully");
    }

    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        studentService.deleteStudentById(id);
        return ResponseEntity.status(200).body("student with given id deleted successfully");
    }

    @GetMapping("/email/{email}")
    public StudentDto getStudentByEmail(@PathVariable String email){
        return studentService.getStudentByEmail(email);
    }
}
