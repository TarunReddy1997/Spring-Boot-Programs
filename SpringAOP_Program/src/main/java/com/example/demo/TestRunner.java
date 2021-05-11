package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.businesslogic.BusinessLogic;

@Component
public class TestRunner implements CommandLineRunner{

	@Autowired
	private BusinessLogic businessLogic;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		businessLogic.saveEmployee();
		
	}
	
	
}
