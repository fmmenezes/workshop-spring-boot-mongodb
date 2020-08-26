package com.mm.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mm.workshopmongo.domain.User;
import com.mm.workshopmongo.dto.UserDTO;
import com.mm.workshopmongo.repository.UserRepository;
import com.mm.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {

		return repo.findAll();

	}

	public User findById(String id) {
		Optional<User> user = repo.findById(id);

		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));

	}
	
	public User insert(User usuario) {
		
		return repo.insert(usuario);
		
	}
	
	public void delete(String id) {
		
		findById(id);
		repo.deleteById(id);
		
	}
	
	public User fromDTO(UserDTO usuarioDto) {
		
		return new User(usuarioDto.getId(), usuarioDto.getName(), usuarioDto.getEmail());
		
	}

}
