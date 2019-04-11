package ru.spb.pes.www.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.spb.pes.www.dao.UserDAO;
import ru.spb.pes.www.entity.User;

@RestController
@RequestMapping("/api")
public class MainRestController {

	@Autowired
	UserDAO dao;

	@GetMapping(value = "/get/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public User getUser(@PathVariable(value = "id") int id) throws Exception {
		return dao.getUser(id);
	}

	@PatchMapping(value = "/patch{id}", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public User patchUser(@PathVariable(value = "id") int id, @Valid @RequestBody User user) throws Exception {
		if (id == user.getId()) {
			return dao.patchUser(user);
		} else {
			throw new Exception();
		}
	}

	@PostMapping(value = "/post", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public void addUser(@Valid @RequestBody User user) {
		if (user != null) {
			dao.addUser(user);
		}
	}

}
