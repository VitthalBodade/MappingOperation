package com.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OrderColumn;

@Entity
public class Student {

	@Id
	private int s_id;
	private String s_name;

	@ManyToMany
	@JoinTable(name = "Student_Course")
	@OrderColumn(name = "Course_order")
	private List<Courses> courses;

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public Student() {

	}

	public Student(int s_id, String s_name) {
		super();
		this.s_id = s_id;
		this.s_name = s_name;
	}

	@Override
	public String toString() {
		return "Student [s_id=" + s_id + ", s_name=" + s_name + "]";
	}

	public List<Courses> getStudent() {
		return courses;

	}

	public void setStudent(List<Courses> students) {
		this.courses = courses;
	}

}
