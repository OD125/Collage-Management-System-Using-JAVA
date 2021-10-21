package com.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.database_connection.DBConnection;

public class SemesterServices {
	
	public void insertSemDetails(String studentId,int semNumber,double subject1Marks,double subject2Marks,double subject3Marks,double percentage,double lectureAttendent,double totalLectures,double attendance){
		
		String sql="insert into semester values(?,?,?,?,?,?,?,?,?)";
		try {
			Connection connection=DBConnection.connect();
			PreparedStatement pstmt=connection.prepareStatement(sql);
			pstmt.setString(1, studentId);
			pstmt.setInt(2, semNumber);
			pstmt.setDouble(3, subject1Marks);
			pstmt.setDouble(4, subject2Marks);
			pstmt.setDouble(5, subject3Marks);
			pstmt.setDouble(6, percentage);
			pstmt.setDouble(7, lectureAttendent);
			pstmt.setDouble(8, totalLectures);
			pstmt.setDouble(9, attendance);
			if(!pstmt.execute()){
				System.out.println("Semester Details Inserted");
				System.out.println("---------------------------\n");
				
			}else {
				System.out.println("Insertion Failed");
				System.out.println("---------------------------\n");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
