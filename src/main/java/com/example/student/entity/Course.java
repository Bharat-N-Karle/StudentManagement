package com.example.student.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Course_Id")
    private Long id;
    @Column(name = "CourseName")
    private String courseName;
    @Column(name = "CourseFees")
    private Integer courseFees;

    @OneToOne(mappedBy = "course")
    private Student student;

}
