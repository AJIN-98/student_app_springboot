package com.ust.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ust.model.Student;
import com.ust.service.StudentService;

@RestController
public class StudentController {

	
	@Autowired
	StudentService service;
	
	@PostMapping("student/add")
	public ResponseEntity<?> addStudent(@RequestBody Student student) {
		Student flag = service.addStudent(student);
		if(flag!=null) {
			return new ResponseEntity<String>("User Created",HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<String>("Failure",HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("student/update")
	public ResponseEntity<?> Updatestudent(@RequestBody Student student) {
		boolean flag = service.updateStudent(student);
		if(flag) {
			return new ResponseEntity<String>("User Updated",HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<String>("Failed to update",HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("student/all")
	public ResponseEntity<?> getall() {
		List<Student> flag = service.getAllStudent();
		if(!flag.isEmpty()) {
			return new ResponseEntity<List<Student>>(flag,HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<String>("list is empty",HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("student/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		boolean flag = service.deleteStudent(id);
		if(flag) {
			return new ResponseEntity<String>("deleted!",HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<String>("not found",HttpStatus.BAD_REQUEST);
		}
	}
		
}
