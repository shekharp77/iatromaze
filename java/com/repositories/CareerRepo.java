package com.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.classes.Careers;
@Repository
public interface CareerRepo extends MongoRepository<Careers, String>{
	public List<Careers> findByUsername(String username);
	public void deleteById(String id);
	public Careers save(Careers careers);
}
