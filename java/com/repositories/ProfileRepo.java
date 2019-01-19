package com.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.classes.User;
@Repository
public interface ProfileRepo extends MongoRepository<User, String> {
	public List<User> findByUsername(String username);
}
