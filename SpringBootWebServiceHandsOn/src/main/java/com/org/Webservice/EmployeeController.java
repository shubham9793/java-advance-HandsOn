package com.org.Webservice;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@GetMapping(path="/",produces="application/json")
	
	public StoregOfEmployee getEmployees() {
		return employeeDao.getAllEmployee();
	}
	
	@PostMapping(path="/",consumes="application/json",produces="application/json")
	public ResponseEntity<Object> addEmployee(
	        @RequestBody EmployeeCLass employee){
	  
	        Integer id
	            = employeeDao
	                  .getAllEmployee()
	                  .getEmployeeList()
	                  .size()
	              + 1;
	  
	        employee.setId(id);
	  
	        employeeDao
	            .addEmployee(employee);
	  
	        URI location
	            = ServletUriComponentsBuilder
	                  .fromCurrentRequest()
	                  .path("/{id}")
	                  .buildAndExpand(
	                      employee.getId())
	                  .toUri();
	  
	               return ResponseEntity
	            .created(location)
	            .build();
	    }
}
