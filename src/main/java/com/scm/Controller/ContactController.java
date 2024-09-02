package com.scm.Controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scm.Entities.Contact;
import com.scm.Entities.User;
import com.scm.Service.ContactService;
import com.scm.ServiceImpl.ExcelExportServiceImpl;

@RestController
@RequestMapping("/contact")
public class ContactController {

	@Autowired
	private ContactService contactService;

	@Autowired
	private ExcelExportServiceImpl excelExportService;

	@PostMapping("/save/{userId}")
	public Contact saveContact(@PathVariable Long userId, @RequestBody Contact contact) {

		return contactService.saveContact(userId, contact);

	}

	// get Contact By Id
	@GetMapping("getContact/{id}")
	public Contact getUserById(@PathVariable Long id) {

		return contactService.getById(id);
	}

	// delete Contact
	@DeleteMapping("delete/{id}")
	public void deleteContact(@PathVariable Long id) {
		contactService.deleteContact(id);
	}

	// get All Contacts
	@GetMapping("/getAllContacts")
	public List<Contact> getAllContacts() {
		return contactService.getAllContacts();
	}

	// getContacts By userId
	@GetMapping("/getContactsByUser/{userId}")
	public List<Contact> getContactsByUser(User userId) {
		return contactService.getContactsByUser(userId);
	}
	
	 @GetMapping("/export/excel")
	    public ResponseEntity<InputStreamResource> exportContactsToExcel() throws IOException {
	        List<Contact> contacts = contactService.getAllContacts();
	        ByteArrayInputStream in = excelExportService.contactsToExcel(contacts);

	        HttpHeaders headers = new HttpHeaders();
	        headers.add("Content-Disposition", "attachment; filename=contacts.xlsx");

	        return ResponseEntity
	                .ok()
	                .headers(headers)
	                .contentType(MediaType.APPLICATION_OCTET_STREAM)
	                .body(new InputStreamResource(in));
	    }


}
