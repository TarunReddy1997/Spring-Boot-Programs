package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	@Autowired
	private StudentService studentService;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Student student = new Student();
		student.setName("charan");
		student.setPhoneNo(1234);
		student.setClassNo(6);
		student.setAddress("hyderabad");
		student.setEmail("charan@gmail.com");
		studentService.createStudent(student);
		//studentService.getallStudents();
	}

}
