package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StudentDao;
import com.example.demo.model.Student;

@Service
public class StudentService {

	@Autowired
	private StudentDao studentDao;
	
	public Student createStudent(Student student) {
		return studentDao.save(student);
	}
	
	public Optional<Student> findById(int id) {
		return studentDao.findById(id);
	}
	
	public List<Student> findAllStudents() {
		return studentDao.findAll();
	}
	
	public String deleteStudentById(int id) {
		studentDao.deleteById(id);
		return "deleted "+id;
	}
}
