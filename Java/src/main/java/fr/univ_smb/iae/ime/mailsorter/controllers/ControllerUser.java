package fr.univ_smb.iae.ime.mailsorter.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.univ_smb.iae.ime.mailsorter.models.User;
import fr.univ_smb.iae.ime.mailsorter.services.UserService;

@RestController
@RequestMapping("/mailsorter/users")
@CrossOrigin
public class ControllerUser {
	
	@Autowired
	UserService userService;

	@PostMapping("/create")
	public ResponseEntity<?> addPTToBoard(@Validated @RequestBody User user, BindingResult result) {

		if (result.hasErrors()) {
			Map<String, String> errorMap = new HashMap<String, String>();

			for (FieldError error : result.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
		}

		User newUser = userService.saveOrUpdate(user);

		return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public Iterable<User> getAllBuys() {
		return userService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getBuyById(@PathVariable Long id) {
		User user = userService.findById(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteBuy(@PathVariable Long id) {
		userService.delete(id);
		return new ResponseEntity<String>("User supprimé avec succès. Merci au revoir !", HttpStatus.OK);
	}

}
