package com.example.homeservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.example.homeservice.entity.Professionals;
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
public class ProfessionalService {

	public String createProfessional(Professionals professional) throws InterruptedException, ExecutionException {
		
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection( "professional").document(professional.getEmailId()).set(professional);
		return collectionsApiFuture.get().getUpdateTime().toString();
		
	}
	
	public Professionals getProfessional(String emailId) throws ExecutionException, InterruptedException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		DocumentReference documentReference = dbFirestore.collection("professional").document(emailId);
		ApiFuture<DocumentSnapshot> future = documentReference.get();
		DocumentSnapshot document = future.get();
		Professionals professional;
		if(document.exists()) {
			professional=document.toObject(Professionals.class);
			return professional;
		}
		return null;
	}
	
	public String updateProfessional(Professionals professional) throws InterruptedException, ExecutionException {
		Firestore dbFirestore=FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("professional").document(professional.getEmailId()).set(professional);
		return collectionsApiFuture.get().getUpdateTime().toString();
	}
	
	public String deleteProfessional(String emailId) {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> writeResult = dbFirestore.collection("professional").document(emailId).delete();
		return "Successfully deleted "+emailId;
		
		
		
	}
	
//	public List<QueryDocumentSnapshot> getAllProfessionals() throws Exception {
//		Firestore dbFirestore=FirestoreClient.getFirestore();
//		CollectionReference documentReference = dbFirestore.collection("professional");
//	    ApiFuture<QuerySnapshot> future = documentReference.get();
//	    
//	    List<QueryDocumentSnapshot> documents = future.get().getDocuments();
//	    for (QueryDocumentSnapshot document : documents) {
//	      System.out.println(document.getId() + " => " + document.toObject(Professionals.class));
//	    }
//	    return documents;
//	  }
	public List<Professionals> getAllProfessionals() throws InterruptedException, ExecutionException{
		Firestore dbFirestore = FirestoreClient.getFirestore();
		List<Professionals> professionals = new ArrayList<Professionals>();
		CollectionReference professional = dbFirestore.collection("professional");
		ApiFuture<QuerySnapshot> querySnapshot = professional.get();
		for(DocumentSnapshot doc:querySnapshot.get().getDocuments()) {
			Professionals prof = doc.toObject(Professionals.class);
			professionals.add(prof);
		}
		return professionals;
	}
	
	
}
