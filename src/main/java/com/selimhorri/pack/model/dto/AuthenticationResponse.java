package com.selimhorri.pack.model.dto;

import java.io.Serializable;

public class AuthenticationResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String jwt;
	
	public AuthenticationResponse(final String jwt) {
		this.jwt = jwt;
	}
	
	public String getJwt() {
		return jwt;
	}
	
	
	
}







