package com.example.bankmang.Controller;

import com.example.bankmang.DTO.AccountDTO;
import com.example.bankmang.DTO.CustomerDTO;
import com.example.bankmang.Model.Account;
import com.example.bankmang.Model.Customer;
import com.example.bankmang.Model.Employee;
import com.example.bankmang.Model.User;
import com.example.bankmang.Service.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/Api/v1/account")
public class AccountController {
    private final AccountService accountService;
    @GetMapping("/get")
    public ResponseEntity GetAllAccount(){
        return ResponseEntity.status(HttpStatus.OK).body(accountService.getAllAccount());
    }
    @PostMapping("/add")
    public <auth> ResponseEntity AddAccount(@RequestBody @Valid AccountDTO accountDTO,@AuthenticationPrincipal Customer auth){
        accountService.addAccount(auth.getId(),accountDTO);
        return ResponseEntity.status(HttpStatus.OK).body("added Account");
    }
    @PutMapping("/put")
    public ResponseEntity UpdateAccount(@AuthenticationPrincipal User auth , @RequestBody @Valid AccountDTO accountDTO){
        accountService.updateAccount(auth.getId(),accountDTO);
        return ResponseEntity.status(HttpStatus.OK).body("update Account");
    }
    @DeleteMapping("/delete")
    public ResponseEntity deleteAccount(@AuthenticationPrincipal User auth ){
        accountService.deleteAccount(auth.getId());
        return ResponseEntity.status(HttpStatus.OK).body("delete Account");
    }
}
