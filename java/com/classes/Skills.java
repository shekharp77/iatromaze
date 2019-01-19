package com.classes;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Skills {
	String level, name, type, description, username;
	@Id
	String id;
	public Skills(String level, String name, String type, String description, String username) {
		super();
		this.level = level;
		this.name = name;
		this.type = type;
		this.description = description;
		this.username = username;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
		return "Skills [level=" + level + ", name=" + name + ", type=" + type + ", description=" + description
				+ ", username=" + username + "]";
	}
	
}
