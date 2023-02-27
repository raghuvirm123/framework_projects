package org.jforce.voteApp.repository;

import org.jforce.voteApp.model.candidateDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface candidateRepository extends JpaRepository<candidateDetails, Integer>{






}
