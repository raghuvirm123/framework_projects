//package org.jforce.voteApp.service;
//
//import java.util.Optional;
//
//import org.jforce.voteApp.model.candidateDetails;
//import org.jforce.voteApp.repository.candidateRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//
//public class candidateService {
//
//	@Autowired
//    candidateRepository canr;
//	
//	public Optional<candidateDetails> getCandidateDetailsById(String  id) {
//		return canr.findById(id);
//	}
//}