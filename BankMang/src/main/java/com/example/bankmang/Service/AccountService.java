package com.example.bankmang.Service;

import com.example.bankmang.ApiException.ApiException;
import com.example.bankmang.DTO.AccountDTO;
import com.example.bankmang.Model.Account;
import com.example.bankmang.Model.Customer;
import com.example.bankmang.Repository.AccountRepository;
import com.example.bankmang.Repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;

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
    public List<Account> ActiveBank(){
       List <Account> account =accountRepository.findAccountByAsActive();

       return account;
    }
}
