package com.project.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.Dto.EngineerDtoImpl;
import com.project.Exception.NoresultFound;
import com.project.Exception.SomethingwentWent;

public class EngineerDaoImple implements EngineerDao {

	@Override
	public void addEngineer(EngineerDtoImpl eng) throws SomethingwentWent {
		// TODO Auto-generated method stub
		Connection con=null;
		
		try {
			con=DBUtils.get_connection();
			String query="insert into engineer values (?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, eng.getEnid());
			ps.setString(2, eng.getUsername());
			ps.setString(3, eng.getPassword());
			ps.setString(4, eng.getCategory());
			int res=ps.executeUpdate();
			if(res>0) {
				
			}
			else {
				throw new SomethingwentWent("input missmatch");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			throw new SomethingwentWent("Some thing went wrong");
		}
	}

	@Override
	public List<EngineerDtoImpl> display_eng() throws SomethingwentWent, NoresultFound {
		List<EngineerDtoImpl> list=new ArrayList<>();
		Connection con=null;
		
		try {
			con=DBUtils.get_connection();
			String query="select * from engineer";
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			if(DBUtils.isRowPresent(rs)) {
				throw new NoresultFound("No result found");
			}
			else {
				while(rs.next()) {
					list.add(new EngineerDtoImpl(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
				}
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingwentWent("Some thing went wrong");
		}
		
		return list;
	}

	@Override
	public void deleteEngineer(String ENid) throws SomethingwentWent {
		// TODO Auto-generated method stub
        Connection con=null;
		
		try {
			con=DBUtils.get_connection();
			String query="delete from engineer where Enid=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, ENid);
			int rs=ps.executeUpdate();
			
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingwentWent("Some thing went wrong");
		}
	}

}
