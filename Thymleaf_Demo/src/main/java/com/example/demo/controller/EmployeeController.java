package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@Controller
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/reg")
	public String regPage(ModelMap map) {
		Employee e = new Employee();
		map.addAttribute("employee",e);
		return "Register";
	}
	
	@PostMapping("/save")
	public String addEmployee(@ModelAttribute Employee employee ,ModelMap map) {
		employeeService.save(employee);
		map.addAttribute("emp",employee);
		return "Info";
	}
	
	@RequestMapping("/all")
	public String showDates(ModelMap map) {
		map.addAttribute("message","Hello-UI");
		List<Employee> emps = employeeService.findAll();
		map.addAttribute("list",emps);
		return "Data";
	}
}
