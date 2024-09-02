package com.scm.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scm.Entities.User;
import com.scm.Service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	//Register User
	@PostMapping("/register")
	public User registerUser(@RequestBody User user) {
		user.setContacts(user.getContacts());
		return userService.saveUser(user);
	}
	
	//get user By user Id
	@GetMapping("/getUserById/{userId}")
	public Optional<User> getUserById(@PathVariable Long userId) {
		
		return userService.getUserById(userId);
	}
	
	//update user 
	@PutMapping("/update/{id}")
	public User updateUser(@PathVariable Long id, @RequestBody User user) {
		return userService.updateUser(id , user);
	}
	
	//delete user 
	@DeleteMapping("delete/{id}")
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
	}
	
	//get All Users
	@GetMapping("/getAllUsers")
	public List<User> getAllUser(){
		return userService.getAllUser();
	}
	
	
	
}
