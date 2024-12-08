package com.example.demo.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entities.Employee;
import com.example.demo.repository.EmployeeRepo;

@Service
public class EmployeeServices {

	@Autowired
	EmployeeRepo employeeRepo;
	
	@Value("src/main/resources/static/images")
	private String uploadDir;
	
	
	
	public void saveEmployee(Employee employee,MultipartFile imageFile) throws IOException
	{
		if(imageFile !=null && !imageFile.isEmpty())
		{
			String imageFileName=saveImage(employee, imageFile);
			employee.setImage(imageFileName);
		}
		
		employeeRepo.save(employee);
	}
	
	
	public String saveImage(Employee employee, MultipartFile file) throws IOException
	
	{
		Path uploadPath =Paths.get(uploadDir+"/employees");
		
		if(!Files.exists(uploadPath))
		{
			Files.createDirectories(uploadPath);
		}
		
		String fileName=employee.getName()+"_"+UUID.randomUUID().toString();
		
		Path filePath=uploadPath.resolve(fileName);
		
		Files.copy(file.getInputStream(),filePath);
		return fileName;
		
	}
}
