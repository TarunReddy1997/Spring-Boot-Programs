package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Department;

public interface Deptdao extends JpaRepository<Department, Integer>{

	@Query("from Department d where d.id=?1")
	List<Department> getRecentDepartments(int deptid);
	
	@Query(value="select(avg(length(department_name)) from departments", nativeQuery=true)
	int getAvgLength();
	
}
