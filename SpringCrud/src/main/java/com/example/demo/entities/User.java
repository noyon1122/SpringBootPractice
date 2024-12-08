package com.example.demo.entities;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;

@Entity
public class User {

	@Id
	private int id;
	private String name;
	private String image;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public User(int id, String name, String image) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
