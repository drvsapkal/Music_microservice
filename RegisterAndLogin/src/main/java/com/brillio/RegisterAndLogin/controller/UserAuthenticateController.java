package com.brillio.RegisterAndLogin.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1/test")
public class UserAuthenticateController {
	@PostMapping("/validatetoken")
	public ResponseEntity<String> validateToken() {
		System.out.println("inside validatetoken");
		return new ResponseEntity<String>("Token Validated", HttpStatus.OK);
	}

}