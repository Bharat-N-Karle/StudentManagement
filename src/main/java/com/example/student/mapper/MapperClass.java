package com.example.student.mapper;

import com.example.student.dto.CourseDto;
import com.example.student.dto.StudentDto;
import com.example.student.entity.Course;
import com.example.student.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Builder
@Component
public class MapperClass {
    public Student toStudent(StudentDto studentDto){


        Student student = new Student();
        student.setFullName(studentDto.getFullName());
        student.setAddress(studentDto.getAddress());
        student.setEmail(studentDto.getEmail());
        return student;
    }

    public StudentDto toStudentDto(Student student){

        StudentDto studentDto = new StudentDto();
        studentDto.setFullName(student.getFullName());
        studentDto.setAddress(student.getAddress());
        studentDto.setEmail(student.getEmail());
        if (student.getCourse() != null) {
            CourseDto courseDto = new CourseDto();
            courseDto.setCourseName(student.getCourse().getCourseName());
            courseDto.setCourseFees(student.getCourse().getCourseFees());
            studentDto.setCourse(courseDto);
        }
        return studentDto;
    }

    public Course toCourse(CourseDto courseDto){
        Course course = new Course();
        course.setCourseName(courseDto.getCourseName());
        course.setCourseFees(courseDto.getCourseFees());
        return course;
    }

    public CourseDto toCourseDto(Course course){
        CourseDto courseDto = new CourseDto();
        courseDto.setCourseName(course.getCourseName());
        courseDto.setCourseFees(course.getCourseFees());
        return courseDto;
    }
}
