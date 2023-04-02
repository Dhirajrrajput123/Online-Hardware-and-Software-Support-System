package com.project.Ui;

import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

import com.project.Dao.DBUtils;
import com.project.Dao.EngineerDaoImple;
import com.project.Dao.ProblemDaoImple;
import com.project.Dao.StaticVariable;
import com.project.Dto.EngineerDtoImpl;
import com.project.Dto.ProblemDtoImple;
import com.project.Exception.NoresultFound;
import com.project.Exception.SomethingwentWent;

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
				   EngineerAssignProblem();
				   break;
			   case 2:
				   updateProblemStatus(sc);
				   break;
			   case 3:
				   AllProblemAttendByEngineer();
				   break;
			   case 4:
				   changeEngineerPassword(sc);
				   break;
			   case 0:
				   System.out.println("Thanks "+user);
				   StaticVariable.engineer__Id="0";
				   break;  
				default:
					System.out.println("Enter valid Number");
			
			}
		}while(choice!=0);
	}
	
	public static void updateProblemStatus(Scanner sc) {
		sc.nextLine();
		System.out.println("Enter the Problem Id number");
		int Pid=sc.nextInt();
		ProblemDaoImple probDao=new ProblemDaoImple();
		try {
			probDao.updateProblemStatus(Pid);
			System.out.println("Problem Status update successfully");
		} catch (SomethingwentWent | NoresultFound e) {
			System.out.println(e.getMessage());
		}
	}
	//update the password
	public static void changeEngineerPassword(Scanner sc) {
		EngineerDaoImple engdao=new EngineerDaoImple();
		sc.nextLine();
		System.out.println("Enter Engineer Username");
		String username=sc.nextLine();
		System.out.println("enter Enginner password");
		String password=sc.nextLine();		
	    EngineerDtoImpl engDto=new EngineerDtoImpl(username, password);
		try {
			boolean res=engdao.confirmpassword(engDto);
			if(res) {
			System.out.println("Enter new Password");
			String newpass=sc.nextLine();
			engdao.updateEngineerPassword(newpass);
			System.out.println("Password change successfully");
			}
			else {
				System.out.println("Please Enter correct details");
			}
		} catch (SomethingwentWent e) {
			System.out.println(e.getMessage());
		};
	}
	//SEE list of all the Proble
	public static void AllProblemAttendByEngineer() {
		
        EngineerDaoImple engdao=new EngineerDaoImple();
		
		try {
			List<ProblemDtoImple> list= engdao.AllProblemAttend();
			Consumer< ProblemDtoImple> obj=prob->{
				System.out.println(" Problem id "+prob.getpID()+"  ProblemName= " + prob.getProblemName() + ",  category=" + prob.getCategory() + ",  pstatus=" + prob.getPstatus()
				+ ",  Enid=" + prob.getEnid() + ",  empid=" + prob.getEmpid() );
			};
			list.forEach(obj);
		} catch (SomethingwentWent | NoresultFound e) {
			System.out.println(e.getMessage());
		}
		
	}
	//new problem assign 
	public static void EngineerAssignProblem() {
		
		EngineerDaoImple engdao=new EngineerDaoImple();
		
		try {
			List<ProblemDtoImple> list= engdao.assignEngineerProblem();
			Consumer< ProblemDtoImple> obj=prob->{
				System.out.println(" Problem id "+prob.getpID()+"  ProblemName= " + prob.getProblemName() + ",  category=" + prob.getCategory() + ",  pstatus=" + prob.getPstatus()
				+ ",  Enid=" + prob.getEnid() + ",  empid=" + prob.getEmpid() );
			};
			list.forEach(obj);
		} catch (SomethingwentWent | NoresultFound e) {
			System.out.println(e.getMessage());
		}
	}
}












