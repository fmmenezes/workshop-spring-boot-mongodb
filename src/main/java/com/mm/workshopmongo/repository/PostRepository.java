package com.mm.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mm.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {

}
