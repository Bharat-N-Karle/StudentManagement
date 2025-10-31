package com.example.student.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Student_ID")
    private Long id;

    @Column(name = "Student_FullName")
    private String fullName;

    @Column(name = "Student_Email", unique = true)
    private String email;

    @Column(name = "Student_Address")
    private String address;

    private LocalDateTime createdDate;

    @PrePersist // runs before entity is saved
    public void prePersist() {
        createdDate = LocalDateTime.now(); // set current date-time automatically
    }
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id", referencedColumnName = "course_Id")
    private Course course;
}
