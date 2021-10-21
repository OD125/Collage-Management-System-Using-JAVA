package com.action;

import java.util.Scanner;
import com.bean.StudentBn;
import com.main.Management;
import com.services.StudentServices;

public class Student {
	
	private String studentId;
	private String password;
	public int option;
	public String branch=null;
	Scanner scanner=new Scanner(System.in);
	StudentBn studentBn;
	StudentServices studentServices;
	Branch computerBranch, mechenicalBranch;
	

	
	
	public Student() {
		
	}

	// Used this method for login
	public void login(){
		
		studentServices=new StudentServices();
		studentBn=new StudentBn();
		
		System.out.println("Enter Student ID");
		studentId=scanner.next();
		System.out.println("Enter Password");
		password=scanner.next();
		
		
		branch=studentServices.validate(studentId, password);
		if(branch==null){
			System.out.println("Login Failed");
			login();
		}else {
			System.out.println("Login Successfully");
			operation();
		}
		
			
	}
	
	// Used this method to get and update user information, show subject and Fees Structure
	public void operation(){
		computerBranch=new ComputerBranch();
		mechenicalBranch=new MechenicalBranch();
		studentBn=new StudentBn();
		studentServices=new StudentServices();
		System.out.println("1. Show Details\n2. Update Details\n3. Show Subject\n4. Fee Structure\nPress 0 to exit");
		option=scanner.nextInt();
		switch (option) {
		
		case 1:studentServices.getDetails(studentId);
		    operation();
			break;
			
		case 2:studentServices.updateDetails(studentId);
		     operation();
		     break;
		
		case 3:if(branch.equalsIgnoreCase("Computer")){
			      computerBranch.branchSubject();
		      }else{
		    	  mechenicalBranch.branchSubject();
		      }
		     operation();
		     break;
		     
		case 4:studentServices.feeStructure(studentId,branch,computerBranch,mechenicalBranch);
	     operation();
	     break;

		default :
			break;
		}
	}
	
	

}
