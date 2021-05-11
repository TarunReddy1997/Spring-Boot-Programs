package com.example.demo.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("api/student")
public class StudentController {
	private StudentService studentService;
	
	@GetMapping("/getAllStudents")	
	public Iterable<Student>getAllStudents() {
		return studentService.getallStudents();
	}
	
	@PostMapping("/createStudent")
	public Student createStudent(@RequestBody Student student) {
		return studentService.createStudent(student);
	}
	
	@GetMapping("/getStudent/{phoneNo}")
	public Optional<Student> getStudent(@PathVariable("phoneNo") Integer phoneNo) {
		return studentService.getStudent(phoneNo);
	}
	
	@DeleteMapping("/deleteStudent/{phoneNo}")
	public void deleteStudent(@PathVariable("phoneNo") Integer phoneNo) {
		studentService.deleteStudent(phoneNo);
	}
	
	@PutMapping("/updateStudent/{phoneNo}/{email}")
	public Student updateStudent(@PathVariable("phoneNo") Integer phoneNo, @PathVariable("email") String email) {
		return studentService.updateStudent(phoneNo, email);
	}
}
