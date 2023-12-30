package com.example.bankmang.Repository;

import com.example.bankmang.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Integer> {
    Account findAccountById(Integer id);
}
