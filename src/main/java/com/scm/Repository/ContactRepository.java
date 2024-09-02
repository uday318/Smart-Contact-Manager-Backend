package com.scm.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.scm.Entities.Contact;
import com.scm.Entities.User;

public interface ContactRepository extends JpaRepository<Contact, Long> {

	List<Contact> findByUser(User user);
	
	@Query("SELECT c FROM Contact c WHERE c.user.id =: userId")
	List<Contact> findByUserId(@Param("userId")Long  userId);
	
	
}
