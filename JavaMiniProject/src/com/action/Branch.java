package com.action;

public class Branch  {
	
	Fees fees;
	
	public void addSemesterDetails(){
		System.out.println("Branch.addSemesterDetails()");
		System.out.println("Branch is parent class");
	}
	
	public void branchSubject(){
		System.out.println("Branch.branchSubject()");
	}
	
	public void feesStructure(String studentId){
		System.out.println("Branch.feesStructure()");
	}
	
	public void showStudentFees(String studentId){
		System.out.println("Branch.feesStructure()");
	}

}
