package com.mm.workshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mm.workshopmongo.domain.User;
import com.mm.workshopmongo.dto.UserDTO;
import com.mm.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll() {

		/*
		 * User fernando = new User("1", "Fernando Mendes", "fernando@mm.com.br"); User
		 * branca = new User("2", "Branca Mendes", "branca@mm.com.br"); List<User> lista
		 * = new ArrayList<>(); lista.addAll(Arrays.asList(fernando, branca)); return
		 * ResponseEntity.ok().body(lista);
		 */
		List<User> lista = service.findAll();
		List<UserDTO> listaDTO = lista.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listaDTO);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {

		User usuario = service.findById(id);

		return ResponseEntity.ok().body(new UserDTO(usuario));
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody UserDTO usuarioDto) {

		User usuario = service.fromDTO(usuarioDto);
		usuario = service.insert(usuario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId())
				.toUri();
		return ResponseEntity.created(uri).build();

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id) {

		service.delete(id);

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody UserDTO usuarioDto, @PathVariable String id) {

		User usuario = service.fromDTO(usuarioDto);
		usuario.setId(id);

		usuario = service.update(usuario);

		return ResponseEntity.noContent().build();

	}

}
