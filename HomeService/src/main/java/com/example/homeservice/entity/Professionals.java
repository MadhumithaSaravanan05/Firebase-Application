package com.example.homeservice.entity;



import com.google.cloud.firestore.annotation.DocumentId;

import lombok.Data;

@Data
public class Professionals {


	private String userName;
	private String mobileNumber;
	private String emailId;
	private String address;
	private String profession;
	
}
