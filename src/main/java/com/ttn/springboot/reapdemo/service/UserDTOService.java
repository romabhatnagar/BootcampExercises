package com.ttn.springboot.reapdemo.service;

import com.ttn.springboot.reapdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDTOService {
    @Autowired
    UserRepository userRepository;
}
