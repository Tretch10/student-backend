package com.idenu.master.service;

import java.util.List;

import com.idenu.master.entity.Student;

/* get all students
 * get student by ID
 * save student
 * update student (by ID) 
 * delete student (by ID)
 */
public interface StudentService {
	List<Student> getAllStudents();
	Student getStudentById(long id);
	Student saveStudent(Student student);
	Student updateStudent(Student student, long id);
	void deleteStudent(long id);
		
	

}
