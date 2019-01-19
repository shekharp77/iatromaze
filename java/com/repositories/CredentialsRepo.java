package com.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.classes.Credentials;
@Repository
public interface CredentialsRepo extends MongoRepository<Credentials, String>{
	public List<Credentials> findByUsername(String username);
	@SuppressWarnings("unchecked")
	public Credentials save(Credentials credentials);
	public List<Credentials> findByEmail(String email);
}
