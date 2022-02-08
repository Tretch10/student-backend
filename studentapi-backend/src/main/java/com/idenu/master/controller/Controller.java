package com.idenu.master.controller;

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

import com.idenu.master.entity.Student;
import com.idenu.master.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class Controller {
	private StudentService studentService;

	public Controller(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	//REST API end point to get all students
	@GetMapping()
	public List<Student> getAllStudents(){
		return studentService.getAllStudents();
	}
	
	//REST API end point to get student by ID
	@GetMapping("{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") long id){
		return new ResponseEntity<Student>(studentService.getStudentById(id), HttpStatus.OK);
		
	}
	
	// REST API end point to create student
	@PostMapping()
	public ResponseEntity<Student> saveStudent(@RequestBody Student student){
		return new ResponseEntity<Student>(studentService.saveStudent(student), HttpStatus.CREATED);
	}
	
	// REST API end point to update student
	@PutMapping("{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable("id") long id, @RequestBody Student student){
		return new ResponseEntity<Student>(studentService.updateStudent(student, id), HttpStatus.OK);
		
	}
	
	// REST API end point to delete student by ID
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") long id){
		
		studentService.deleteStudent(id);
		
		return new ResponseEntity<String>("Student has been successfully deleted!", HttpStatus.OK);
	}
	
	
	
	

}
