package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Job;
import com.example.demo.model.User;
import com.example.demo.service.Job_User_Service;

@RestController
@RequestMapping("/user")
public class Job_User_Controller {

	@Autowired
	private Job_User_Service service;
	
	
	//Create New User:
	@PostMapping("/createuser")
	public User createUser(@RequestBody User user) {
		return service.create(user);
	}
	
	//Create New Job:
	@PostMapping("/postjob")
	public Job createJobs(@RequestBody Job job) {
		return service.createJob(job);
	}
	
	//Upload Bulk Job using Excel input file:
	
	
	
	//Get Job by ID
	@GetMapping("/job/getjob/{id}")
	public Optional<Job> getJobById(@PathVariable("id") Integer id) {
		return service.findById(id);
	}
	
	//Filter Job by Type
	@GetMapping("/job/getByType/{jobType}")
	public List<Job> getJobByType(@PathVariable("jobType") String jobType) {
		return service.findByType(jobType);
	}
	
	//Filter Job by Experience
	@GetMapping("/job/getByExp/{experience}")
	public List<Job> getJobByExp(@PathVariable("experience") Integer experience) {
		return service.findByExp(experience);
	}
	
	// Filter Job by Country
	@GetMapping("/job/getByCountry/{country}")
	public List<Job> getJobByCountry(@PathVariable("country") String country) {
		return service.findByCountry(country);
	}
	
	//Filter Job by Availability:
	@GetMapping("/job/getByAvailability/{availability}")
	public List<Job> getByAvailability(@PathVariable("availability") String availability) {
		return service.findByAvailability(availability);
	}
	
	//Filter Job by Skills:
	@GetMapping("/job/getBySkills/{skills}")
	public List<Job> getBySkills(@PathVariable("skills") String skills) {
		return service.findBySkills(skills);
	}
	
	//Filter Job by Language:
	@GetMapping("/job/getByLanguage/{language}")
	public List<Job> getByLanguage(@PathVariable("language") String language) {
		return service.findByLanguage(language);
	}
	
	//Filter Job by PayRate
	@GetMapping("/job/getByPayRate/{replyRate}/{payRate}")
	public List<Job> getByPayRate(@PathVariable("replyRate") Integer replyRate,@PathVariable("payRate") Integer payRate) {
		return service.findByPayRate(replyRate,payRate);
	}
}
