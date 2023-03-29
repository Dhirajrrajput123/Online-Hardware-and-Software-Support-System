package com.project.Ui;

import java.util.Scanner;

public class EmployeeUi {

	static void menu() {
		System.out.println("---------------------------------------------------------------------------\n"+
		                   "| 1: Register any complain (hardware / software ) through the system.     |\n"+
		                   "| 2: See the status of their problem by using complain id                 |\n"+
		                   "| 3: See all complain history raised by him/her                           |\n"+
		                   "| 4: change his password                                                  |\n"+
		                   "| 0: Exit                                                                 |\n"+
		                   "---------------------------------------------------------------------------");
	}
	public static void welcomeEmployee(Scanner sc,String user) {
		int choice=0;
		do {
			EmployeeUi.menu();
			choice=sc.nextInt();
			switch(choice) {
			   case 1:
				   break;
			   case 2:
				   break;
			   case 3:
				   break;
			   case 4:
				   break;
			   case 0:
				   System.out.println("Thanks "+user);
				   break;  
				default:
					System.out.println("Enter valid Number");
			
			}
		}while(choice!=0);
	}
}
