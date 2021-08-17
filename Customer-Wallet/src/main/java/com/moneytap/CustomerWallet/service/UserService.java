package com.moneytap.CustomerWallet.service;

import com.moneytap.CustomerWallet.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    CustomerRepository customerRepository;
    public static String UserName;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        //Logic to get the user form the Database
        UserName=userName;
        String password=customerRepository.findByName(userName).getPassword();

        return new User(userName,password,new ArrayList<>());

    }
}
