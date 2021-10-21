package com.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.action.Branch;
import com.action.ComputerBranch;
import com.action.MechenicalBranch;
import com.action.Student;
import com.bean.StudentDetailsBn;
import com.database_connection.DBConnection;

public class StudentServices {
	
	
	Scanner scanner;
	
	public String validate(String studentId,String password) {
		Connection con;
		String branch = null;
		//System.out.println("StudentServices.validate()");
		
		// step 1 to register the Driver
        try {
        	 con=DBConnection.connect();
	        
	        //3.Statement we have to create the statement
	        PreparedStatement pstmt=con.prepareStatement("select Password,Branch from student where StudentId=?");
	        pstmt.setString(1, studentId);
        	 
        	 /*Statement st=con.createStatement();
        	 ResultSet rs=st.executeQuery("select Password,Branch from student where StudentId=?");*/
        	 
	        
	        //4. execute query
	        ResultSet rs=pstmt.executeQuery();
	        while(rs.next()){
	        	if(rs.getString(1).equalsIgnoreCase(password)){
		               branch=rs.getString(2);
		        	}else{
		        		System.out.println("Wrong password");
		        	}
	        }
	        /*while(rs.next())
	        {
	        	if(rs.getString(1).equals(password)){
	               branch=rs.getString(2);
	              // System.out.println("Login Successfull");
	        	}else{
	        		System.out.println("Wrong password");
	        	}
	        		
	        }*/
	      //step 5
	        con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}     
        
       
        return branch;
      }
	
	
	
	
	// This method is used to show details of student
	public void getDetails(String studentId){
		ArrayList<StudentDetailsBn> studentDetailsList=new ArrayList<>();
		StudentDetailsBn studentDetailsBn=null;
		Connection connection=DBConnection.connect();
		
		try {
			
			String sql="Select s.StudentId,s.FullName,s.Branch,sem.SemesterNo,sem.Subject1Marks,sem.Subject2Marks,sem.Subject3Marks,sem.Percentage,sem.Attendance "
					+ "from student s "
					+ "JOIN semester sem on s.StudentId=sem.StudentId WHERE s.studentId=?";
			PreparedStatement pstmt=connection.prepareStatement(sql);
			pstmt.setString(1, studentId);
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next()){
			    studentDetailsBn=new StudentDetailsBn();
				//System.out.println(rs.getRow());
				studentDetailsBn.setStudentId(rs.getString(1));
				studentDetailsBn.setName(rs.getString(2));
				studentDetailsBn.setBranch(rs.getString(3));
				studentDetailsBn.setSemNo(rs.getInt(4));
				studentDetailsBn.setSubject1Marks(rs.getInt(5));
				studentDetailsBn.setSubject2Marks(rs.getInt(6));
				studentDetailsBn.setSubject3Marks(rs.getInt(7));
				studentDetailsBn.setPercentage(rs.getDouble(8));
				studentDetailsBn.setAttandacne(rs.getDouble(9));
				studentDetailsList.add(studentDetailsBn);
				studentDetailsBn=null;	
				
			}
			printDetails(studentDetailsList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//Print Student details
	public void printDetails(ArrayList<StudentDetailsBn> studentDetailsList){

		for (StudentDetailsBn studentDetailsBn : studentDetailsList) {
			if(studentDetailsBn.getBranch().equalsIgnoreCase("computer")){
				if (studentDetailsBn.getSemNo()==1) {
					System.out.println("----Sem 1 Details---");
					System.out.println("Basic Mathematics:- "+studentDetailsBn.getSubject1Marks());
					System.out.println("Fundamentals of Data Structure:- "+studentDetailsBn.getSubject2Marks());
					System.out.println("Object Oriented Programming "+studentDetailsBn.getSubject3Marks());
					System.out.println("Percentage "+studentDetailsBn.getPercentage());
					System.out.println("Attendance "+studentDetailsBn.getAttandacne());
					System.out.println("");
					
				} else {
					System.out.println("----Sem 2 Details---");
					System.out.println("Data Structure and Algorithms "+studentDetailsBn.getSubject1Marks());
					System.out.println("Microprocessor Lab "+studentDetailsBn.getSubject2Marks());
					System.out.println("Principle of Programming Language "+studentDetailsBn.getSubject3Marks());
					System.out.println("Percentage "+studentDetailsBn.getPercentage());
					System.out.println("Attendance "+studentDetailsBn.getAttandacne());
					System.out.println("");

				}
			}else{
				if (studentDetailsBn.getSemNo()==1) {
					System.out.println("----Sem 1 Details---");
					System.out.println("Engineering Mathematics-I "+studentDetailsBn.getSubject1Marks());
					System.out.println("Solid Modeling and Drafting "+studentDetailsBn.getSubject2Marks());
					System.out.println("Engineering Thermodynamics "+studentDetailsBn.getSubject3Marks());
					System.out.println("Percentage "+studentDetailsBn.getPercentage());
					System.out.println("Attendance "+studentDetailsBn.getAttandacne());
					
				} else {
					System.out.println("----Sem 2 Details---");
					System.out.println("Engineering Mathematics-II "+studentDetailsBn.getSubject1Marks());
					System.out.println("Fluid Mechanics "+studentDetailsBn.getSubject2Marks());
					System.out.println("Machine Shop "+studentDetailsBn.getSubject3Marks());
					System.out.println("Percentage "+studentDetailsBn.getPercentage());
					System.out.println("Attendance "+studentDetailsBn.getAttandacne());

				}
				
			}
			
		}
	}
	
	// Method used to update the details
	public void updateDetails(String studentId){
		scanner=new Scanner(System.in);
		System.out.println("Select Option");
		System.out.println("1. Update Email Id\n2. Update Contact Number\n Press 0 to exit");
		int option=scanner.nextInt();
		switch (option) {
		
		case 1:System.out.println("Enter Email ID");
		     String emailId=scanner.next();
		     updateEmail(studentId, emailId);
		     updateDetails(studentId);
			break;
			
		case 2:System.out.println("Enter Contact Number");
	         long contactNumber=scanner.nextLong();
		     updateContacts(studentId, contactNumber);
		     updateDetails(studentId);
		break;

		default:
			break;
		}
		
		
	}
	
	
	
	// Update contact Number
	public void updateContacts(String studentId, long contactNumber){
		
		Connection connection=DBConnection.connect();
		String sql="update student set ContactNumber=? where StudentId=?";
		try {
			PreparedStatement pstmt=connection.prepareStatement(sql);
			pstmt.setLong(1, contactNumber);
			pstmt.setString(2, studentId);
			if(!pstmt.execute()){
				System.out.println("Data Updated Successfully");
			}else{
				System.out.println("Updatation Failed");
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// Update Email Id
	public void updateEmail(String studentId,String emailId){
		Connection connection=DBConnection.connect();
		String sql="update student set EmailId=? where StudentId=?";
		try {
			PreparedStatement pstmt=connection.prepareStatement(sql);
			pstmt.setString(1,emailId);
			pstmt.setString(2, studentId);
			if(!pstmt.execute()){
				System.out.println("Data Updated Successfully");
			}else{
				System.out.println("Updatation Failed");
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void feeStructure(String studentId,String branch,Branch computerBranch,Branch mechenicalBranch){
		if(branch.equalsIgnoreCase("Computer")){
			computerBranch.showStudentFees(studentId);	
		}else {
			mechenicalBranch.showStudentFees(studentId);
		}
	}
}
	

	
	
