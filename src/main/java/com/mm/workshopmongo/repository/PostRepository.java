package com.mm.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.mm.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {
	
	List<Post> findByTitleContaining(String text);
	
	@Query("{'title': { $regex: ?0, $options: 'i'}}")
	List<Post> findByTitleCaseI(String text);

}
