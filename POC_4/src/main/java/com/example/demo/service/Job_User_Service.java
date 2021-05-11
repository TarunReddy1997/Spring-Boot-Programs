package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.JobDao;
import com.example.demo.dao.UserDao;
import com.example.demo.model.Job;
import com.example.demo.model.User;

@Service
public class Job_User_Service {

	@Autowired
	private JobDao jobDao;
	
	@Autowired
	private UserDao userDao;
	
	public User create(User user) {
		return userDao.save(user);
	}
	
	public Job createJob(Job job) {
		return jobDao.save(job);
	}
	
	//Get Job by ID
	public Optional<Job> findById(Integer id) {
		return jobDao.findById(id);
	}
	//Filter Job by Type
	public List<Job> findByType(String jobType) {
		return jobDao.findByJobType(jobType);
	}


	//Filter Job By Experience
	public List<Job> findByExp(Integer experience) {
		return jobDao.findByJobExp(experience);
	}
	
	//Filter Job By Country
	public List<Job> findByCountry(String country) {
		return jobDao.findByJobCountry(country);
	}
	
	//Filter Job By Availability
	public List<Job> findByAvailability(String availability) {
		return jobDao.findByJobAvailability(availability);
	}

	///Filter Job By Skills
	public List<Job> findBySkills(String skills) {
		return jobDao.findByJobSkills(skills);
	}

	public List<Job> findByLanguage(String language) {
		return jobDao.findByJobLanguage(language);
	}

	public List<Job> findByPayRate(Integer replyRate, Integer payRate) {
		return jobDao.findByJobPayRate(replyRate,payRate);
	}
}
