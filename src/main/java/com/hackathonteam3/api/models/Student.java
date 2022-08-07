package com.hackathonteam3.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="students")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String name;
	private String lastname;
	private String tuition;
	private String country;
	private String address;
	
	@JoinColumn(name="user_id", unique=true)
	@OneToOne(fetch = FetchType.LAZY)
	private User user;
	
	public Student(){
		
	}
	
	public Student(String name, String lastname, String tuition, String country, String address,
			User user) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.tuition = tuition;
		this.country = country;
		this.address = address;
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
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getTuition() {
		return tuition;
	}
	public void setTuition(String tuition) {
		this.tuition = tuition;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
		
}
