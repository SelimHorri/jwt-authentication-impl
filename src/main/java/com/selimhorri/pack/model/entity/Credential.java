package com.selimhorri.pack.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "credentials")
public class Credential implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@Column(name = "is_enabled")
	private Boolean isEnabled;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id")
	private Employee employee;
	
	public Credential() {
		
	}
	
	public Credential(String username, String password, Role role, Boolean isEnabled) {
		this.username = username;
		this.password = password;
		this.role = role;
		this.isEnabled = isEnabled;
	}
	
	public Credential(Integer id, String username, String password, Role role, Boolean isEnabled) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.isEnabled = isEnabled;
	}
	
	@Override
	public String toString() {
		return "Credential [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role
				+ ", isEnabled=" + isEnabled + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Boolean getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	
	
	
}

enum Role {
	ROLE_ADMIN,
	ROLE_EMP
}




