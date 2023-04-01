package com.project.Dao;

import com.project.Dto.employeeDtoimple;
import com.project.Exception.NoresultFound;
import com.project.Exception.SomethingwentWent;

public interface EmployeeDao {

	public void addEmployee(employeeDtoimple emp) throws SomethingwentWent;
	public void EmployeeLoginAccout(employeeDtoimple empDto) throws SomethingwentWent, NoresultFound;
}
