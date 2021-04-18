package com.selimhorri.pack.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.selimhorri.pack.model.entity.Employee;
import com.selimhorri.pack.repo.EmployeeRepository;
import com.selimhorri.pack.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	@Override
	public List<Employee> findAll() {
		return this.employeeRepository.findAll();
	}
	
	@Override
	public Employee findById(Integer id) {
		return this.employeeRepository.findById(id).orElseThrow(() -> new NoSuchElementException("***** Employee NOT FOUND *******"));
	}
	
	@Override
	public Employee save(Employee employee) {
		return this.employeeRepository.save(employee);
	}
	
	@Override
	public Employee update(Employee employee) {
		return this.employeeRepository.save(employee);
	}
	
	@Override
	public void delete(Integer id) {
		this.employeeRepository.deleteById(id);
	}
	
	
	
}




