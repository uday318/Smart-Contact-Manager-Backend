package com.scm.Service;

import java.util.List;
import java.util.Optional;

import com.scm.Entities.User;

public interface UserService {
	
	User saveUser(User user);
	
	Optional<User> getUserById(Long id);
	
	User updateUser(Long id ,User user);
	
	void deleteUser(Long id);
	
	boolean isUserExist(Long userId);
	
	boolean isUserExistByEmail(String email);
	
	List<User> getAllUser();

}
