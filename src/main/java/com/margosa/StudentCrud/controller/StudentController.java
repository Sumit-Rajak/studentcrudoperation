package com.margosa.StudentCrud.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.margosa.StudentCrud.Entity.Student;
import com.margosa.StudentCrud.dto.StudentDto;
import com.margosa.StudentCrud.service.StudentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v2")
@RequiredArgsConstructor
@Slf4j
public class StudentController {

	private final StudentService studentService;

	@GetMapping("/getall")
	public ResponseEntity<List<StudentDto>> getAllStudents()
	{
		log.info("studnet record is fetching");
		return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
	}
	
	@GetMapping("/student/{studentId}")
	public ResponseEntity<StudentDto> getStudentById(@PathVariable("studentId") Integer studentId){
		
		return new ResponseEntity<>(studentService.getStudentById(studentId) ,HttpStatus.OK);
	}
	
	
	
	@PostMapping("/createstudent")
	public ResponseEntity<StudentDto> CreateNewStudnet(@RequestBody StudentDto studentDto){
		
		return new ResponseEntity<>(studentService.createStudents(studentDto),HttpStatus.CREATED);
	}
	
	
	
	@DeleteMapping("/deletestudent/{studentId}")
	public ResponseEntity<?> deleteStudent(@PathVariable("studentId") Integer studentId){
		return new ResponseEntity<>(studentService.delete(studentId),HttpStatus.NO_CONTENT);
	}
	
	
	@PutMapping("/update/{studentId}")
	public ResponseEntity<StudentDto> updateStudent(@PathVariable("studentId" ) Integer studentId,   @RequestBody StudentDto studentDto){
		
		return new ResponseEntity<>(studentService.update(studentId, studentDto),HttpStatus.ACCEPTED);
	}
	
	  

	
	
}
