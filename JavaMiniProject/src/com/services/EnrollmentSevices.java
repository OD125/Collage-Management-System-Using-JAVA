package com.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.action.Student;
import com.bean.StudentBn;
import com.database_connection.DBConnection;

public class EnrollmentSevices {
	
	public  int option;
	public  String branch;
	
	
	Scanner scanner=new Scanner(System.in);
	
	public String selectSubject(){
		
		System.out.println("Enter the number to select branch");
		System.out.println("1. Computer Science\n2. Mechanical");
		option=scanner.nextInt();
		switch(option){
		case 1:
		    branch="Computer";
		    break;
			
		case 2:
			branch="Mechenical";
			break;
			
		default:
			break;
		}
		
		return branch;
	}
	
	// Used this method to insert data into database
	public void insertData(StudentBn studentBn){
		
		
		
		try {
			Connection conn=DBConnection.connect();
			
			PreparedStatement pstmt=conn.prepareStatement("insert into student values(?,?,?,?,?,?,?,?,?,?)");
			
			
			pstmt.setString(1, "student");
			pstmt.setString(2, "student");
			pstmt.setString(3, studentBn.getName());
			pstmt.setString(4, studentBn.getBranch());
			pstmt.setLong(5, studentBn.getContactNum());
			pstmt.setString(6, studentBn.getEmailId());
			pstmt.setString(7, studentBn.getDob());
			pstmt.setString(8, studentBn.getDateOfAddmission());
			pstmt.setDouble(9, studentBn.getHscMarks());
			pstmt.setInt(10, 0);
			
			/*pstmt.setString(1, studentBn.getName());
			pstmt.setString(2, studentBn.getBranch());
			pstmt.setLong(3, studentBn.getContactNum());
			pstmt.setString(4, studentBn.getEmailId());
			pstmt.setString(5, studentBn.getDob());
			pstmt.setString(6, studentBn.getDateOfAddmission());
			pstmt.setDouble(7, studentBn.getHscMarks());*/
			pstmt.executeUpdate();
			
			System.out.println("Successfullu Inserted....");
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}
