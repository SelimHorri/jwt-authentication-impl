package com.selimhorri.pack.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.selimhorri.pack.model.entity.Credential;
import com.selimhorri.pack.repo.CredentialRepository;
import com.selimhorri.pack.service.CredentialService;

@Service
@Transactional
public class CredentialServiceImpl implements CredentialService {
	
	private CredentialRepository credentialRepository;
	
	@Autowired
	public CredentialServiceImpl(CredentialRepository credentialRepository) {
		this.credentialRepository = credentialRepository;
	}
	
	@Override
	public List<Credential> findAll() {
		return this.credentialRepository.findAll();
	}
	
	@Override
	public Credential findById(Integer id) {
		return this.credentialRepository.findById(id).orElseThrow(() -> new NoSuchElementException("***** Credential NOT FOUND *******"));
	}
	
	@Override
	public Credential save(Credential credential) {
		return this.credentialRepository.save(credential);
	}
	
	@Override
	public Credential update(Credential credential) {
		return this.credentialRepository.save(credential);
	}
	
	@Override
	public void delete(Integer id) {
		this.credentialRepository.deleteById(id);
	}
	
}




