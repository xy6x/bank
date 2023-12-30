package com.example.bankmang.Controller;

import com.example.bankmang.DTO.CustomerDTO;
import com.example.bankmang.DTO.EmployeeDTO;
import com.example.bankmang.Model.Customer;
import com.example.bankmang.Model.Employee;
import com.example.bankmang.Model.User;
import com.example.bankmang.Service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/Api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;
    @GetMapping("/get")
    public ResponseEntity GetAllCustomer(){
        return ResponseEntity.status(HttpStatus.OK).body(customerService.getAllCustomer());
    }
    @PostMapping("/add")
    public ResponseEntity AddCustomer(@AuthenticationPrincipal User auth,@RequestBody @Valid CustomerDTO customerDTO){
        customerService.addCustomer(auth.getId(),customerDTO);
        return ResponseEntity.status(HttpStatus.OK).body("added Customer");
    }
    @PutMapping("/put")
    public ResponseEntity UpdateCustomer(@AuthenticationPrincipal User auth , @RequestBody @Valid CustomerDTO customerDTO){
        customerService.updateCustomer(auth.getId(),customerDTO);
        return ResponseEntity.status(HttpStatus.OK).body("update Customer");
    }
    @DeleteMapping("/delete")
    public ResponseEntity deleteCustomer(@AuthenticationPrincipal User auth ){
        customerService.deleteCustomer(auth.getId());
        return ResponseEntity.status(HttpStatus.OK).body("delete Customer");
    }
}
