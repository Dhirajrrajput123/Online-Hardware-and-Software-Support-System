package com.project.Dao;

import java.util.List;
import java.util.Scanner;

import com.project.Dto.ProblemDtoImple;
import com.project.Dto.employeeDtoimple;
import com.project.Exception.NoresultFound;
import com.project.Exception.SomethingwentWent;

public interface ProblemDao {

	public List<ProblemDtoImple> viewAllProblem() throws SomethingwentWent,NoresultFound;  
	public void updateProblem() throws SomethingwentWent;
	public void addProblem(ProblemDtoImple problemDto) throws SomethingwentWent;
	
	public List<ProblemDtoImple> seeAllProblemAssignbyEmployee() throws SomethingwentWent,NoresultFound; 
	public void changeEmpPassword(String newPass,Scanner sc) throws SomethingwentWent;
	
	public String SeeProblemStatus(int pid) throws SomethingwentWent;
	
	public void updateProblemStatus(int pid) throws SomethingwentWent, NoresultFound;
	
}
