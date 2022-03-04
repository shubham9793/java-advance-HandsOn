package com.org.Webservice;

public class EmployeeCLass {
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	public EmployeeCLass() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeCLass(int id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	@Override
	public String toString () {
		return "Employee[id=" +id +",firstName "+firstName+", lastName" +lastName+", Email"+email+"]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
