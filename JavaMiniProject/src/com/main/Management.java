package com.main;

import java.util.Scanner;

import com.action.AdminLogin;
import com.action.Enrollment;
import com.action.Student;
import com.services.EnrollmentSevices;
import com.services.StudentServices;

public class Management {
	
	int option;
	Enrollment enrollment;//=new Enrollment();
	AdminLogin adminLogin;
	Student student;//
	Scanner scanner;//
	
	
	// Role Operation
	public void operation(){
		scanner=new Scanner(System.in);
		student=new Student();
		adminLogin=new AdminLogin();
		System.out.println("-----Select The Option----");
		System.out.println("1. Enrollment\n2. Student Login\n3. Admin Login");
		System.out.println("---------------------------");
		option=scanner.nextInt();
		
		switch (option) {
		case 1:enrollment.addStudent();
		       operation();
		    break;
		    
		case 2:student.login();
		     operation();
			break;
			
		case 3:adminLogin.adminLogIn();	
			
		default:
			break;
		}
		
		
		}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		new Management().operation();
	}

}
