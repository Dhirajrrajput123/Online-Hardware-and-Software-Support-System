package com.project.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.Dto.EngineerDtoImpl;
import com.project.Dto.ProblemDtoImple;
import com.project.Exception.NoresultFound;
import com.project.Exception.SomethingwentWent;

public class ProblemDaoImple implements ProblemDao {

	@Override
	public List<ProblemDtoImple> viewAllProblem() throws SomethingwentWent, NoresultFound {
		// TODO Auto-generated method stub
		List<ProblemDtoImple> list=new ArrayList<>();
		Connection con=null;
		
		try {
			con=DBUtils.get_connection();
			String query="select problem_name,category,pstatus,Enid,empid from problem";			
			
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			if(DBUtils.isRowPresent(rs)) {
				throw new NoresultFound("No result found");
			}
			else {
				while(rs.next()) {
					list.add(new ProblemDtoImple(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5)));
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingwentWent("Some thing went wrong");
		}
		
		return list;
	}

	@Override
	public void updateProblem() throws SomethingwentWent {
        Connection con=null;
		
		try {
			con=DBUtils.get_connection();
					
			
//			PreparedStatement ps=con.prepareStatement(query);
			
//			ps.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingwentWent("Some thing went wrong");
		}
		
	}

}
