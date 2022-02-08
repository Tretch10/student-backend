package com.idenu.master.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idenu.master.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
