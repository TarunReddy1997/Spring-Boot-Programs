package com.example.demo.service;

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
	
	public Iterable<Student> getallStudents() {
		return studentDao.findAll();
	}
	
	public Optional<Student> getStudent(Integer phoneNo) {
		return studentDao.findById(phoneNo);
	}
	
	public void deleteStudent(Integer phoneNo) {
		studentDao.deleteById(phoneNo);
	}
	
	public Student updateStudent(Integer phoneNo,String email) {
		Student student = studentDao.findById(phoneNo).orElse(new Student());
		return studentDao.save(student);
	}
}
