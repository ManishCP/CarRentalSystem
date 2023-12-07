package com.csye6220.carrentalsystem.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

	@Id
    @GeneratedValue
    @Column(name="user_id")
    private Long userID;
	
    private String username;
    
    private String email;
    
    private String password;
    
    @Enumerated(EnumType.STRING)
    private UserRole role;
    
    @Column(name="phone_number")
    private Long phoneNumber;

    public User() {
    }

    public User(String username, String email, String password, UserRole role,  Long phoneNumber) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
		this.phoneNumber = phoneNumber;
	}

	public Long getUserID() {
        return userID;
    }

    public void setUserId(Long userId) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
