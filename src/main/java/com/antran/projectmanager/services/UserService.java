package com.antran.projectmanager.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.antran.projectmanager.models.LoginUser;
import com.antran.projectmanager.models.User;
import com.antran.projectmanager.repositories.UserRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo userRepo;
	
// ==================== Login/Register =========================
	
	public User register(User newUser, BindingResult result) {
		if(userRepo.findByEmail(newUser.getEmail()).isPresent()) {
			result.rejectValue("email", "Unique", "Email is already in use");
		}
		
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "Matches", "Password and Confirm Password mush match");
		}
		
		if(result.hasErrors()) {
			return null;
		}
		String hash = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hash);
		return userRepo.save(newUser);
	}
	
	public User login(LoginUser newLogin, BindingResult result) {
		Optional<User> optionalUser = userRepo.findByEmail(newLogin.getEmail());
		if(optionalUser.isPresent()) {
			User user = optionalUser.get();
			if(BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
				return user;
			}
		}
		result.rejectValue("email", "Unique", "Invalid Email/Password");
		result.rejectValue("password", "Unique", "Invalid Email/Password");
		return null;
	}

//	======================== Find by ID ============================
	
	public User findUser(Long id) {
		return userRepo.findById(id).orElse(null);
	}
}
