package com.bean;

import java.io.Serializable;

public class StudentBn{
	
	private String name;
	//private int age;
	private Long contactNum;
	//private Long aadharNum;
	private String emailId;
	private String dob;
	private String dateOfAddmission;
	private String branch;
	private String studentId;
	private String password;
	private double hscMarks;
	private int fees;
	
	/*// Construcctor with password or userName
	public StudentBn(String userName,String password,String name, int age, Long contactNum, Long aadharNum, String emailId, String dob,
			String dateOfAddmission) {
		super();
		this.userName=userName;
		this.password=password;
		this.name = name;
		this.age = age;
		this.contactNum = contactNum;
		this.aadharNum = aadharNum;
		this.emailId = emailId;
		this.dob = dob;
		this.dateOfAddmission = dateOfAddmission;
		//this.branch=branch;
	}*/
	
	
	
	//Constructor without userName
	public StudentBn(String name, String branch,Long contactNum, String emailId, String dob,String dateOfAddmission,double hscMarks) {
		//this.userName=userName;
		//this.password=password;
		this.name = name;
		this.contactNum = contactNum;
		this.emailId = emailId;
		this.dob = dob;
		this.dateOfAddmission = dateOfAddmission;
		this.branch=branch;
		this.hscMarks=hscMarks;
	}

	public StudentBn() {
		super();
	}

	
	
	
	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}

	public double getHscMarks() {
		return hscMarks;
	}

	public void setHscMarks(double hscMarks) {
		this.hscMarks = hscMarks;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBranch() {
		return branch;
	}
	


	public void setBranch(String branch) {
		this.branch = branch;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

	public Long getContactNum() {
		return contactNum;
	}
	public void setContactNum(Long contactNum) {
		this.contactNum = contactNum;
	}
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getDateOfAddmission() {
		return dateOfAddmission;
	}
	public void setDateOfAddmission(String dateOfAddmission) {
		this.dateOfAddmission = dateOfAddmission;
	}
	
	

}
