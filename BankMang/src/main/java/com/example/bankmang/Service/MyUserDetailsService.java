package com.example.bankmang.Service;

import com.example.bankmang.ApiException.ApiException;
import com.example.bankmang.Model.User;
import com.example.bankmang.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MyUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findUserByUserName(username);
        if (user==null){
            throw  new ApiException("Wrong userName or password");
        }
        return null;
    }
}
