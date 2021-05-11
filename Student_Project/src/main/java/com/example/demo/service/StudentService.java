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
	
	public Student create(Student student) {
		return studentDao.save(student);
	}
	
	public Iterable<Student> findAllStudent() {
		return studentDao.findAll();
	}
	
	public Optional<Student> findByStudentId(Integer id) {
		return studentDao.findById(id);
	}
	
	public void delete(Integer id) {
		studentDao.deleteById(id);
	}
	
	public Student updateStudentEmail(Integer id,String email) {
		Student student = studentDao.findById(id).orElse(new Student());
		student.setEmail(email);
		return studentDao.save(student);
	}
	
	public Student updatedepartment(Integer id,String department) {
		Student student = studentDao.findById(id).orElse(new Student());
		student.setDepartment(department);
		return studentDao.save(student);
	}
}
