package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue()
	private int sno;
	private String sname;
	private String email;
	private String phno;



	public int getSno() {
		return sno;
	}



	public void setSno(int sno) {
		this.sno = sno;
	}



	public String getSname() {
		return sname;
	}



	public void setSname(String sname) {
		this.sname = sname;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPhno() {
		return phno;
	}



	public void setPhno(String phno) {
		this.phno = phno;
	}



	@Override
	public String toString() {
		return "Student [sno=" + sno + ", sname=" + sname + ", email=" + email + ", phno=" + phno + "]";
	}


}
