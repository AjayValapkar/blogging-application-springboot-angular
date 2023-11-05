package com.linkmingle.service;

import org.springframework.stereotype.Service;

import com.linkmingle.dto.LoginDto;
import com.linkmingle.dto.UserDto;

@Service
public interface UserService {

	String saveUser(UserDto userDto);

	String login(LoginDto loginDto);


}
