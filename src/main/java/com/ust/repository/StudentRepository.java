package com.ust.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ust.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
	Student getByStudentId(int studentId);
}
