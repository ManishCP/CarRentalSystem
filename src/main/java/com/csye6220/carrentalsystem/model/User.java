package com.csye6220.carrentalsystem.model;

import java.util.HashSet; 
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id", nullable = false)
    private Long userID;
	
	@Column(name = "username", length = 45, nullable = false)
    private String username;
    
	@Column(name = "email", length = 45)
    private String email;
    
	@Column(name = "password", length = 64)
    private String password;
    
    @Column(name="phone_number")
    private Long phoneNumber;
    
    @Column(name = "enabled")
    private Boolean enabled;
 
    public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(
	    name = "users_roles",
	    joinColumns = @JoinColumn(name = "user_id"),
	    inverseJoinColumns = @JoinColumn(name = "role_id")
	)
	private Set<Role> roles = new HashSet<>();

    public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public User() {
    }
    
    public User(String username, String email, String password, Long phoneNumber) {
    	this.username = username;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
	}
    
	public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
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
