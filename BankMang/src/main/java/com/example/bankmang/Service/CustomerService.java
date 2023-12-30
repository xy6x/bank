package com.example.bankmang.Service;

import com.example.bankmang.ApiException.ApiException;
import com.example.bankmang.DTO.CustomerDTO;
import com.example.bankmang.Model.Customer;
import com.example.bankmang.Model.User;
import com.example.bankmang.Repository.CustomerRepository;
import com.example.bankmang.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final UserRepository userRepository;
    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }
    public void addCustomer(Integer id,CustomerDTO customerDTO){
        User user=userRepository.findUserById(id);
        if (user == null) {
            throw new ApiException("The user not found");
        }
        Customer customer=new Customer(null,customerDTO.getPhoneNumber(),user,null);
        customerRepository.save(customer);
    }
    public void updateCustomer(Integer id ,CustomerDTO customerDTO){
        Customer customer=customerRepository.findCustomerById(id);
        if (customer == null) {
            throw new ApiException("the customer not found");
        }
        customer.setPhoneNumber(customerDTO.getPhoneNumber());
        customerRepository.save(customer);
    }
    public void deleteCustomer(Integer id){
        Customer customer=customerRepository.findCustomerById(id);
        if (customer == null) {
            throw new ApiException("the customer not found");
        }
        customerRepository.delete(customer);
    }
}
