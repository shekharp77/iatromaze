package com.classes;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Careers {
	String type, designation, startDate, endDate, description, username, name;
	@Id
	String id;

	public Careers(String type, String designation, String startDate, String endDate, String description,
			String username, String name) {
		super();
		this.type = type;
		this.designation = designation;
		this.startDate = startDate;
		this.endDate = endDate;
		this.description = description;
		this.username = username;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
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
		return "Careers [type=" + type + ", designation=" + designation + ", startDate=" + startDate + ", endDate="
				+ endDate + ", description=" + description + ", username=" + username + ", name=" + name + "]";
	}


	
	
}
