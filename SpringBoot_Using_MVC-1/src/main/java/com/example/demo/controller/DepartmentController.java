package com.example.demo.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dao.Deptdao;
import com.example.demo.model.Department;

@Controller
public class DepartmentController {

	@Autowired
	private Deptdao deptdao;
	
	@RequestMapping("/adddept")
	public String addDept(ModelMap model) {
		Department d = new Department();
		model.addAttribute("dept", d);
		return "add_dept";
	}
	
	@RequestMapping(value="/adddept",method = RequestMethod.POST)
	public String addDept(@Valid Department d ,Errors errors,ModelMap model) {
		try {
			if(errors.getErrorCount() > 0) {
				throw new RuntimeException(errors.toString());
			}
			if(deptdao.findById(d.getId()).isPresent()) {
				throw new RuntimeException("Dept id already exist");
			}
				deptdao.save(d);
				return "redirect:/deptlist";
			
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("dept",d);
			model.addAttribute("message",e.getMessage());
			return "add_dept";
		}
		
	}
	
	@RequestMapping("/deptlist")
	public String getDeptList(ModelMap model) {
		model.addAttribute("depts",deptdao.findAll());
		return "deptlist";
	}
	
	@RequestMapping("/deletedept/{id}")
	public String deleteDept(@PathVariable("id") int id,ModelMap model) {
		Optional<Department> dept=deptdao.findById(id);
		if(dept.isPresent()) {
			deptdao.delete(dept.get());
			return "redirect:/deptlist";
		}
		else {
			model.addAttribute("error","DepartmentID not found");
			return "delete_dept";
		}
	}
	
	@RequestMapping("/editdept/{id}")
	public String editDept(@PathVariable("id") int id,ModelMap model) {
		Optional<Department> dept = deptdao.findById(id);
		if(dept.isPresent()) {
			model.addAttribute("dept",dept.get());
		}
		else {
			model.addAttribute("error","Department Id not found");
			
		}
		return "edit_dept";
	}
	
	@RequestMapping(value = "/editdept/{id}",method = RequestMethod.POST)
	public String updateDept(@PathVariable("id") int id,Department d,ModelMap model) {
		try {
			Optional<Department> dept = deptdao.findById(d.getId());
			if(dept.isPresent()) 
				deptdao.save(d);	
			else
				throw new Exception("Invalid dept id");
				return "redirect:/deptlist";
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("dept",d);
			model.addAttribute("error",e.getMessage());
			return "edit_dept";
		}
		
	}
}
