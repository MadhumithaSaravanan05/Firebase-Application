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

import com.example.homeservice.entity.Professionals;
import com.example.homeservice.service.ProfessionalService;
import com.google.cloud.firestore.QueryDocumentSnapshot;

@RestController
public class ProfessionalController {
 
	public ProfessionalService professionalService;
	
	public ProfessionalController(ProfessionalService professionalService) {
		this.professionalService=professionalService;
	}
	
	@PostMapping("/createProf")
	public String createProfessional(@RequestBody Professionals professional) throws InterruptedException, ExecutionException{
		return professionalService.createProfessional(professional);
	}
	@GetMapping("/getProf")
	public Professionals getProfessionals(@RequestParam String emailId) throws InterruptedException, ExecutionException{
		return professionalService.getProfessional(emailId);
	}
	@PutMapping("/updateProf")
	public String updateProfessional(@RequestBody Professionals professional) throws InterruptedException, ExecutionException{
		return professionalService.updateProfessional(professional);
	}
	@PutMapping("/deleteProf")
	public String deleteProfessional(@RequestParam String emailId) throws InterruptedException, ExecutionException{
		return professionalService.deleteProfessional(emailId);
	}
	@GetMapping("/testProf")
	public ResponseEntity<String> testGetEndPoint(){
		return ResponseEntity.ok("Test Get Endpoint Is Working");
	}
	
	@GetMapping("/getAllProf")
	public List<Professionals> getAllProfessionals() throws Exception {
		return professionalService.getAllProfessionals();
		
	}
	
	
}
