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

import com.example.homeservice.entity.Appoinments;
import com.example.homeservice.entity.User;
import com.example.homeservice.service.AppoinmentService;
import com.example.homeservice.service.UserService;
import com.google.cloud.firestore.QueryDocumentSnapshot;

@RestController
public class AppoinmentController {
 
	public AppoinmentService appoinmentService;
	
	
	public AppoinmentController(AppoinmentService appoinmentService) {
		this.appoinmentService=appoinmentService;
	}
	
	
	
	
}
