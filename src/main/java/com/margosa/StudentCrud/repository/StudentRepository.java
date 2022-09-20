package com.margosa.StudentCrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.margosa.StudentCrud.Entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	
	Student findByStudentId(Integer studentId);
}
