package com.example.homeservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.example.homeservice.entity.User;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class UserService {

	public String createUser(User user) throws InterruptedException, ExecutionException {
		
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection( "users").document(user.getEmailId()).set(user);
		return collectionsApiFuture.get().getUpdateTime().toString();
		
	}
	
	public User getUser(String emailId) throws ExecutionException, InterruptedException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		DocumentReference documentReference = dbFirestore.collection("users").document(emailId);
		ApiFuture<DocumentSnapshot> future = documentReference.get();
		DocumentSnapshot document = future.get();
		User user;
		if(document.exists()) {
			user=document.toObject(User.class);
			return user;
		}
		return null;
	}
	
	public String updateUser(User user) throws InterruptedException, ExecutionException {
		Firestore dbFirestore=FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("users").document(user.getEmailId()).set(user);
		return "Updated Successfully";
	}
	
	public String deleteUser(String emailId) {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> writeResult = dbFirestore.collection("users").document(emailId).delete();
		return "Successfully deleted "+emailId;
		
		
		
	}

	public List<User> getAllUsers() throws InterruptedException, ExecutionException{
		Firestore dbFirestore = FirestoreClient.getFirestore();
		List<User> users = new ArrayList<User>();
		CollectionReference user = dbFirestore.collection("users");
		ApiFuture<QuerySnapshot> querySnapshot = user.get();
		for(DocumentSnapshot doc:querySnapshot.get().getDocuments()) {
			User user1 = doc.toObject(User.class);
			users.add(user1);
		}
		return users;
	}
	
	
}
