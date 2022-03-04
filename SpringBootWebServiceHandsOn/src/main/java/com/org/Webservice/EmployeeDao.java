package com.org.Webservice;

import org.springframework.stereotype.Repository;


@Repository
public class EmployeeDao {
	
	private static StoregOfEmployee list = new StoregOfEmployee();
	 static {
		 list.getEmployeeList().add( new EmployeeCLass(1,"Shubham","Sahoo","Shubham@genpact.com"));
		 list.getEmployeeList().add(new EmployeeCLass(2,"Niharika", "shukla","niharika@genpact.com"));
		 list.getEmployeeList().add(new EmployeeCLass(3,"himansi","singh","himansi@genpact.com"));
		 
		 
	 }
	 public StoregOfEmployee getAllEmployee()  {
		 return list;
	 }
	 
	 public void addEmployee(EmployeeCLass emp) {
		 list.getEmployeeList().add(emp);
	 }
	 	
	
}
