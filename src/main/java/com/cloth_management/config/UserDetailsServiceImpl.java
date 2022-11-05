package com.cloth_management.config;


import com.cloth_management.Models.LoginDetails;
import com.cloth_management.Models.User;
import com.cloth_management.Repository.UserRepository;
import com.cloth_management.Repository.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Transactional
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Lazy
    @Autowired
    private UserRepository userRepository;


    @Override
    public com.cloth_management.config.MyUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.getUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username");
        }

        // Need to update timeStamp
        return new com.cloth_management.config.MyUserDetails(user);
    }
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.getUserByUsername(username);
//        List<GrantedAuthority> grantList = new ArrayList<>();
//        String[] roles = user.getUser_type().split(" ");
//        for (int i = 0; i < roles.length; i++) {
//            GrantedAuthority authority = new SimpleGrantedAuthority(roles[i]);
//            grantList.add(authority);
//        }
//        return new org.springframework.security.core.userdetails.User(
//                user.getUsername(), user.getUser_password(), grantList
//        );
//
//    }
}