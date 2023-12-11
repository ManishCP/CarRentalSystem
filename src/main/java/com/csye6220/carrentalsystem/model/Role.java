package com.csye6220.carrentalsystem.model;

import jakarta.persistence.Column; 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="role_id", nullable = false, updatable = false)
    private Long roleID;
	
	@Column(name = "name", length = 45, nullable = false)
    private String name;

	public Role(Long roleID, String name) {
		super();
		this.roleID = roleID;
		this.name = name;
	}

	public Long getRoleID() {
		return roleID;
	}

	public void setRoleID(Long roleID) {
		this.roleID = roleID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}