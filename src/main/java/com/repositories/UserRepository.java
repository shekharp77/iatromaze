package com.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.classes.User;

public interface UserRepository extends MongoRepository<User, String> {
	 public User findByFirstName(String firstName);
	 public User findByUsername(String username);
	public void deleteByUsername(String username);
}
