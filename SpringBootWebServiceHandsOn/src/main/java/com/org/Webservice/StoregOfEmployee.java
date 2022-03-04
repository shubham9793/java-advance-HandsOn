package com.org.Webservice;

import java.util.ArrayList;
import java.util.List;

public class StoregOfEmployee {
	
	private List<EmployeeCLass> employeeList;
	
 	public List<EmployeeCLass> getEmployeeList() {
 		if(employeeList == null) {
 			employeeList = new ArrayList();
 		} 
 		return employeeList;
 	}

	public void setEmployeeList(List<EmployeeCLass> employeeList) {
		this.employeeList = employeeList;
	}
 	
 	
}
