package com.mm.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mm.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
