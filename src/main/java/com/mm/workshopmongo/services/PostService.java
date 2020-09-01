package com.mm.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mm.workshopmongo.domain.Post;
import com.mm.workshopmongo.repository.PostRepository;
import com.mm.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public Post findById(String id) {

		Optional<Post> usuario = repo.findById(id);

		return usuario.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));

	}
	
	public List<Post> findByTitle(String text){
		
		return repo.findByTitleContaining(text);
	}
	
	

}
