package com.hbn.security.SpringSecurity.service;

import com.hbn.security.SpringSecurity.dao.UserRepo;
import com.hbn.security.SpringSecurity.model.User;
import com.hbn.security.SpringSecurity.model.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailedService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = repo.findByUsername(username);
        if(user == null){
            System.out.println("user is null 404");
            throw new UsernameNotFoundException("404 error");
        }

        return new UserPrincipal(user);
    }
}
