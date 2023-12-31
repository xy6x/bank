package com.example.bankmang.Service;

import com.example.bankmang.ApiException.ApiException;
import com.example.bankmang.Model.User;
import com.example.bankmang.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    public List<User> getAllUser(){

        return userRepository.findAll();
    }
    public void addUser(User user){
            user.setRole("CUSTOMER");
            String hash=new BCryptPasswordEncoder().encode(user.getPassword());
            user.setPassword(hash);
        userRepository.save(user);
    }
    public void updateUser(Integer id,User user){
        User oldUser =userRepository.findUserById(id);
        if (oldUser == null) {
            throw new ApiException("the id user not found");
        }
        oldUser.setUserName(user.getUsername());
        oldUser.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        oldUser.setName(user.getName());
        oldUser.setEmail(user.getEmail());
        userRepository.save(oldUser);

    }
    public void deleteUser(Integer id){
        User user =userRepository.findUserById(id);
        if (user == null) {
            throw new ApiException("the id user not found");
        }
        userRepository.delete(user);
    }

}

