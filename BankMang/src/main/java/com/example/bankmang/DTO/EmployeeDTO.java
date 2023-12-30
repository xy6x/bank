package com.example.bankmang.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeDTO {
    private Integer user_id;
    private String position;
    private double salary;
}
