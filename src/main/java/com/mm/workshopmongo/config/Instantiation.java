package com.mm.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.mm.workshopmongo.domain.User;
import com.mm.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	

	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User fernando = new User(null, "Fernando Mendes", "fernando@mm.com.br");
		User branca = new User(null, "Branca Mendes", "branca@mm.com.br");
		User harry = new User(null, "Harry Mendes", "harry@mm.com.br");
		
		userRepository.saveAll(Arrays.asList(fernando, branca, harry));
		
	}

}
