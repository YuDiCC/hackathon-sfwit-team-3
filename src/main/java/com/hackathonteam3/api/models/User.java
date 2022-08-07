package com.hackathonteam3.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column
	private String email;
	private String password;
	private Boolean status;
	private Boolean is_student;
	


	public User() {
		super();
	}

	public User(Long id, String email, String password, Boolean status, Boolean is_student) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.status = status;
		this.is_student = is_student;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public Boolean getIs_student() {
		return is_student;
	}
	public void setIs_student(Boolean is_student) {
		this.is_student = is_student;
	}
}

	
