package com.example.bankmang.Controller;

import com.example.bankmang.Model.User;
import com.example.bankmang.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Api/v1/user")
public class UserController {
    private final UserService userService;
    @GetMapping("/get")
    public ResponseEntity GetAllUser(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUser());
    }
    @PostMapping("/add")
    public ResponseEntity AddUser(@RequestBody @Valid User user){
        userService.addUser(user);
        return ResponseEntity.status(HttpStatus.OK).body("added user");
    }
    @PutMapping("/put")
    public ResponseEntity UpdateUser(@AuthenticationPrincipal User auth ,@RequestBody @Valid User user){
        userService.updateUser(auth.getId(),user);
        return ResponseEntity.status(HttpStatus.OK).body("update user");
    }
    @DeleteMapping("/delete")
    public ResponseEntity deleteUser(@AuthenticationPrincipal User auth ){
        userService.deleteUser(auth.getId());
        return ResponseEntity.status(HttpStatus.OK).body("delete user");
    }
    @PostMapping("/logout")
    public ResponseEntity logout(){
        return ResponseEntity.status(200).body("logout");
    }
    @PostMapping("/login")
    public ResponseEntity login(){
        return ResponseEntity.status(200).body("Logged in successfully");
    }

}
