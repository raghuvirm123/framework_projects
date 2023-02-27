package org.jforce.voteApp.repository;

import org.jforce.voteApp.model.userDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends JpaRepository<userDetails, String> {


	
}
