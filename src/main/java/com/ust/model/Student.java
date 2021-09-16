package com.ust.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;


@Entity
public class Student {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
	@NotNull
	private String studentName;
	@NotNull
	private String department;
	@NotNull
	private int age;
	
	
	public Student() {
		super();
	}


	public Student(int studentId, String studentName, String department, int age) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.department = department;
		this.age = age;
	}


	public int getStudentId() {
		return studentId;
	}


	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}


	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}

}