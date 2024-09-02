package com.scm.ServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.Entities.User;
import com.scm.Exception.ResourceNotFoundException;
import com.scm.Exception.ValidationException;
import com.scm.Repository.UserRepository;
import com.scm.Service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	//Register User 
	@Override
	public  User saveUser(User user) {
		
		if(user.getName() == null || user.getName().isEmpty()) {
			throw new ValidationException("User Name is Required!!");
		}
		
		if(user.getEmail() == null || user.getEmail().isEmpty()) {
			throw new ValidationException("Email Is Required!!");
		}
		if(user.getPhoneNumber() == null || user.getPhoneNumber().isEmpty()) {
			throw new ValidationException("Phone Number Required!!");
		}
		if(user.getPassword() == null || user.getPassword().isEmpty()) {
			throw new ValidationException("Password is Required!!");
		}
		
		//String userId =UUID.randomUUID().toString();
		//user.setUserId(userId);
		return userRepository.save(user);
	}
	
	//get user profile by user ID
	@Override
	public Optional<User> getUserById(Long id) {

		return userRepository.findById(id);
	}

	@Override
	public User updateUser(Long id ,User user) {
	
		User user2 = userRepository.findById(user.getUserId())
				.orElseThrow(()-> new ResourceNotFoundException("User Not Found"));
		
		user2.setName(user.getName());
		user2.setEmail(user.getEmail());
		user2.setPassword(user.getPassword());
		user2.setAbout(user.getAbout());
		user2.setPhoneNumber(user.getPhoneNumber());
		user2.setProfilePic(user.getProfilePic());   
		user2.setEnabled(user.isEnabled());
		user2.setEmailVerified(user.isEmailVerified());
		user2.setPhoneVerified(user.isPhoneVerified());
		user2.setProviders(user.getProviders());
		user2.setProviderUserId(user.getProviderUserId());
		
		return userRepository.save(user2);
	}

	@Override
	public void deleteUser(Long id) {
		User user2 = userRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("User Not Found"));
		userRepository.delete(user2);
		
	}

	@Override
	public boolean isUserExist(Long userId) {
		User user2 = userRepository.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User Not Found"));
		
		if(user2 != null) {
			return true;
		}
		else {
			return false;
		}
		
	}

	@Override
	public boolean isUserExistByEmail(String email) {
		User user = userRepository.findByEmail(email).orElse(null);
		
		if(user != null) {
			return true;
		}
		return false;
	}

	@Override
	public List<User> getAllUser() {
		
		return userRepository.findAll();
	}

}
