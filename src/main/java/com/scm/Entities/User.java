package com.scm.Entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private Long userId;
	 @Column(name="user_name" ,nullable = false)
	 private String name;
	 @Column(unique = true ,nullable = false)
	 private String email;
	 private String password;
	// @Column(length = 10000)
	 private String about;
	// @Column(length = 10000)
	 private String profilePic;
	 @Column(nullable = false)
	 private String phoneNumber;
	 
	 private boolean enabled=false;
	 private boolean emailVerified=false;
	 private boolean phoneVerified=false;
	 
	 
	 //SELF ,GOOGLE ,GITHUB ,FACEBOOK ,LINKEDIN
	 @Enumerated(EnumType.STRING)
	 private Providers providers = Providers.SELF;
	 private String providerUserId;
	 
	 @OneToMany(mappedBy = "user" ,cascade = CascadeType.ALL , fetch = FetchType.LAZY ,orphanRemoval = true)
	 private List<Contact> contacts =new ArrayList<>();
	 
	
	 
	 
	 public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Long userId, String name, String email, String password, String about, String profilePic,
			String phoneNumber, boolean enabled, boolean emailVerified, boolean phoneVerified, Providers providers,
			String providerUserId) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.about = about;
		this.profilePic = profilePic;
		this.phoneNumber = phoneNumber;
		this.enabled = enabled;
		this.emailVerified = emailVerified;
		this.phoneVerified = phoneVerified;
		this.providers = providers;
		this.providerUserId = providerUserId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public String getProfilePic() {
		return profilePic;
	}
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public boolean isEmailVerified() {
		return emailVerified;
	}
	public void setEmailVerified(boolean emailVerified) {
		this.emailVerified = emailVerified;
	}
	public boolean isPhoneVerified() {
		return phoneVerified;
	}
	public void setPhoneVerified(boolean phoneVerified) {
		this.phoneVerified = phoneVerified;
	}
	public Providers getProviders() {
		return providers;
	}
	public void setProviders(Providers providers) {
		this.providers = providers;
	}
	public String getProviderUserId() {
		return providerUserId;
	}
	public void setProviderUserId(String providerUserId) {
		this.providerUserId = providerUserId;
	}
	
	
	public List<Contact> getContacts() {
		return contacts;
	}
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", mame=" + name + ", email=" + email + ", password=" + password + ", about="
				+ about + ", profilePic=" + profilePic + ", phoneNumber=" + phoneNumber + ", enabled=" + enabled
				+ ", emailVerified=" + emailVerified + ", phoneVerified=" + phoneVerified + ", providers=" + providers
				+ ", providerUserId=" + providerUserId + "]";
	}
	
	
	 
	 
}
