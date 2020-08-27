package com.mm.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.mm.workshopmongo.domain.Post;
import com.mm.workshopmongo.domain.User;
import com.mm.workshopmongo.dto.AuthorDTO;
import com.mm.workshopmongo.repository.PostRepository;
import com.mm.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User fernando = new User(null, "Fernando Mendes", "fernando@mm.com.br");
		User branca = new User(null, "Branca Mendes", "branca@mm.com.br");
		User harry = new User(null, "Harry Mendes", "harry@mm.com.br");
		
		userRepository.saveAll(Arrays.asList(fernando, branca, harry));
		
		Post post1 = new Post(null,sdf.parse("27/08/2020"),"Partiu Viagem","Vou viajar para Africa!", new AuthorDTO(fernando));
		Post post2 = new Post(null,sdf.parse("27/08/2020"),"Bom dia!","Comi um Biscoito! Hummm", new AuthorDTO(branca));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
	}

}
