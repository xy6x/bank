package com.example.bankmang.Service;

import com.example.bankmang.ApiException.ApiException;
import com.example.bankmang.DTO.EmployeeDTO;
import com.example.bankmang.Model.Employee;
import com.example.bankmang.Model.User;
import com.example.bankmang.Repository.EmployeeRepository;
import com.example.bankmang.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final UserRepository userRepository;


    public List<Employee> getAllEmp(){
        return employeeRepository.findAll();
    }
    public void addEmployee(Integer id,EmployeeDTO employeeDTO){
        User user=userRepository.findUserById(id);
        if (user == null) {
            throw new ApiException("The user not found");
        }
        else if (employeeDTO.getUser_id()!=id) {
            throw new ApiException("The user not same");
        }

        Employee employee=new Employee(null,employeeDTO.getPosition(),employeeDTO.getSalary(),user);
        employeeRepository.save(employee);
    }
    public void updateEmployee(Integer id, EmployeeDTO employeeDTO){
        Employee oldemp=employeeRepository.findEmployeeById(id);
        if (oldemp == null) {
            throw new ApiException("The employee not found");
        }
        oldemp.setPosition(employeeDTO.getPosition());
        oldemp.setSalary(employeeDTO.getSalary());
        employeeRepository.save(oldemp);
    }
    public void deleteEmp(Integer id){
        Employee employee=employeeRepository.findEmployeeById(id);
        if (employee == null) {
            throw new ApiException("The employee not found");
        }
        employeeRepository.delete(employee);
    }
}
