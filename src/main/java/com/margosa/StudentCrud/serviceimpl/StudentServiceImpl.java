package com.margosa.StudentCrud.serviceimpl;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.margosa.StudentCrud.Entity.Student;
import com.margosa.StudentCrud.dto.StudentDto;
import com.margosa.StudentCrud.mappers.StudentMapper;
import com.margosa.StudentCrud.repository.StudentRepository;
import com.margosa.StudentCrud.service.StudentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private StudentMapper studentMapper;

	// getting all list of student
	@Override
	public List<StudentDto> getAllStudents() {

		List<Student> student = studentRepository.findAll();
		return studentMapper.update(null, student);
	}

	@Override
	public StudentDto getStudentById(Integer studentId) {
		// TODO Auto-generated method stub
		return studentMapper.map(verifyStudentExists(studentId));
	}

	@Override
	public boolean delete(Integer studentId) {
		verifyStudentExists(studentId);
	 	studentRepository.deleteById(studentId);
		return true;
	}

	@Override
	public StudentDto update( Integer studentId,StudentDto studentDto) {
		// TODO Auto-generated method stub
		
		Student students=verifyStudentExists(studentId);
		if(students.equals(null)) {
			return null;
		}
		Student student = studentMapper.update(students,studentDto);
		student = studentRepository.save(student);

		return studentMapper.map(student);

	}

	// create new students

	@Override
	public StudentDto createStudents(StudentDto studentDto) {
		Student student = studentMapper.map(studentDto);
		student = studentRepository.save(student);

		return studentMapper.map(student);

	}

	// validatiing the student existance
	@Override
	public Student verifyStudentExists(Integer studentId) {
		log.info("student fetch with id{}", studentId);
		Optional<Student> studentContainer = studentRepository.findById(studentId);
		if (!studentContainer.isPresent()) {
			log.warn("studnet ,error while fetch student with id{}", studentId);

		}
		return studentContainer.get();
	}

}
