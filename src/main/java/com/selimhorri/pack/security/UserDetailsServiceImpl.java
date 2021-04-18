package com.selimhorri.pack.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.selimhorri.pack.service.CredentialService;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private final CredentialService credentialService;
	
	@Autowired
	public UserDetailsServiceImpl(CredentialService credentialService) {
		this.credentialService = credentialService;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return new UserDetailsImpl(this.credentialService.findByUsername(username));
	}
	
	
	
}





