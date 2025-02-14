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

import com.example.demo.entities.User;
import com.example.demo.repository.UserRepo;

@Service
public class UserServices {

	@Autowired
	UserRepo userRepo;
	
	@Value("src/main/resources/static/images")
	private String uploadDir;
	
	public void saveUser(User user,MultipartFile imagefile) throws IOException
	{
		if(imagefile !=null && !imagefile.isEmpty())
		{
			String imageFileName=saveImage(user,imagefile);
			user.setImage(imageFileName);
		}
		
		userRepo.save(user);
	}
	
	
	private String saveImage(User u,MultipartFile file) throws IOException
	{
		Path uploadPath=Paths.get(uploadDir+"/users");
		
		if(!Files.exists(uploadPath))
		{
			Files.createDirectories(uploadPath);
		}
		
		String fileName=u.getName()+"_"+UUID.randomUUID().toString();
		
		Path filePath=uploadPath.resolve(fileName);
		
		Files.copy(file.getInputStream(),filePath);
		
		return fileName;
	}
}
