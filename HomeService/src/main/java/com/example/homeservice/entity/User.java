package com.example.homeservice.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class User {

	private String userName;
	private String mobileNumber;
	private String emailId;
	private String password;
	
	private List<Appoinments> appoinments;
	
	
}
