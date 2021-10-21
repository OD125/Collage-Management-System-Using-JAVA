package com.action;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.WriteAbortedException;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

import com.bean.StudentBn;
import com.services.EnrollmentSevices;
import com.services.StudentServices;

public class Enrollment{
	//static int studentID=210;
	
	Scanner scanner;
	EnrollmentSevices enrollmentSevices;
	
	//StudentServices studentServices=new StudentServices();
	
	StudentBn studentBn=null;
	
	private String userName;
	private String password;
	
	public String name;
	public int age;
	public Long contactNum;
	public Long aadharNum;
	public String emailId;
	public String dob;
	public String dateOfAddmission;
	public int option;
	public String branch;
	public double hscMarks;
	
	
	
	
	
	
	// Add student or Enroll the student
	public void addStudent(){
		scanner=new Scanner(System.in);
		enrollmentSevices=new EnrollmentSevices();
		/*System.out.println("Enter the User Name");
		userName=scanner.next();
		
		System.out.println("Enter the student name");
		password=scanner.next();*/
		
		System.out.println("Enter the student name");
		name=scanner.next();
		
		
		System.out.println("Enter the student contactNum");
		contactNum=scanner.nextLong();
		
		
		System.out.println("Enter the student email ID");
		emailId=scanner.next();
		
		System.out.println("Enter the student date of birth");
		dob=scanner.next();
		
		System.out.println("Enter the student date of addmission");
		dateOfAddmission=scanner.next();
		
		System.out.println("Enter the H.S.C Marks");
		hscMarks=scanner.nextDouble();
		
		
		branch=enrollmentSevices.selectSubject();
		
		//studentBn=new StudentBn(userName,password,name, age, contactNum, aadharNum, emailId, dob, dateOfAddmission);
		studentBn=new StudentBn(name,branch,contactNum,emailId, dob, dateOfAddmission,hscMarks);
        System.out.println("Sucessfully Registration");
        enrollmentSevices.insertData(studentBn);
        
        
	}
	
	
	
	
	// Calling the method to write and read the object to file
	// Add object into the file
		/*public void readWriteObject(){
			try {
				ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream("Enrollment.txt"));
				
				// Write into file
				objectOutputStream.writeObject(studentBn);
				objectOutputStream.flush();
				objectOutputStream.close();
				
				// Read from the file
				ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Enrollment.txt"));
				studentBn=(StudentBn)objectInputStream.readObject();
				System.out.println(studentBn.getName()+" "+studentBn.getBranch()+" "+studentBn.getDateOfAddmission());
				
				
			} catch (IOException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
*/
	
}
