package org.jforce.voteApp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "candidate_3")
public class candidateDetails2 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String candidate3;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCandidate3() {
		return candidate3;
	}

	public void setCandidate3(String candidate3) {
		this.candidate3 = candidate3;
	}

}
