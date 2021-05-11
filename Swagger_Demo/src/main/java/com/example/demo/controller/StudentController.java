package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Swagger-Student-Controller")
@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	private StudentService service;
	
	@ApiOperation(value = "Create Student Information")
	@PostMapping("/create")
	public Student createStudent(@RequestBody Student student) {
		return service.createStudent(student);
	}
	
	@GetMapping("/findStudent/{id}")
	@ApiOperation("GetStudent Details Based on Id")
	public Optional<Student> getStudentById(@PathVariable("id") int id) {
		return service.findById(id);
	}
	
	@GetMapping("/getAllStudents")
	@ApiOperation("Get All Students Present in The List")
	public List<Student> getAllStudents() {
		return service.findAllStudents();
	}
	
	@DeleteMapping("/deleteById/{id}")
	@ApiOperation("Delete Student By Id")
	public String deleteStudentById(@PathVariable("id") int id) {
		return service.deleteStudentById(id);
	}
}
