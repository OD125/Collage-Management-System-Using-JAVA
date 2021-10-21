package com.action;

import java.util.Scanner;

public class AdminLogin {
	
	String Username="pritam";
    String Password="12345";
    int id=0;
    String str=null;
    Scanner scn;
    Administrator administrator;
	
	public  void adminLogIn()
     {    
		scn=new Scanner(System.in);
		administrator=new Administrator();
        boolean loop=true;
        while(loop)
        {
        System.out.println("Enter user name");
        String str=scn.next();
      
        System.out.println("Enter password");
        String id=scn.next();
        if (str.equals(Username) && id.equals(Password)) {

 

                System.out.println("Access Granted! Welcome!");
                loop=false;
                System.out.println("........................\n");
                administrator.adminOption();
               
            }

 

            else if (str.equals(Username)) {
                System.out.println("Invalid Password!");
            } else if (id.equals(Password)) {
                System.out.println("Invalid Username!");
            } else {
                System.out.println("Invalid Username & Password!");
            }
         }
    }


}
