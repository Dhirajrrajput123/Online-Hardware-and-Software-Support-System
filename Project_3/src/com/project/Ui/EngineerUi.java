package com.project.Ui;

import java.util.Scanner;

public class EngineerUi {

	
	static void menu() {
		System.out.println("-----------------------------------------------------------\n"+
		                   "| 1: View the problem assigned to him by HOD              |\n"+
		                   "| 2: Update the status of the problem addressed by him    |\n"+
		                   "| 3: see list of all the problems attended by him/her     |\n"+
		                   "| 4: change his password                                  |\n"+
		                   "| 0: Exit                                                 |\n"+
		                   "-----------------------------------------------------------");
	}
	public static void welcomeEngineer(Scanner sc,String user) {
		int choice=0;
		do {
			EngineerUi.menu();
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
