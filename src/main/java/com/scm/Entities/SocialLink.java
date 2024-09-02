package com.scm.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class SocialLink {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String link;
	private String title;
	
	@ManyToOne
	@JsonBackReference
	private Contact contact;

	public SocialLink() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SocialLink(Long id, String link, String title, Contact contact) {
		super();
		this.id = id;
		this.link = link;
		this.title = title;
		this.contact = contact;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "SocialLink [id=" + id + ", link=" + link + ", title=" + title + ", contact=" + contact + "]";
	}
	
	
	
	
	
}
