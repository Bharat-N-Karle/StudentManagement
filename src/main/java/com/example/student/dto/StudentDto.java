package com.example.student.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    @NotBlank(message = "Full name is required")
    private String fullName;

    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Address is required")
    private String address;

    @Valid
    private CourseDto course;
}
