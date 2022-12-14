package com.example.homeservice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@SpringBootApplication
public class HomeServiceApplication {

	public static void main(String[] args) throws IOException {
		ClassLoader classLoader=HomeServiceApplication.class.getClassLoader();
		File file = new File(Objects.requireNonNull(classLoader.getResource("serviceAccountKey.json")).getFile());
		FileInputStream serviceAccount= new FileInputStream(file.getAbsolutePath());
				

//		FileInputStream serviceAccount =
//				new FileInputStream("path/to/serviceAccountKey.json");

		FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(serviceAccount))
					.build();

		FirebaseApp.initializeApp(options);

		
		
		
		SpringApplication.run(HomeServiceApplication.class, args);
	}

}
