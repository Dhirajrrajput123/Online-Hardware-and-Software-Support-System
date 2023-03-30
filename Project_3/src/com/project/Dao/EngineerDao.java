package com.project.Dao;

import java.util.List;

import com.project.Dto.EngineerDtoImpl;
import com.project.Exception.NoresultFound;
import com.project.Exception.SomethingwentWent;

public interface EngineerDao {
      public void addEngineer(EngineerDtoImpl eng) throws SomethingwentWent;
      public List<EngineerDtoImpl> display_eng() throws SomethingwentWent,NoresultFound;
      public void deleteEngineer(String ENid) throws SomethingwentWent;
}
