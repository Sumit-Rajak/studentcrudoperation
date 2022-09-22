package com.margosa.StudentCrud.mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.hibernate.sql.Update;
import org.springframework.stereotype.Component;

import com.margosa.StudentCrud.Entity.Student;
import com.margosa.StudentCrud.dto.StudentDto;

import lombok.RequiredArgsConstructor;

@Component

public class StudentMapper {

	
	/**    map student  entity  to student DTO   **/
	public StudentDto map(Student student) {
		return update(null, student);

	}

	public StudentDto update(StudentDto studentDto, Student student) {

		if (Objects.isNull(studentDto)) {

			studentDto = new StudentDto();
		}

		if (Objects.nonNull(student)) {
			//studentDto.setId(student.getId());
			studentDto.setStudentId(student.getStudentId());
			studentDto.setStudentName(student.getStudentName());
			studentDto.setStudentEmail(student.getStudentEmail());
			studentDto.setAddress(student.getAddress());
		}

		return studentDto; 
	}

	/**    map student DTo to student entity    **/
	
	public Student map(StudentDto studentDto) {
		return update(null, studentDto);
	}

	public Student update(Student student, StudentDto studentDto) {

		if (Objects.isNull(student)) {
			student = new Student();
		}
		if (Objects.nonNull(studentDto)) {
			student.setStudentId(studentDto.getStudentId());
			student.setStudentName(studentDto.getStudentName());
			student.setStudentEmail(studentDto.getStudentEmail());
			student.setAddress(studentDto.getAddress());
		}

		return student;
	}
	
	

	public List<StudentDto> update(List<StudentDto> studentDtoList, List<Student> studentlist) {
		if (Objects.isNull(studentDtoList)) {
			studentDtoList = new ArrayList<>();
		}
		if (Objects.nonNull(studentlist)) {
			for (Student student : studentlist) {
				studentDtoList.add(update(null, student));
			}
		}
		return studentDtoList;
	}

	
	public List<StudentDto> map(List<Student> student) {
		return update(null, student);

	}
}
