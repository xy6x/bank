package com.example.bankmang.Repository;

import com.example.bankmang.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
Customer findCustomerById(Integer id);

}
