package com.ust.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.model.Student;
import com.ust.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository repo;

	@Override
	public Student addStudent(Student student) {

		repo.save(student);

		return student;
	}

	@Override
	public boolean updateStudent(Student student) {
		Student value = repo.getByStudentId(student.getStudentId());
		if (value != null) {
			value.setStudentName(student.getStudentName());
			value.setDepartment(student.getDepartment());
			value.setAge(student.getAge());
			repo.save(value);
			return true;
		}
		return false;

	}

	@Override
	public List<Student> getAllStudent() {
		return repo.findAll();
	}

	@Override
	public boolean deleteStudent(int id) {
		try {
			String str = String.valueOf(id);
			repo.deleteById(str);
			return true;
		} 
		catch (Exception e) {
			return false;
		}
	}

}
