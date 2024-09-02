package com.scm.Entities;


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Contact {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String email;
	private String phonenumber;
	private String address;
	private String picture;
	//@Column(length = 10000)
	private String description;
	private boolean favorite=false;
	private String websiteLink;
	private String linkedInLink;
	
	@Enumerated(EnumType.STRING)
	private CategoryEnum category;
	
	@ManyToOne
	@JsonBackReference
	private User user;
	
	 @OneToMany(mappedBy = "contact" ,cascade = CascadeType.ALL , fetch = FetchType.EAGER ,orphanRemoval = true)
	 private List<SocialLink> links =new ArrayList<>();
	 
	

	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contact(Long id, String name, String email, String phonenumber, String address, String picture,
			String description, boolean favorite, String websiteLink, String linkedInLink, User user) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phonenumber = phonenumber;
		this.address = address;
		this.picture = picture;
		this.description = description;
		this.favorite = favorite;
		this.websiteLink = websiteLink;
		this.linkedInLink = linkedInLink;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isFavorite() {
		return favorite;
	}

	public void setFavorite(boolean favorite) {
		this.favorite = favorite;
	}

	public String getWebsiteLink() {
		return websiteLink;
	}

	public void setWebsiteLink(String websiteLink) {
		this.websiteLink = websiteLink;
	}

	public String getLinkedInLink() {
		return linkedInLink;
	}

	public void setLinkedInLink(String linkedInLink) {
		this.linkedInLink = linkedInLink;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<SocialLink> getLinks() {
		return links;
	}

	public void setLinks(List<SocialLink> links) {
		this.links = links;
	}

	public CategoryEnum getCategory() {
		return category;
	}

	public void setCategory(CategoryEnum category) {
		this.category = category;
	}
	
	

}
