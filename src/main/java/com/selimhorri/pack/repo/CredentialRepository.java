package com.selimhorri.pack.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.selimhorri.pack.model.entity.Credential;

@Repository
public interface CredentialRepository extends JpaRepository<Credential, Integer> {
	
	
	
}
