package com.example.student.services;

import com.example.student.dto.StudentDto;
import com.example.student.entity.Course;
import com.example.student.entity.Student;
import com.example.student.mapper.MapperClass;
import com.example.student.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final MapperClass mapperClass;

    public void saveData(StudentDto studentDto){
        Student student = mapperClass.toStudent(studentDto);
        Course course = mapperClass.toCourse(studentDto.getCourse());
        student.setCourse(course);
        studentRepository.save(student);
    }

    public List<StudentDto> getAllStudent() {
        List<Student> listStudent = studentRepository.findAll();
        return listStudent.stream()
                .map(mapperClass::toStudentDto)
                .toList();
    }

    public StudentDto getStudentById(Long id) {
        Student student = studentRepository
                .findById(id)
                .get();
        return mapperClass.toStudentDto(student);
    }

    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

    public void deleteStudents() {
        studentRepository.deleteAll();
    }

    public StudentDto getStudentByEmail(String email){
         Student student = studentRepository.getStudentByEmail(email);
         return mapperClass.toStudentDto(student);
    }
}
