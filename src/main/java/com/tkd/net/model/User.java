package com.tkd.net.model;

import java.io.Serializable;


public class User implements Serializable{
	private static final long serialVersionUID = 5992961915130873122L;

	private Long id;
	private String email;
  
	private String name;

	private String city;

	public User() { }

	public User(Long id, String name, String email, String city) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.city = city;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", name=" + name + ", city=" + city + "]";
	}
}