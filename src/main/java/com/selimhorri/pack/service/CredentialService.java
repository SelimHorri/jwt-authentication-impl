package com.selimhorri.pack.service;

import java.util.List;

import com.selimhorri.pack.model.entity.Credential;

public interface CredentialService {
	
	List<Credential> findAll();
	Credential findById(final Integer id);
	Credential save(final Credential credential);
	Credential update(final Credential credential);
	void deleteById(final Integer id);
	
}
