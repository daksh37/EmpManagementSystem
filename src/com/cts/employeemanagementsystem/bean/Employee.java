
package com.cts.employeemanagementsystem.bean;

public class Employee {
	private String empId;
	private String fname;
	private String lname;
	private float salary;
	private static Employee employee;
	public static Employee getInstance() {
		if(employee == null ){
			employee = new Employee();
			return employee;
		}
		else 
			return employee;
	}
	
	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public Employee(String empId, String fname, String lname, float salary) {
		super();
		this.empId = empId;
		this.fname = fname;
		this.lname = lname;
		this.salary = salary;
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}
	  
}
