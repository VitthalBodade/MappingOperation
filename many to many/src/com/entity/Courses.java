package com.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Courses {

	@Id
	private int c_id;
	private String c_name;

	@ManyToMany(mappedBy = "courses")
	private List<Student> students;

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public Courses() {

	}

	public Courses(int c_id, String c_name) {
		super();
		this.c_id = c_id;
		this.c_name = c_name;
	}

	@Override
	public String toString() {
		return "Courses [c_id=" + c_id + ", c_name=" + c_name + "]";
	}

	public List<Student> getStudent() {
		return students;

	}

	public void setStudent(List<Student> students) {
		this.students = students;
	}

}
