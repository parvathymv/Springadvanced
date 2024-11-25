package com.test.springwservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.springwservice.entity.User;
import com.test.springwservice.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	UserService userService;

	@PostMapping("/addUser")
	public User saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}

	@GetMapping("/getAllUsers")
	public List<User> getAllUsers() {
		List<User> userList = userService.getAllUser();
		return userList;
	}

	@GetMapping("/getUserById/{userid}")
	public User getUserById(@PathVariable("userid") long userid) {
		return userService.getUser(userid);
	}

	@PostMapping("/updateUser/{userid}")
	public User updateUser(@PathVariable long userid, @RequestBody User user) {
		return userService.updateUser(userid, user);
	}
@DeleteMapping("/deleteUser/{userid}")
	public String deleteUser(@PathVariable long userid)
	{
		return userService.deleteUser(userid);
		
	}
	
}