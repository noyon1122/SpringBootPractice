package com.example.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entities.User;
import com.example.demo.services.UserServices;

@RestController
public class MyController {


	@Autowired
	private UserServices userServices;
	
	@PostMapping("/users")
	public ResponseEntity<String> saveUser(@RequestPart User u, @RequestParam (value = "image",required = true) MultipartFile file) throws IOException
	{
		userServices.saveUser(u, file);
		return new ResponseEntity<>("User saved successfully!! ",HttpStatus.CREATED);
	}
	
}
