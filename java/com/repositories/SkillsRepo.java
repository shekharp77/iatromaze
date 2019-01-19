package com.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.classes.Skills;
@Repository
public interface SkillsRepo extends MongoRepository<Skills, String> {
	public List<Skills> findByUsername(String username);
	public void deleteById(String id);
}
