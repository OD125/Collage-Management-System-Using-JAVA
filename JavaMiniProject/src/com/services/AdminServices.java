package com.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import com.action.Fees;
import com.bean.StudentBn;
import com.database_connection.DBConnection;

public class AdminServices implements Admin{
	
	Scanner scanner;
	Fees fees;
	
	// Update Student Attendance
	public void updateAttendance(String studentId,int semNumber){
	    scanner=new Scanner(System.in);
		System.out.println("Enter Lecture Attend by Student :-  ");
        double lectureAttend = scanner.nextDouble();
        System.out.println("Enter Total Lecture Held :- ");
        double totalLectures = scanner.nextDouble();
        double attendance = (lectureAttend / totalLectures) * 100;
		Connection connection=DBConnection.connect();
		
		try {
			PreparedStatement pstmt=connection.prepareStatement("Update semester set LectureAttendent=?,TotalLecture=?,Attendance=? Where StudentId=? and SemesterNo=?");
			pstmt.setDouble(1, lectureAttend);
			pstmt.setDouble(2, totalLectures);
			pstmt.setDouble(3, attendance);
			pstmt.setString(4, studentId);
			pstmt.setInt(5, semNumber);
			if(!pstmt.execute()){
				System.out.println("Updated Successfully");
				System.out.println("---------------------------\n");
			}else {
				System.out.println("Updation Failed");
				System.out.println("---------------------------\n");
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// Delete Student 
	public void deleteStudent(String studentId){
		Connection connection=DBConnection.connect();
		
		try {
			PreparedStatement pstmt=connection.prepareStatement("Delete from student where StudentId=?");
			pstmt.setString(1, studentId);
			
			if(!pstmt.execute()){
				System.out.println("Delete Successfully");
				System.out.println("---------------------------\n");
			}else {
				System.out.println("Delete Failed");
				System.out.println("---------------------------\n");
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// Get student details
	public void showStudentDetails(){
           Connection connection=DBConnection.connect();
           ArrayList<StudentBn> studentList=new ArrayList<>();
           StudentBn studentBn=null;
		
		try {
			PreparedStatement pstmt=connection.prepareStatement("Select * from student");
	        ResultSet rs = pstmt.executeQuery();
	        int i=0;
	        while(rs.next()){
	        	studentBn=new StudentBn();
	        	studentBn.setStudentId(rs.getString(1));
	        	studentBn.setPassword(rs.getString(2));
	        	studentBn.setName(rs.getString(3));
	        	studentBn.setBranch(rs.getString(4));
	        	studentBn.setContactNum(rs.getLong(5));
	        	studentBn.setEmailId(rs.getString(6));
	        	studentBn.setDob(rs.getString(7));
	        	studentBn.setDateOfAddmission(rs.getString(8));
	        	studentBn.setHscMarks(rs.getDouble(9));
	        	studentBn.setFees(rs.getInt(10));
	            studentList.add(studentBn);
	        }
	         Collections.sort(studentList, new SortStudentByName());
	            for (StudentBn studentBn2 : studentList) {
	            	i++;
	            	System.out.println(i+": Student\n");
		        	System.out.println("Student Id:     "+studentBn2.getStudentId());
		        	System.out.println("Password:       "+studentBn2.getPassword());
		        	System.out.println("Student Name:   "+studentBn2.getName());
		        	System.out.println("Branch:         "+studentBn2.getBranch());
		        	System.out.println("Contact Number: "+studentBn2.getContactNum());
		        	System.out.println("Email ID:       "+studentBn2.getEmailId());
		        	System.out.println("H.S.C Marks:    "+studentBn2.getHscMarks());
		        	System.out.println("Fees Paid:      "+studentBn2.getFees());
		        	System.out.println("Date Of Birth:  "+studentBn2.getDob());
		        	System.out.println("Addmission Date:"+studentBn2.getDateOfAddmission());
		        	System.out.println("-------------------------------\n");
				}
			
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	//Used this method to add student fees
	public void addFees(){
		scanner=new Scanner(System.in);
		fees=new Fees();
		System.out.println("Enter Amount");
		int amount=scanner.nextInt();
		System.out.println("Enter StudentId");
		String studentId=scanner.next();
		System.out.println("Enter Branch");
		String branch=scanner.next();
		
		fees.addStudentFees(amount,studentId,branch);
		
		
		
		
	}


}
