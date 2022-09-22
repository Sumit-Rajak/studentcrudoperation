package com.margosa.StudentCrud.serviceimpl;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.margosa.StudentCrud.Entity.Student;
import com.margosa.StudentCrud.ExceptionHandler.UserFoundException;
import com.margosa.StudentCrud.ExceptionHandler.UserNotFoundException;
import com.margosa.StudentCrud.dto.StudentDto;
import com.margosa.StudentCrud.mappers.StudentMapper;
import com.margosa.StudentCrud.repository.StudentRepository;
import com.margosa.StudentCrud.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private StudentMapper studentMapper;

	@Autowired
	private UserNotFoundException userNotFoundException;

	// getting all list of student
	@Override
	public List<StudentDto> getAllStudents() {

		List<Student> student = studentRepository.findAll();
		return studentMapper.map(student);
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
	public StudentDto update(Integer studentId, StudentDto studentDto) {
		// TODO Auto-generated method stub

		Student students = verifyStudentExists(studentId);
		Student student = studentMapper.update(students, studentDto);
		student = studentRepository.save(student);

		return studentMapper.map(student);

	}

	// create new students

	@Override
	public StudentDto createStudents(StudentDto studentDto) {
		Student students=new Student();
		Student local = this.studentRepository.findByStudentId(students.getStudentId());
		if (Objects.nonNull(local)) {
			log.error("student is allready present with this id  {}",studentDto.getStudentId());
			throw new UserFoundException();
		}
		Student student = studentMapper.map(studentDto);
		student = studentRepository.save(student);

		return studentMapper.map(student);

	}

	// validatiing the student existance

	private Student verifyStudentExists(Integer studentId) {
		log.info("student fetching  with id{}", studentId);
		Optional<Student> studentContainer = studentRepository.findById(studentId);
		if (!studentContainer.isPresent()) {
			log.warn("studnet ,error while fetch student with id{}", studentId);
			throw new UserNotFoundException();
		}
		return studentContainer.get();
	}

}
