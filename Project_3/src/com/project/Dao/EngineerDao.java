package com.project.Dao;

import java.util.List;

import com.project.Dto.EngineerDtoImpl;
import com.project.Dto.EngineerWithNumberOgProblem;
import com.project.Dto.ProblemDtoImple;
import com.project.Dto.employeeDtoimple;
import com.project.Exception.NoresultFound;
import com.project.Exception.SomethingwentWent;

public interface EngineerDao {
      public void addEngineer(EngineerDtoImpl eng) throws SomethingwentWent;
      public List<EngineerDtoImpl> display_eng() throws SomethingwentWent,NoresultFound;
      public void deleteEngineer(String ENid) throws SomethingwentWent;
      public void loginEngineer(EngineerDtoImpl engDto) throws SomethingwentWent;
      public List<ProblemDtoImple> assignEngineerProblem() throws SomethingwentWent,NoresultFound;
      public List<ProblemDtoImple> AllProblemAttend() throws SomethingwentWent,NoresultFound;
      public void updateEngineerPassword(String newpass) throws SomethingwentWent;
      public List<EngineerWithNumberOgProblem> AssignProblemToEngineer() throws SomethingwentWent,NoresultFound; 
      public void ProblemAssigntoEngineer(String ENid,int pid) throws SomethingwentWent;
      public boolean confirmpassword(EngineerDtoImpl engDto) throws SomethingwentWent;
}
