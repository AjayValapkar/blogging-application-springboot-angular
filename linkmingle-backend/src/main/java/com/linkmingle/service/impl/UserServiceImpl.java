package com.linkmingle.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.linkmingle.dto.LoginDto;
import com.linkmingle.dto.UserDto;
import com.linkmingle.models.User;
import com.linkmingle.repository.UserRepository;
import com.linkmingle.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userreopsitory;


	@Override
	public String saveUser(UserDto userdto) {
	    if (userreopsitory.existsByEmail(userdto.getEmail())) {
	        return "Email already exists";
	    }
	    User user = new User();
	    user.setFirstname(userdto.getFirstname());
	    user.setLastname(userdto.getLastname());
	    user.setEmail(userdto.getEmail());
	    String hashedPassword = BCrypt.hashpw(userdto.getPassword(), BCrypt.gensalt());
	    user.setPassword(hashedPassword);
	    userreopsitory.save(user);
	    return user.getFirstname();
	}


	@Override
	public String login(LoginDto loginDto) {
	    User user = userreopsitory.findByEmail(loginDto.getEmail());
	    if (user == null) {
	        return null;
	    }
	    String storedPassword = user.getPassword();
	    if (passwordsMatch(loginDto.getPassword(), storedPassword)) {
	        return user.getFirstname();
	    } else {
	        return null;
	    }
	}

	private boolean passwordsMatch(String inputPassword, String storedPassword) {
	    return BCrypt.checkpw(inputPassword, storedPassword);
	}


}
