package com.brillio.RegisterAndLogin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brillio.RegisterAndLogin.model.User;
import com.brillio.RegisterAndLogin.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

	Map<String, String> map = new HashMap<>();

	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user) throws ServletException {
		try {
			String jwtToken = userService.getToken(user.getEmail(), user.getPassword());
			map.clear();
			map.put("message", "user successfully logged in");
			map.put("token", jwtToken);
		} catch (Exception e) {
			String exceptionMessage = e.getMessage();
			map.clear();
			map.put("token", null);
			map.put("message", exceptionMessage);
			return new ResponseEntity<>(map, HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	@PostMapping("/register")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User userValue = userService.getUser(user.getEmail());
		if (userValue != null) {
			return new ResponseEntity<User>(HttpStatus.CONFLICT);
		}
		userService.save(user);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getUser/{userEmail}")
	public ResponseEntity<User> getUser(@PathVariable("userEmail") String userEmail) {
		return new ResponseEntity<User>(userService.getUser(userEmail), HttpStatus.OK);
	}
}