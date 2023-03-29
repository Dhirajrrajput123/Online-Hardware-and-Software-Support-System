package com.project.Ui;

import java.util.Scanner;

public class AdminUi {
     
	static void menu() {
		System.out.println("----------------------------------------------\n"+
		                   "| 1: Register new Engineer                   |\n"+
		                   "| 2: Display all Engineer                    |\n"+
		                   "| 3: Delete a Engineer                       |\n"+
		                   "| 4: see all the raised problem.             |\n"+
		                   "| 5: assign any problem to any Engineer.     |\n"+
		                   "| 0: Exit                                    |\n"+
		                   "----------------------------------------------");
	}
	public static void welcomeAdmin(Scanner sc) {
		int choice=0;
		do {
			AdminUi.menu();
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
			   case 5:
				   break;
			   case 0:
				   System.out.println("Thanks Dhiraj");
				   break;  
				default:
					System.out.println("Enter valid Number");
			
			}
		}while(choice!=0);
	}
}
