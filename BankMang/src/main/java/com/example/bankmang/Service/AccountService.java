package com.example.bankmang.Service;

import com.example.bankmang.ApiException.ApiException;
import com.example.bankmang.DTO.AccountDTO;
import com.example.bankmang.Model.Account;
import com.example.bankmang.Model.Customer;
import com.example.bankmang.Model.Employee;
import com.example.bankmang.Repository.AccountRepository;
import com.example.bankmang.Repository.CustomerRepository;
import com.example.bankmang.Repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;
    private final EmployeeRepository employeeRepository;

    public List<Account> getAllAccount() {
        return accountRepository.findAll();
    }

    public void addAccount(Integer id,AccountDTO accountDTO) {
        Customer customer = customerRepository.findCustomerById(id);
        if (customer == null) {
            throw new ApiException("the customer not found");
        }
        Account account = new Account(null, accountDTO.getAccountNumber(), accountDTO.getBalance(), accountDTO.getAsActive(),customer);
        accountRepository.save(account);
    }

    public void updateAccount(Integer id, AccountDTO accountDTO) {
        Account account = accountRepository.findAccountById(id);
        if (account == null) {
            throw new ApiException("the account not found");
        }
        account.setAccountNumber(accountDTO.getAccountNumber());
        account.setBalance(accountDTO.getBalance());
        account.setAsActive(accountDTO.getAsActive());
        accountRepository.save(account);
    }

    public void deleteAccount(Integer id) {

        Account account = accountRepository.findAccountById(id);
        if (account == null) {
            throw new ApiException("the account not found");
        }
        accountRepository.delete(account);
    }
    public List<Account> ActiveBank(Integer auth){
        Employee employee=employeeRepository.findEmployeeById(auth);
        if (employee== null) {
            throw new ApiException("the employee not found");
        }
            List<Account> account = accountRepository.findAccountByAsActive();;

            return account;
    }
    public void CheckAccount(Integer auth,Integer id) {
        Account account = accountRepository.findAccountById(id);
        Employee employee = employeeRepository.findEmployeeById(auth);
        if (employee.getPosition().equals("boss")) {

            if (account.getAsActive().equals(false)) {
                account.setAsActive(true);
                accountRepository.save(account);
            } else throw new ApiException("the id not found");
        }else throw new ApiException("the employee not boss");
    }
    public Account myAccount(Integer auth){
        Account account=accountRepository.findAccountById(auth);
        if (account == null) {
       throw new ApiException("the account not found");
    }
        return account;
    }

}
