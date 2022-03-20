package com.restapidemo.ui.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restapidemo.ui.model.request.UserDetailsRequestModel;
import com.restapidemo.ui.model.response.UserRest;

@RestController
@RequestMapping("users")
public class UserController {
	
	@GetMapping()
	public String getUsers(@RequestParam(value="page", defaultValue="1") int page,
			@RequestParam(value="limit", defaultValue="50") int limit,
			@RequestParam(value="sort", defaultValue="desc", required= false) String sort) {
		return "get users from page "+ page+ " with a limit "+ limit + " sort = "+sort;
	}

	@GetMapping(path="/{userId}", produces= {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
		UserRest returnValue = new UserRest();
		returnValue.setEmail("mallepallyakhil@gmail.com");
		returnValue.setFirstName("Akhil");
		returnValue.setLastName("Mallepally");
		
		return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);	
	}
	
	@PostMapping(consumes= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			produces= {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	
	public ResponseEntity<UserDetailsRequestModel> createUser(@RequestBody UserDetailsRequestModel userDetails) {
		UserDetailsRequestModel returnValue = new UserDetailsRequestModel();
		returnValue.setEmail(userDetails.getEmail());
		returnValue.setFirstName(userDetails.getFirstName());
		returnValue.setLastName(userDetails.getLastName());
		returnValue.setPassword(userDetails.getPassword());
		
		return new ResponseEntity<UserDetailsRequestModel>(returnValue, HttpStatus.OK);
	}
	
	@PutMapping
	public String updateUser() {
		return "update user";
	}
	
	@DeleteMapping
	public String deleteUser() {
		return "delete user";
	}
	

}
