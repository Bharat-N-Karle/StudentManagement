package com.example.student.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {

    @NotBlank(message = "Course Name is required")
    private String courseName;

    @NotNull(message = "Course Fee is required")
    private Integer courseFees;
}
