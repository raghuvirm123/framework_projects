package org.jforce.voteApp.repository;

import org.jforce.voteApp.model.votingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;





@Repository
public interface voterRepo extends CrudRepository<votingDetails, String> {

	 
	 
}
