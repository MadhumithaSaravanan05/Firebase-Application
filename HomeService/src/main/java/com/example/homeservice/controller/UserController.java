package com.example.homeservice.controller;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.homeservice.entity.User;
import com.example.homeservice.service.UserService;
import com.google.cloud.firestore.QueryDocumentSnapshot;

@RestController
public class UserController {
 
	public UserService userService;
	
	public UserController(UserService userService) {
		this.userService=userService;
	}
	
	@PostMapping("/createUser")
	public String createUser(@RequestBody User user) throws InterruptedException, ExecutionException{
		return userService.createUser(user);
	}
	@GetMapping("/getUser")
	public User getUser(@RequestParam String emailId) throws InterruptedException, ExecutionException{
		return userService.getUser(emailId);
	}
	@PutMapping("/updateUser")
	public String updateUser(@RequestBody User user) throws InterruptedException, ExecutionException{
		return userService.updateUser(user);
	}
	@PutMapping("/deleteUser")
	public String deleteUser(@RequestParam String emailId) throws InterruptedException, ExecutionException{
		return userService.deleteUser(emailId);
	}
	@GetMapping("/testUser")
	public ResponseEntity<String> testGetEndPoint(){
		return ResponseEntity.ok("Test Get Endpoint Is Working");
	}
	
	@GetMapping("/getAllUser")
	public List<User> getAllUsers() throws Exception {
		return userService.getAllUsers();
		
	}
	
	
}
