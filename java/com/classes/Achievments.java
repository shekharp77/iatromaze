package com.classes;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Achievments {
	String type, name, provider, date, description, username;
	@Id
	String id;
	public Achievments(String type, String name, String provider, String date, String description, String username) {
		this.type = type;
		this.name = name;
		this.provider = provider;
		this.date = date;
		this.description = description;
		this.username = username;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Achievments [type=" + type + ", name=" + name + ", provider=" + provider + ", date=" + date
				+ ", description=" + description + ", username=" + username + "]";
	}
	
	
}
