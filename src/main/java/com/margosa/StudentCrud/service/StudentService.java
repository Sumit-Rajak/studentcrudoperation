package com.margosa.StudentCrud.service;

import java.util.List;

import com.margosa.StudentCrud.Entity.Student;
import com.margosa.StudentCrud.ExceptionHandler.UserNotFoundException;
import com.margosa.StudentCrud.dto.StudentDto;

public interface StudentService {
	
	
	 List<StudentDto> getAllStudents();
	 StudentDto getStudentById(Integer studentId);
	 StudentDto createStudents(StudentDto studentDto);
	  boolean delete(Integer studentId)  ;
	  StudentDto update(Integer studentId,StudentDto studentDto) ;
	 

}
