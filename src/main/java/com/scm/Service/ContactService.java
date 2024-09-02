package com.scm.Service;

import java.util.List;

import com.scm.Entities.Contact;
import com.scm.Entities.User;

public interface ContactService {

	Contact saveContact(Long userId , Contact contact);
	
	Contact update(Contact contact);
	
	List<Contact> getAllContacts();
	
	Contact getById(Long id);
	
	void deleteContact(Long id);
	
	List<Contact> search(String name , String email ,String phoneNumber);
	
	List <Contact> getUserById(Long userId);

	List<Contact> getContactsByUser(User userId);
}
