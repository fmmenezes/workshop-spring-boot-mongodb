package com.mm.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mm.workshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll() {

		User fernando = new User("1", "Fernando Mendes", "fernando@mm.com.br");
		User branca = new User("2", "Branca Mendes", "branca@mm.com.br");
		List<User> lista = new ArrayList<>();
		lista.addAll(Arrays.asList(fernando, branca));

		return ResponseEntity.ok().body(lista);

	}

}
