package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.StudentService;

@RestController

public class StudentController {

	@Autowired
	private StudentService service;
	
	@RequestMapping(path = "getStudentData")
	public void getStudentData() {
		service.saveStudentData();
	}
}
