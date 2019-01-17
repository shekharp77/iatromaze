package com.classes;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Credentials {
	String username, password,email;
	
	public Credentials(String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Credentials [email=" + username + "]";
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
	
	
}
