package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Job;

@Repository
public interface JobDao extends JpaRepository<Job, Integer>{

	public List<Job> findByJobType(String jobType);

	@Query("select j from job j where j.experience=?1") //jpql query
	public List<Job> findByJobExp(Integer experience);
	
	@Query("select j from job j where j.country=?1") //jpql query
	public List<Job> findByJobCountry(String country);

	//@Query(value="select * from job j where j.availability=?1",nativeQuery=true)//native query
	@Query("select j from job j where j.availability=?1") //jpql query
	public List<Job> findByJobAvailability(String availability);

	@Query("select j from job j where j.skills=?1")
	public List<Job> findByJobSkills(String skills);

	@Query("select j from job j where j.language=?1")
	public List<Job> findByJobLanguage(String language);

	@Query("select j from job j where j.replyRate=?1 and j.payRate=?2")
	public List<Job> findByJobPayRate(Integer replyRate, Integer payRate);
}
