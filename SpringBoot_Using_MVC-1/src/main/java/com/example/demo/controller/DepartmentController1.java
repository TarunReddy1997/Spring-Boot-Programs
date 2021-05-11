package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.dao.Deptdao;
import com.example.demo.model.Department;

@RestController
@RequestMapping("/rest/dept")
public class DepartmentController1 {

	@Autowired
	Deptdao deptdao;

	@GetMapping()
	public Iterable<Department> getAllDept(){
		return deptdao.findAll();
	}

	@GetMapping("/{id}") 
	public Department getOneDept(@PathVariable("id") int id) {
		Optional<Department> dept=deptdao.findById(id);
		if(dept.isPresent())
			return dept.get();
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Department Id not found");
	}
	
	@PostMapping()//For HTTP POST Request
	public Department addDept(Department dept) {
		try {
			//check whether deptId is already present ,if so throw exception
			deptdao.save(dept);
			return dept;
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Invalid Data");
		}
	}
	
	@DeleteMapping("/{id}") //For HTTP Delete Request
	public void deleteDept(@PathVariable("id") int id) {
		Optional<Department> dept= deptdao.findById(id);
		if(dept.isPresent()) {
			try {
				deptdao.delete(dept.get());
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Depatmrnt Id not found");
			}
	}
	
	@PutMapping("/{id}") //For HTTP Put Request
	public void updateDept(@PathVariable("id") int id,Department newDept) {
		Optional<Department> dept = deptdao.findById(id);
		if(dept.isPresent()) {
			try {
				Department department=dept.get();
				department.setName(newDept.getName());
				deptdao.save(department);
			}
			catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Department Id not found");
		}
	}
}
