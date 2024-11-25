package com.test.springwservice.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.springwservice.dto.UserDTO;
import com.test.springwservice.entity.User;
import com.test.springwservice.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	UserService userService;

	@Autowired
	private ModelMapper modelMapper;

	@PostMapping("/addUser")
//	public User saveUser(@RequestBody User user) {
	public User saveUser(@RequestBody UserDTO userDto) {
		User user = modelMapper.map(userDto, User.class);
		return userService.saveUser(user);
	}

	@GetMapping("/getAllUsers")
	// public List<User> getAllUsers() {
	public List<UserDTO> getAllUsers() {
		return userService.getAllUsers().stream().map(u -> modelMapper.map(u, UserDTO.class))
				.collect(Collectors.toList());
		// List<User> userList = userService.getAllUser();
		// return userList;
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
	public String deleteUser(@PathVariable long userid) {
		return userService.deleteUser(userid);

	}

	@GetMapping("/findNameStartsWith/{prefix}")
	List<User> findUsersNameStartingWith(@PathVariable String prefix)
	{
	return userService.findUsersNameStartingWith(prefix);
	}
	
	@GetMapping("/findNameEndsWith/{suffix}")
	List<User> findUsersNameEndingWith(@PathVariable String suffix)
	{
	return userService.findUsersNameEndingWith(suffix);
	}
	
	@GetMapping("/findUserByEmail/{email}")
	User getUserByEmail(@PathVariable String email)
	{
	 return userService.getUserByEmail(email);	
	}
	
	@PutMapping("/updateUserByName/{email}/{name}")
	public String updateUserByName(@PathVariable String email,@PathVariable String name)
	{
		
		return userService.updateUserByName(email, name);
	}
}