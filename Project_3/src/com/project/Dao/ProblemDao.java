package com.project.Dao;

import java.util.List;

import com.project.Dto.ProblemDtoImple;
import com.project.Exception.NoresultFound;
import com.project.Exception.SomethingwentWent;

public interface ProblemDao {

	public List<ProblemDtoImple> viewAllProblem() throws SomethingwentWent,NoresultFound;  
	public void updateProblem() throws SomethingwentWent;
	
}
