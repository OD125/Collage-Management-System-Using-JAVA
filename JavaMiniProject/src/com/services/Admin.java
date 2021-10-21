package com.services;

import java.sql.SQLException;

public interface Admin {
	
	    
	    //public void adminLogIn();
	    public void updateAttendance(String studentId,int semNumber);
	    public void showStudentDetails();
	    //public void updateMarks(String studentId,int semNumber);
	    public void deleteStudent(String studentId);

	 

	}


