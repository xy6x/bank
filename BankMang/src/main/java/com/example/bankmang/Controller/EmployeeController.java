package com.example.bankmang.Controller;

import com.example.bankmang.DTO.EmployeeDTO;
import com.example.bankmang.Model.Employee;
import com.example.bankmang.Model.User;
import com.example.bankmang.Service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/Api/v1/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    @GetMapping("/get")
    public ResponseEntity GetAllEmp(){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getAllEmp());
    }
    @PostMapping("/add")
    public ResponseEntity AddEmployee(@AuthenticationPrincipal User auth,@RequestBody @Valid EmployeeDTO employeeDTO){
        employeeService.addEmployee(auth.getId(),employeeDTO);
        return ResponseEntity.status(HttpStatus.OK).body("added employee");
    }
    @PutMapping("/put")
    public ResponseEntity UpdateEmployee(@AuthenticationPrincipal User auth , @RequestBody @Valid EmployeeDTO employeeDTO){
        employeeService.updateEmployee(auth.getId(),employeeDTO);
        return ResponseEntity.status(HttpStatus.OK).body("update employee");
    }
    @DeleteMapping("/delete")
    public ResponseEntity deleteEmployee(@AuthenticationPrincipal User auth ){
        employeeService.deleteEmp(auth.getId());
        return ResponseEntity.status(HttpStatus.OK).body("delete employee");
    }
}
