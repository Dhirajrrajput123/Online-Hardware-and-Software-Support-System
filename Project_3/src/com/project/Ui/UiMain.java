package com.project.Ui;

import java.sql.SQLException;

import com.project.Dao.DBUtils;
import com.project.Dao.EmployeeDaoImple;
import com.project.Dao.EngineerDaoImple;
import com.project.Dao.StaticVariable;
import com.project.Dto.EngineerDtoImpl;
import com.project.Dto.employeeDtoimple;
import com.project.Exception.NoresultFound;
import com.project.Exception.SomethingwentWent;

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
		    EngineerDtoImpl engDto=new EngineerDtoImpl(username, password);
		    EngineerDaoImple engDao=new EngineerDaoImple();
		    try {
				engDao.loginEngineer(engDto);
				System.out.println("Your Welcome ");
				EngineerUi.welcomeEngineer(sc,username);
			} catch (SomethingwentWent e) {
				System.out.println(e.getMessage());
			}
	}
		
		//Employee signin
		static void Employeelogin(Scanner sc) {
			sc.nextLine();
			System.out.println("Enter Employee Username");
			String employeename=sc.nextLine();
			System.out.println("enter Employee password");
			String password=sc.nextLine();	
			employeeDtoimple empDto=new employeeDtoimple(employeename, password);
		
			EmployeeDaoImple empDao=new EmployeeDaoImple();
			try {
				empDao.EmployeeLoginAccout(empDto);
				System.out.println("Log in successfully");
				
				EmployeeUi.welcomeEmployee(sc,employeename);
//				System.out.println(StaticVariable.employee__Id);
			} catch (SomethingwentWent | NoresultFound e) {
				System.out.println(e.getMessage());
			}
	}
		static void registerEmployee(Scanner sc) {
			
			sc.nextLine();
			System.out.println("Enter your Name");
			String username=sc.nextLine();
			System.out.println("Create your password");
			String password=sc.nextLine();
			employeeDtoimple emp=new employeeDtoimple(username, password);
			
			EmployeeDaoImple empDao=new EmployeeDaoImple();
			try {
				empDao.addEmployee(emp);
				System.out.println("Register successfully");
			} catch (SomethingwentWent e) {
				System.out.println(e.getMessage());			}
			
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
