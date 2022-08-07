package com.hackathonteam3.api.request;

public class StudentRequest {
	
	private String name;
	private String lastname;
	private String tuition;
	private String country;
	private String address;
	private Long user_id;
	public StudentRequest() {
	}
	public StudentRequest(String name, String lastname, String tuition, String country, String address, Long user_id) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.tuition = tuition;
		this.country = country;
		this.address = address;
		this.user_id = user_id;
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
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}	

}
