package com.pariuri.springboot.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.pariuri.springboot.model.User;
import com.pariuri.springboot.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}
