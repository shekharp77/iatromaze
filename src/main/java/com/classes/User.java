package com.classes;

import org.springframework.data.annotation.Id;

//Details of User Document for MongoDB
import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class User {
	@Id
	public String Id;
	public long phoneNo;
	private String firstName, lastName, email, city, state, country, gender, dateOfBirth;
	

	private String username;
	public User(String username, String firstName, String lastName, String email, String city, String state, String country,
			String gender, String dateOfBirth, long phoneNo) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.city = city;
		this.state = state;
		this.country = country;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.phoneNo = phoneNo;
		this.username = username;
	}


	
	
	public User() {}




	@Override
	public String toString() {
		return "{Id:" + Id + ", phoneNo:" + phoneNo + ", firstName:" + firstName + ", lastName:" + lastName
				+ ", email:" + email + ", city:" + city + ", state:" + state + ", country:" + country + ", gender:"
				+ gender + ", dateOfBirth:" + dateOfBirth + ", username:" + username + "}";
	}




	public String getId() {
		return Id;
	}




	public void setId(String id) {
		Id = id;
	}




	public long getPhoneNo() {
		return phoneNo;
	}




	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}




	public String getFirstName() {
		return firstName;
	}




	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}




	public String getLastName() {
		return lastName;
	}




	public void setLastName(String lastName) {
		this.lastName = lastName;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getCity() {
		return city;
	}




	public void setCity(String city) {
		this.city = city;
	}




	public String getState() {
		return state;
	}




	public void setState(String state) {
		this.state = state;
	}




	public String getCountry() {
		return country;
	}




	public void setCountry(String country) {
		this.country = country;
	}




	public String getGender() {
		return gender;
	}




	public void setGender(String gender) {
		this.gender = gender;
	}




	public String getDateOfBirth() {
		return dateOfBirth;
	}




	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}




	public String getUsername() {
		return username;
	}




	public void setUsername(String username) {
		this.username = username;
	}

	
	
}
