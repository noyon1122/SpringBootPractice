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

import com.example.demo.entities.Employee;
import com.example.demo.services.EmployeeServices;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeServices employeeServices;
	
	@PostMapping("/employees")
	public ResponseEntity<String> saveEmployee(@RequestPart Employee employee, @RequestParam(value="image",required = true) MultipartFile imageFile) throws IOException
	{
		employeeServices.saveEmployee(employee, imageFile);
		
		return new ResponseEntity<String>("Employee saved Successfully!!",HttpStatus.CREATED);
	
	}
}
