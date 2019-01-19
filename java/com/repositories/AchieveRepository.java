package com.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.classes.Achievments;
@Repository
public interface AchieveRepository extends MongoRepository<Achievments, String> {
	public List<Achievments> findByUsername(String username);
	public void deleteById(String id);
}
