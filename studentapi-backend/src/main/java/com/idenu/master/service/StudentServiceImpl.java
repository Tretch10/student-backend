package com.idenu.master.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.idenu.master.entity.Student;
import com.idenu.master.exception.ResourceNotFoundException;
import com.idenu.master.repository.StudentRepository;


@Service
public class StudentServiceImpl implements StudentService {
	private StudentRepository studentRepository;

	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student getStudentById(long id) {
		return studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student","Id",id));
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student updateStudent(Student student, long id) {
		//Check to see if student exists in database
		Student existingStudent = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student","Id", id));
		
		//update student
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		existingStudent.setRegNo(student.getRegNo());
		existingStudent.setMajor(student.getMajor());
		
		return existingStudent;
	}

	@Override
	public void deleteStudent(long id) {
		studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student","Id",id));
		 studentRepository.deleteById(id);
	}
	
	

}
