package com.example.Login.service;

import com.example.Login.dao.UserRepository;
import com.example.Login.dao.model.UserModel;
import com.example.Login.entity.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<UsersEntity> usersEntityOptional=userRepository.findByUserName(userName);
        if(usersEntityOptional.isPresent())
        {
            return new UserModel(usersEntityOptional.get());
        }else {
            throw new UsernameNotFoundException("User name not found"+userName);
        }

    }
}
