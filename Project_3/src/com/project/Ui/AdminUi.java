package com.project.Ui;

import java.util.List;
import java.util.Scanner;

import com.project.Dao.EngineerDaoImple;
import com.project.Dao.ProblemDaoImple;
import com.project.Dto.EngineerDtoImpl;
import com.project.Dto.ProblemDtoImple;
import com.project.Exception.NoresultFound;
import com.project.Exception.SomethingwentWent;

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
				   addnewEngineer(sc);
				   break;
			   case 2:
				   displayEngineer();
				   break;
			   case 3:
				   deleteEngineer(sc);
				   break;
			   case 4:
				   ViewAllRiseProblem();
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
	
	public static void ViewAllRiseProblem() {
		
		ProblemDaoImple probdao=new ProblemDaoImple();
		
	    try {
			List<ProblemDtoImple> list=probdao.viewAllProblem();
			list.forEach(System.out::println);
		} catch (SomethingwentWent | NoresultFound e1) {
			System.out.println(e1.getMessage());
		}
	}
	
	public static void deleteEngineer(Scanner sc) {
		EngineerDaoImple engDao=new EngineerDaoImple();
	    try {
	    	sc.nextLine();
	    	System.out.println("Enter Engineer ID");
	    	String ENid=sc.nextLine();
	    	engDao.deleteEngineer(ENid);
			System.out.println("Engineer deleted successfully");
		} catch (SomethingwentWent  e1) {
			System.out.println(e1.getMessage());
		}
	}
	public static void displayEngineer() {
		EngineerDaoImple engDao=new EngineerDaoImple();
	    try {
			List<EngineerDtoImpl> list=engDao.display_eng();
			list.forEach(System.out::println);
		} catch (SomethingwentWent | NoresultFound e1) {
			System.out.println(e1.getMessage());
		}
	}
	
	
	
	//Engineer Added successfully
	public static void addnewEngineer(Scanner sc) {
		sc.nextLine();
		System.out.println("Enter Engineer ID");
		String Eid=sc.nextLine();
		System.out.println("Enter Engineer User Name");
		String username=sc.nextLine();
		System.out.println("Enter Engineer Password");
		String password=sc.nextLine();
		System.out.println("Category of Engineer S/H");
		String category=sc.nextLine();
		
		EngineerDtoImpl engdto=new EngineerDtoImpl(Eid, username, password, category);
	    EngineerDaoImple engDao=new EngineerDaoImple();
	    try {
			engDao.addEngineer(engdto);
			System.out.println("Engineer added successfully");
		} catch (SomethingwentWent e) {
			System.out.println(e.getMessage());;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
