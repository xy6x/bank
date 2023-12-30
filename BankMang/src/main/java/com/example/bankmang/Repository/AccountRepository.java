package com.example.bankmang.Repository;

import com.example.bankmang.Model.Account;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account,Integer> {
    Account findAccountById(Integer id);

  @Query("select e from Account e WHERE  e.asActive = true ")
    List<Account> findAccountByAsActive();
}
