package com.scm.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scm.Entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	Optional<User> findByEmail(String email);

	void deleteById(Long userId);

}
