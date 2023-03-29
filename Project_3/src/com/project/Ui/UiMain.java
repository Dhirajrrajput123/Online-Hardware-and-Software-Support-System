package com.project.Ui;

import java.sql.SQLException;

import com.project.Dao.DBUtils;
import java.util.*;
public class UiMain {

	static void hodlogin(Scanner sc) {
		sc.nextLine();
		System.out.println("Enter HOD Id");
		String Id=sc.nextLine();
		System.out.println("enter HOD password");
		String password=sc.nextLine();
		if(Id.equals("admin") && password.equals("admin")) {
			System.out.println("Welcome Dhiraj");
		    AdminUi.welcomeAdmin(sc);
		}else {
			System.out.println("Please try again latter");
		}
	}
		//Engineer Signin
		
		static void Engineerlogin(Scanner sc) {
			sc.nextLine();
			System.out.println("Enter Engineer Username");
			String username=sc.nextLine();
			System.out.println("enter Enginner password");
			String password=sc.nextLine();		
		     
			EngineerUi.welcomeEngineer(sc,username);
	}
		
		//Employee signin
		static void Employeelogin(Scanner sc) {
			sc.nextLine();
			System.out.println("Enter Engineer Username");
			String employeename=sc.nextLine();
			System.out.println("enter Enginner password");
			String password=sc.nextLine();	
			EmployeeUi.welcomeEmployee(sc,employeename);
	}
		static void registerEmployee(Scanner sc) {
			System.out.println("you are inside the register ");
		}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int choice=0;
		do {
			System.out.println("----------------------------------------------\n"+
					           "| 1: HOD                                     |\n"+
					           "| 2: Engineer                                |\n"+
					           "| 3: Employee Signin                         |\n"+
					           "| 4: Employee Register                       |\n"+
					           "| 0: Exit                                    |\n"+
					           "----------------------------------------------");
			choice=sc.nextInt();
			switch(choice) {
			case 1:
				hodlogin(sc);
				break;
			case 2:
				Engineerlogin(sc);
				break;
			case 3:
				Employeelogin(sc);
				break;
			case 4:
				registerEmployee(sc);
				break;	
			case 0:
				System.out.println("thanks our services");
				break;
			default:
				System.out.println("enter the balid number");
			}
			
		}while(choice!=0);
        sc.close();
	}

}
