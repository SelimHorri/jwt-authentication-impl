package com.selimhorri.pack.service.impl;

import java.util.Date;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.selimhorri.pack.service.JwtService;
import com.selimhorri.pack.util.JwtUtil;

import io.jsonwebtoken.Claims;

@Service
public class JwtServiceImpl implements JwtService {
	
	private final JwtUtil jwtUtil;
	
	@Autowired
	public JwtServiceImpl(final JwtUtil jwtUtil) {
		this.jwtUtil = jwtUtil;
	}
	
	@Override
	public String extractUsername(final String token) {
		return this.jwtUtil.extractUsername(token);
	}
	
	@Override
	public Date extractExpiration(final String token) {
		return this.jwtUtil.extractExpiration(token);
	}
	
	@Override
	public <T> T extractClaims(final String token, final Function<Claims, T> claimsResolver) {
		return this.jwtUtil.extractClaims(token, claimsResolver);
	}
	
	@Override
	public String generateToken(final UserDetails userDetails) {
		return this.jwtUtil.generateToken(userDetails);
	}
	
	@Override
	public Boolean validateToken(final String token, final UserDetails userDetails) {
		return this.jwtUtil.validateToken(token, userDetails);
	}
	
	
	
}







