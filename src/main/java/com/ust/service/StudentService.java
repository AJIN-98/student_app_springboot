package com.ust.service;

import java.util.List;

import com.ust.model.Student;

public interface StudentService {

	public Student addStudent(Student student);

	public boolean updateStudent(Student student);

	public List<Student> getAllStudent();

	public boolean deleteStudent(int id);

}
