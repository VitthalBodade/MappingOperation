package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Employee {
	
	@Id
	private int emp_id;
	private String e_name;
	
	@ManyToOne
	@JoinColumn(name = "emp_dept_id")
	private Department dept;

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getE_name() {
		return e_name;
	}

	public void setE_name(String e_name) {
		this.e_name = e_name;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public Employee()  {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int emp_id, String e_name, Department dept) {
		super();
		this.emp_id = emp_id;
		this.e_name = e_name;
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", e_name=" + e_name + ", dept=" + dept + "]";
	}
	
	
	

}
