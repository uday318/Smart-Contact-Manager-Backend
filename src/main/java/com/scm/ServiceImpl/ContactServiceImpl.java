package com.scm.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.Entities.Contact;
import com.scm.Entities.SocialLink;
import com.scm.Entities.User;
import com.scm.Exception.ResourceNotFoundException;
import com.scm.Repository.ContactRepository;
import com.scm.Repository.UserRepository;
import com.scm.Service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactRepository contactRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public Contact saveContact(Long userId, Contact contact) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found"));
		
		contact.setUser(user);
		 for (SocialLink link : contact.getLinks()) {
	            link.setContact(contact);
	        }
		return contactRepository.save(contact);
	}

	@Override
	public Contact update(Contact contact) {
		return null;
	}

	@Override
	public List<Contact> getAllContacts() {
		return contactRepository.findAll();
	}

	@Override
	public Contact getById(Long id) {
		
		return contactRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Contact Not Found"));
	}

	@Override
	public void deleteContact(Long id) {
		Contact contactId = 
				contactRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Contact Not Found"));
		
		contactRepository.delete(contactId);
	}
	
	@Override
	public List<Contact> getContactsByUser(User userId) {
		
		return contactRepository.findByUser(userId);
	}

	@Override
	public List<Contact> search(String name, String email, String phoneNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contact> getUserById(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public List<Contact> getUserById(Long userId) {
//		
//		return contactRepository.findByUserId(userId);
//	}

	

}
