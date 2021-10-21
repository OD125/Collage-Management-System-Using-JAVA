package com.action;

import java.util.Scanner;

import com.services.AdminServices;

public class Administrator {
	Scanner scanner;
	int choice;
	AdminServices adminServices;
	Semester semester;
	
	
	
	public void adminOption(){
		semester=new Semester();
		adminServices=new AdminServices();
		scanner=new Scanner(System.in);
		String studentId;
		System.out.println("----Select option-----");
        System.out.println("1. Update Student Attendance\n\n2. Show Student Details \n\n3. Delete Student Data\n\n4. Add Semester Details\n\n5. Add Student Fees");
        choice=scanner.nextInt();
        switch(choice)
        {
        
        
        case 1:
        	//Update student attendace
             System.out.println("Enter Student Id");
             studentId=scanner.next();
             System.out.println("Enter Semester Number");
             int semNumber=scanner.nextInt();
             adminServices.updateAttendance(studentId,semNumber);
             adminOption();
             break;
               
        case 2:
        	//Show student Details
            adminServices.showStudentDetails();
            adminOption();
            break;
            
       
        
        case 3:
        
        	//Delete Student
            System.out.println("Enter Student Id");
            studentId=scanner.next();
            adminServices.deleteStudent(studentId);
            adminOption();
            break;      
        
        case 4:semester.semesterDetails();
              adminOption();
        break;
        
        case 5:adminServices.addFees();
              adminOption();
            
        default :
			break;
            
        
        
        
        }
	}



}
