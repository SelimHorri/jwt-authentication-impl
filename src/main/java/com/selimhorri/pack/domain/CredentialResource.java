package com.selimhorri.pack.domain;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.selimhorri.pack.model.entity.Credential;
import com.selimhorri.pack.model.entity.Employee;
import com.selimhorri.pack.service.CredentialService;
import com.selimhorri.pack.service.JwtService;

@RestController
@RequestMapping("/app/api/credentials")
public class CredentialResource {
	
	@Autowired
	private JwtService jwtService;
	
	private final CredentialService credentialService;
	
	@Autowired
	public CredentialResource(CredentialService credentialService) {
		this.credentialService = credentialService;
	}
	
	@GetMapping(value = {"", "/"})
	public ResponseEntity<List<Credential>> findAll() {
		return ResponseEntity.ok(this.credentialService.findAll());
	}
	
	@GetMapping(value = {"/{id}"})
	public ResponseEntity<Credential> findById(@PathVariable("id") final String id) {
		return ResponseEntity.ok(this.credentialService.findById(Integer.parseInt(id)));
	}
	
	@PostMapping(value = {"", "/"})
	public ResponseEntity<Credential> save(@RequestBody final Credential credential) {
		return ResponseEntity.ok(this.credentialService.save(credential));
	}
	
	@PutMapping(value = {"", "/"})
	public ResponseEntity<Credential> update(@RequestBody final Credential credential) {
		return ResponseEntity.ok(this.credentialService.save(credential));
	}
	
	@DeleteMapping(value = {"/{id}"})
	public ResponseEntity<?> deleteById(@PathVariable("id") final String id) {
		this.credentialService.deleteById(Integer.parseInt(id));
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(value = {"/authenticated"})
	public ResponseEntity<Credential> findUserByToken(final HttpServletRequest request) {
		final String jwt = request.getHeader("Authorization").substring(7);
		return ResponseEntity.ok(this.credentialService.findByUsername(this.jwtService.extractUsername(jwt)));
	}
	
	
	
}





