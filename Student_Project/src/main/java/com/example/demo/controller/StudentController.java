package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	private StudentService service;
	
	@PostMapping("/create")
	public Student createStudent(@RequestBody Student student) {
		return service.create(student);
	}
	
	@GetMapping("/getAllStudents")
	public Iterable<Student> getAllStudents() {
		return service.findAllStudent();
	}
	
	@GetMapping("/getStudentById/{id}")
	public Optional<Student> getById(@PathVariable("id") Integer id) {
		return service.findByStudentId(id);
	}
	
	@DeleteMapping("/deleteStudentById/{id}")
	public void deleteStudent(@PathVariable("id") Integer id) {
		service.delete(id);
	}
	
	@PutMapping("/updateEmail/id={nid}/email={nemail}") 
	public Student updateEmail(@PathVariable("nid") Integer id,@PathVariable("nemail") String email) {
		return service.updateStudentEmail(id, email);
	}
	
	@PutMapping("/updateDepartment")
	public Student updateDepartment(@RequestParam("id") Integer id,@RequestParam("department") String department) {
		return service.updatedepartment(id, department);
	}
}
