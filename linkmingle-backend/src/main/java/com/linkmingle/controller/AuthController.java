package com.linkmingle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.linkmingle.dto.LoginDto;
import com.linkmingle.dto.UserDto;
import com.linkmingle.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200") 
@RequestMapping("/users")
public class AuthController {
	// http://localhost:8080/users/register

	@Autowired
	UserService userservice;

	@PostMapping("/register")
	public ResponseEntity<String> createUser(@RequestBody UserDto userDto) {
		try {
			String userId = userservice.saveUser(userDto);
			return ResponseEntity.ok("User successfully registered with ID: " + userId);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Registration failed: " + e.getMessage());
		}
	}

	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@RequestBody LoginDto loginDto) {
		try {
			String userlastname = userservice.login(loginDto);
			if (userlastname != null) {
				return ResponseEntity.ok("User successfully login " + userlastname);
			} else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Login failed: " + e.getMessage());
		}
	}

}
