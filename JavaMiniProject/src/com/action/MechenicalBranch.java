package com.action;

import java.util.Scanner;

import com.services.SemesterServices;

public class MechenicalBranch extends Branch {
    
     Scanner sc;
	 public double percentage;
	 public double totalMarks;
	 public double marks = 0.0d;
	 double lectureAttend;
	 double totalLectures;
	 double attendance;
	 SemesterServices semesterServices;
	 Fees fees;
	 
	
	@Override
	public void addSemesterDetails() {
		sc = new Scanner(System.in);
		semesterServices=new SemesterServices();
		
       System.out.println("Enter Student ID :-");
       String StudentId = sc.next();
       
       System.out.println("Enter Mechanical Semester Number");
       int semNumber = sc.nextInt();

       
       if (semNumber == 1) {

           System.out.println("Enter Marks for Mechanical Sem 1 :-");
           
           System.out.println("Engineering Mathematics-I :-");
           double subject1Marks = sc.nextDouble();
           
           System.out.println("Solid Modeling and Drafting :-");
           double subject2Marks = sc.nextDouble();
           
           System.out.println("Engineering Thermodynamics:-");
           double subject3Marks = sc.nextDouble();
           
           marks = subject1Marks + subject2Marks + subject3Marks;
           totalMarks = 300.0d;
           percentage = (marks / totalMarks) * 100;
           System.out.println("Total Marks :-  " + marks);
           System.out.println("Semester Percentage :-  " + percentage+"\n");


           if (subject1Marks < 40.00d) {
           	 System.out.println("Student is Failed in Exam,because Subject Marks is less than 40 !\n");

           } else if (subject2Marks < 40.00d) {
                 System.out.println("Student is Failed in Exam,because Subject Marks is less than 40 !\n");
                 
           } else if (subject2Marks < 40.00d) {
           	System.out.println("Student is Failed in Exam, because Subject Marks is less than 40 !\n");
        }
           
           System.out.println("Enter attendance details for Sem 1 :-");
           System.out.println("Enter Lecture Attend by Student :-  ");
           lectureAttend = sc.nextDouble();
           System.out.println("Enter Total Lecture Held :- ");
           totalLectures = sc.nextDouble();
           attendance = (lectureAttend / totalLectures) * 100;
           System.out.println("Semester Attendance :-  " + attendance);
           
           if (attendance < 75) {
               System.out.println("Attend Lectures Regularly !");
           }
           
           // Call below method to insert semester data into database
           semesterServices.insertSemDetails(StudentId,semNumber,subject1Marks,subject2Marks,subject3Marks,percentage,lectureAttend,totalLectures,attendance);
           
           
       }else if(semNumber==2){

           System.out.println("Enter Marks for Computer Science Sem 2 :-");
           
           System.out.println("Engineering Mathematics-II:-");
           double subject1Marks = sc.nextDouble();
           
           System.out.println("Fluid Mechanics :-");
           double subject2Marks = sc.nextDouble();
           
           System.out.println("Machine Shop:-");
           double subject3Marks = sc.nextDouble();
           
           marks = subject1Marks + subject2Marks + subject3Marks;
           totalMarks = 300.0d;
           percentage = (marks / totalMarks) * 100;
           System.out.println("Total Marks :-  " + marks);
           System.out.println("Semester Percentage :-  " + percentage+"\n");


           if (subject1Marks < 40.00d) {
           	 System.out.println("Student is Failed in Exam,because Subject Marks is less than 40 !\n");

           } else if (subject2Marks < 40.00d) {
                 System.out.println("Student is Failed in Exam,because Subject Marks is less than 40 !\n");
                 
           } else if (subject2Marks < 40.00d) {
           	System.out.println("Student is Failed in Exam, because Subject Marks is less than 40 !\n");
        }
           
           System.out.println("Enter attendance details for Sem 1 :-");
           System.out.println("Enter Lecture Attend by Student :-  ");
           lectureAttend = sc.nextDouble();
           System.out.println("Enter Total Lecture Held :- ");
           totalLectures = sc.nextDouble();
           attendance = (lectureAttend / totalLectures) * 100;
           System.out.println("Semester Attendance :-  " + attendance);
           
           if (attendance < 75) {
               System.out.println("Attend Lectures Regularly !");
           }
           semesterServices.insertSemDetails(StudentId,semNumber,subject1Marks,subject2Marks,subject3Marks,percentage,lectureAttend,totalLectures,attendance);

       	
       }else {
			System.out.println("Semester number is wrong");
			System.out.println("Enter semester number 1 or 2");
			addSemesterDetails();
		}

	}
	
	public void branchSubject()
	{
		System.out.println("-------SEM I-------");
		System.out.println("1 : Engineering Mathematics-I");
		System.out.println("2 : Solid Modeling and Drafting");
		System.out.println("3 : Engineering Thermodynamics");
	
		System.out.println("-------SEM II-------");
		System.out.println("1 : Engineering Mathematics-II");
		System.out.println("2 : Fluid Mechanics ");
		System.out.println("3 : Machine Shop");
		System.out.println("----------------------------\n");
	}
	
	
	// Used this method to display fees
	@Override
	public void showStudentFees(String studentId){
		fees=new Fees();
		fees.feesStructure(studentId, "Computer");
	}
	
}