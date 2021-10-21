package com.action;

import java.util.Scanner;

public class Semester {
	Scanner sc;
	Branch computerBranch;
	Branch mechenicalBranch;
	
	public void semesterDetails() {
		computerBranch=new ComputerBranch();
		mechenicalBranch=new MechenicalBranch();

		sc=new Scanner(System.in);

        System.out.println("-------Choose Student-------- ");
        System.out.println("1.Computer");
        System.out.println("2.Mechanical");
        
       
        int option=sc.nextInt();
    
        switch(option) {
        case 1:computerBranch.addSemesterDetails();
               semesterDetails();
            break;
        case 2:mechenicalBranch.addSemesterDetails();
               semesterDetails();
            break;
        default:
        	break;
            
        }
    }

}
