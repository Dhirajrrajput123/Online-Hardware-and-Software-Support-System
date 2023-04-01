package com.project.Ui;

import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

import com.project.Dao.EmployeeDaoImple;
import com.project.Dao.ProblemDaoImple;
import com.project.Dao.StaticVariable;
import com.project.Dto.ProblemDtoImple;
import com.project.Dto.employeeDtoimple;
import com.project.Exception.NoresultFound;
import com.project.Exception.SomethingwentWent;

public class EmployeeUi {

	static void menu() {
		System.out.println("---------------------------------------------------------------------------\n"+
		                   "| 1: Register any complain (hardware / software ) through the system.     |\n"+
		                   "| 2: See the status of their problem by using complain id                 |\n"+
		                   "| 3: See all complain history raised by him/her                           |\n"+
		                   "| 4: change his password                                                  |\n"+
		                   "| 0: Log Out                                                              |\n"+
		                   "---------------------------------------------------------------------------");
	}
	public static void welcomeEmployee(Scanner sc,String user) {
		int choice=0;
		do {
			EmployeeUi.menu();
			choice=sc.nextInt();
			switch(choice) {
			   case 1:
				   addproblem(sc);
				   break;
			   case 2:
				   seeTheProblemStatus(sc);
				   break;
			   case 3:
				   seeAlltheProblem();
				   break;
			   case 4:
				   changePassword(sc);
				   break;
			   case 0:
				   StaticVariable.employee__Id=0;
				   System.out.println("Thanks "+user);
				   break;  
				default:
					System.out.println("Enter valid Number");
			
			}
		}while(choice!=0);
	}
	
	//see the problem Status
	public static void seeTheProblemStatus(Scanner sc) {
		System.out.println("Enter Problem ID");
		int pid=sc.nextInt();
		
		ProblemDaoImple ps=new ProblemDaoImple();
		try {
			String res=ps.SeeProblemStatus(pid);
			System.out.println(res);
		} catch (SomethingwentWent e) {
			System.out.println(e.getMessage());
		}
	}
	//change password
	public static void changePassword(Scanner sc) {
		sc.nextLine();
		System.out.println("Enter your New Password");
		String newpass=sc.nextLine();
		ProblemDaoImple probDao=new ProblemDaoImple();
		try {
//			System.out.println(StaticVariable.employee__Id);
			probDao.changeEmpPassword(newpass,sc);
			System.out.println("Password Updated");
		} catch (SomethingwentWent e) {
			System.out.println(e.getMessage());
		}
	}
	
	//this method for to see the Problem rise by employee
	public static void seeAlltheProblem() {
		ProblemDaoImple probDao=new ProblemDaoImple();
		try {
			List<ProblemDtoImple> list=probDao.seeAllProblemAssignbyEmployee();
			Consumer< ProblemDtoImple> obj=prob->{
				String ans=" Problem Id "+ prob.getpID()+",  ProblemName=  " + prob.getProblemName() + ", category=" + prob.getCategory() + ", pstatus=" + prob.getPstatus()
						+ ", Enid=" + prob.getEnid() + ", empid=" + prob.getEmpid() ;
				System.out.println(ans);
			};
			list.forEach(obj);
		} catch (SomethingwentWent | NoresultFound e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	//This method add the problem into problem table
	public static void addproblem(Scanner sc) {
		
	   sc.nextLine();
	   System.out.println("Entet problem name");
	   String pname=sc.nextLine();
	   System.out.println("Enter Problem Category S/H(Software and Hardware)");
	   String pcategory=sc.nextLine();
	   ProblemDtoImple problemDto=new ProblemDtoImple(pname, pcategory);
	  
	   ProblemDaoImple probDao=new ProblemDaoImple();
	   try {
		probDao.addProblem(problemDto);
		System.out.println("Problem added successfully");
	   } catch (SomethingwentWent e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
	  }
	   
	}
	
	public static void confirmPassword(Scanner sc) throws SomethingwentWent, NoresultFound {
//		sc.nextLine();
		System.out.println("Enter your Username");
		String username=sc.nextLine();
		System.out.println("Enter your old password");
		String OldPass=sc.nextLine();
		employeeDtoimple empdto=new employeeDtoimple(username, OldPass);
		EmployeeDaoImple empdao=new EmployeeDaoImple();
		empdao.EmployeeLoginAccout(empdto);
		
		
	}
}




















