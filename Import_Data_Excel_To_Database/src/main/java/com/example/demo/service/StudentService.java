package com.example.demo.service;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StudentDao;
import com.example.demo.model.Student;

@Service
public class StudentService {

	@Autowired
	private StudentDao dao;

	String line="";
	public void saveStudentData() {
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/StudentData.xlsx"));
			while ((line = bufferedReader.readLine()) != null) {
				String[] data = line.split(",");
				Student student = new Student();
				student.setSname(data[0]);
				student.setEmail(data[1]);
				student.setPhno(data[2]);
				dao.save(student);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

