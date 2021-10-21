package com.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.database_connection.DBConnection;

public class Fees {
	
	// Use this method to display fees
		
		public void feesStructure(String studentId,String branch){
			int developmentFees = 0,tuitionFees = 0,examFees = 0,othersFees = 0,totalFees = 0,feesPaid=0,remainingFees=0;
			Connection connection=DBConnection.connect();
			try {
				PreparedStatement pstmt1=connection.prepareStatement("SELECT DevelopmentFess,TuitionFees,ExamFees,OtherFees FROM fees Where branch=?");
				pstmt1.setString(1, branch);
				ResultSet rs=pstmt1.executeQuery();
				
				while(rs.next()){
					developmentFees=rs.getInt(1);
					tuitionFees=rs.getInt(2);
					examFees=rs.getInt(3);
					othersFees=rs.getInt(4);
				}
				
				PreparedStatement pstmt2=connection.prepareStatement("SELECT FeesPaid FROM student where StudentId=?");
				pstmt2.setString(1, studentId);
				ResultSet rs1=pstmt2.executeQuery();
				while(rs1.next()){
					feesPaid=rs1.getInt(1);
				}
				totalFees=developmentFees+tuitionFees+examFees+othersFees;
				remainingFees=totalFees-feesPaid;
				System.out.println("Development Fees: "+developmentFees);
				System.out.println("Tuition Fees:     "+tuitionFees);
				System.out.println("Exam Fees:        "+examFees);
				System.out.println("Other Fees:       "+othersFees);
				System.out.println("Total Fees:       "+totalFees);
				System.out.println("------------------------");
				System.out.println("Fees Paid : "+feesPaid);
				System.out.println("Remaining Fees : "+remainingFees);
				System.out.println("--------------------------\n");
				
				
				connection.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		// insert student fees into database
		public void addStudentFees(int amount,String studentId,String branch){
			Connection connection=DBConnection.connect();
			PreparedStatement pstmt1;
			PreparedStatement pstmt2;
			int addAmount=0;
			try {
				pstmt1 = connection.prepareStatement("SELECT FeesPaid from student where StudentId=?");
				pstmt1.setString(1, studentId);
				ResultSet rs=pstmt1.executeQuery();
				while(rs.next()){
					addAmount=amount+rs.getInt(1);
				}
				
				pstmt2=connection.prepareStatement("UPDATE STUDENT set FeesPaid=? where studentId=?");
				pstmt2.setInt(1, addAmount);
				pstmt2.setString(2, studentId);
				if(!pstmt2.execute()){
					System.out.println("Fees Added");
					System.out.println("------------------------");
				
				}else {
					System.out.println("Failed To Add Fees");
				}
				
				
			
				connection.close();
				feesStructure(studentId, branch);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}


}
