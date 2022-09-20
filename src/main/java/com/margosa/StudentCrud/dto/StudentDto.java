package com.margosa.StudentCrud.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
public class StudentDto {
	
	
	
	private Integer Id;


	
	
	private Integer studentId;

	
	private String StudentName;

	
	private String address;

	
	private String StudentEmail;


}
