package com.selimhorri.pack.domain;

import java.util.List;

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

import com.selimhorri.pack.model.entity.Employee;
import com.selimhorri.pack.service.EmployeeService;

@RestController
@RequestMapping("/app/api/employees")
public class EmployeeResource {
	
	private final EmployeeService employeeService;
	
	@Autowired
	public EmployeeResource(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping(value = {"", "/"})
	public ResponseEntity<List<Employee>> findAll() {
		return ResponseEntity.ok(this.employeeService.findAll());
	}
	
	@GetMapping(value = {"/{id}"})
	public ResponseEntity<Employee> findById(@PathVariable("id") final String id) {
		return ResponseEntity.ok(this.employeeService.findById(Integer.parseInt(id)));
	}
	
	@PostMapping(value = {"", "/"})
	public ResponseEntity<Employee> save(@RequestBody final Employee employee) {
		return ResponseEntity.ok(this.employeeService.save(employee));
	}
	
	@PutMapping(value = {"", "/"})
	public ResponseEntity<Employee> update(@RequestBody final Employee employee) {
		return ResponseEntity.ok(this.employeeService.save(employee));
	}
	
	@DeleteMapping(value = {"/{id}"})
	public ResponseEntity<?> deleteById(@PathVariable("id") final String id) {
		this.employeeService.deleteById(Integer.parseInt(id));
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
}





