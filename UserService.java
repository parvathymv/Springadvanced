package com.test.springwservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.springwservice.entity.User;
import com.test.springwservice.repository.UserRepository;

@Service
public class UserService {
	@Autowired
   UserRepository userRepo;
	public User saveUser(User user) {
		
		return userRepo.save(user);
		
	}
	public List<User> getAllUser() {
		
		return userRepo.findAll();
	}
	public User getUser(long userid) {
		
		return userRepo.findById(userid).get();
	}

	public User updateUser(long  id, User updatedUser) {
		User existingUser = getUser(id);
		existingUser.setName(updatedUser.getName());
		existingUser.setEmail(updatedUser.getEmail());
		
		return userRepo.save(existingUser);
	}
	public String deleteUser(long userid) {
		String result="";
		Optional<User> existingUser = userRepo.findById(userid);
		if(existingUser.isPresent())
		{
		userRepo.deleteById(userid);
		result="User deleted";
		}
		else
		{
			result="User Id not found";
		}
		return result;
		
	}

}
