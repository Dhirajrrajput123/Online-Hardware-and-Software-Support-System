package com.project.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.Dto.employeeDtoimple;
import com.project.Exception.NoresultFound;
import com.project.Exception.SomethingwentWent;

public class EmployeeDaoImple  implements EmployeeDao{

	@Override
	public void addEmployee(employeeDtoimple emp) throws SomethingwentWent {
		
		Connection con=null;
		
		try {
			con=DBUtils.get_connection();
			String query="insert into employee (username,password) values(?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, emp.getName());
			ps.setString(2, emp.getPassword());
			ps.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingwentWent("Some thing wend wrong");
		}
		
	}

	@Override
	public void EmployeeLoginAccout(employeeDtoimple empDto) throws SomethingwentWent, NoresultFound {
		
        Connection con=null;
		
		try {
			con=DBUtils.get_connection();
			String query="select empid from employee where username=? and password=?";
			
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, empDto.getName());
			ps.setString(2, empDto.getPassword());
			
			ResultSet rs=ps.executeQuery();
			if(DBUtils.isRowPresent(rs)) {
				throw new NoresultFound("Enter correct username and password");
			}
			else {
				rs.next();
				StaticVariable.employee__Id=rs.getInt(1);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingwentWent("Some thing wend wrong");
		}
		
	}

}
