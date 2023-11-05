package com.linkmingle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.linkmingle.dto.UserDto;
import com.linkmingle.models.User;
import com.linkmingle.repository.UserRepository;

@RestController
@RequestMapping("/blogs/user")
public class UserController {

	@Autowired
	UserRepository userRepository;

	@GetMapping("/email/{email}")
	public UserDto getUserByEmail(@PathVariable String email) {
		User user = userRepository.findByEmail(email);
		UserDto userdto = new UserDto();
		userdto.setUserId(user.getUserid());
		userdto.setFirstname(user.getFirstname());
		return userdto;
	}

}
