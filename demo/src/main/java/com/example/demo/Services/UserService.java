//package com.example.demo.Services;
//
//import com.example.demo.model.User;
//import com.example.demo.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.Collections;
//
//@Service
//public class UserService {
//    @Autowired
//    private UserRepository userRepository;
//
//    public org.springframework.security.core.userdetails.User loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByUsername(username);
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found");
//        }
//        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
//            Collections.singletonList(new SimpleGrantedAuthority(user.getRole())));
//    }
//
//    public User save(User user) {
//        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
//        return userRepository.save(user);
//    }
//
//}
