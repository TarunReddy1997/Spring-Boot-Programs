package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeDao dao;
	
	public List<Employee> findAll(){
		return dao.findAll();
	}
	
	public void save(Employee theemployee) {
		dao.save(theemployee);
	}
	
	public void deleteById(Long theid) {
		dao.deleteById(theid);
	}
	
}
