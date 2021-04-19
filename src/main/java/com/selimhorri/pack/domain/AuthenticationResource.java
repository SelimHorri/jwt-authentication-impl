package com.selimhorri.pack.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.selimhorri.pack.model.dto.AuthenticationRequest;
import com.selimhorri.pack.model.dto.AuthenticationResponse;
import com.selimhorri.pack.service.JwtService;

@RestController
@RequestMapping(value = {"/app/authenticate"})
public class AuthenticationResource {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JwtService jwtService;
	
	@PostMapping(value = {"", "/"})
	public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody final AuthenticationRequest authenticationRequest) {
		
		try {
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		}
		catch (BadCredentialsException e) {
			throw new BadCredentialsException("******* INCORRECT USERNAME/PASSWORD ********", e);
		}
		
		final UserDetails userDetails = this.userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt = this.jwtService.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
	
	
	
}






