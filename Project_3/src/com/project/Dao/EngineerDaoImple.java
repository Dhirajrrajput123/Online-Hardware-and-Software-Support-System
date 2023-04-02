package com.project.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.Dto.EngineerDtoImpl;
import com.project.Dto.EngineerWithNumberOgProblem;
import com.project.Dto.ProblemDtoImple;
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
		}finally {
			try {
				DBUtils.closeconnection(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
		}finally {
			try {
				DBUtils.closeconnection(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
			
			if(rs>0) {
				
			}else {
				throw new SomethingwentWent("Engineer Not Present");
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingwentWent("Some thing went wrong");
		}finally {
			try {
				DBUtils.closeconnection(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void loginEngineer(EngineerDtoImpl engDto) throws SomethingwentWent {
		// TODO Auto-generated method stub
		
		 Connection con=null;
			
			try {
				con=DBUtils.get_connection();
				String query="select Enid from engineer where username=? and password=? ";
				PreparedStatement ps=con.prepareStatement(query);
				ps.setString(1, engDto.getUsername());
				ps.setString(2, engDto.getPassword());
				
				ResultSet rs=ps.executeQuery();
				if(DBUtils.isRowPresent(rs)) {
					throw new SomethingwentWent("Enter correct Username and Password");
				}
				else {
					rs.next();
					StaticVariable.engineer__Id=rs.getString(1);
				}
				
				
			} catch (ClassNotFoundException | SQLException e) {
				throw new SomethingwentWent("Some thing went wrong");
			}finally {
				try {
					DBUtils.closeconnection(con);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		
	}

	@Override
	public List<ProblemDtoImple> assignEngineerProblem() throws SomethingwentWent, NoresultFound {
		// TODO Auto-generated method stub
		
		
		List<ProblemDtoImple> list=new ArrayList<>();
		Connection con=null;
		
		try {
			con=DBUtils.get_connection();
			String query="select * from Problem where Enid=? and pstatus=0";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, StaticVariable.engineer__Id);
			ResultSet rs=ps.executeQuery();
			if(DBUtils.isRowPresent(rs)) {
				throw new NoresultFound("No result found");
			}
			else {
				while(rs.next()) {
					list.add(new ProblemDtoImple(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),rs.getInt(6)));
				}
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingwentWent("Some thing went wrong");
		}finally {
			try {
				DBUtils.closeconnection(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public List<ProblemDtoImple> AllProblemAttend() throws SomethingwentWent, NoresultFound {
		// TODO Auto-generated method stub
		List<ProblemDtoImple> list=new ArrayList<>();
		Connection con=null;
		
		try {
			con=DBUtils.get_connection();
			String query="select * from Problem where Enid=? ";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, StaticVariable.engineer__Id);
			ResultSet rs=ps.executeQuery();
			if(DBUtils.isRowPresent(rs)) {
				throw new NoresultFound("No result found");
			}
			else {
				while(rs.next()) {
					list.add(new ProblemDtoImple(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),rs.getInt(6)));
				}
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingwentWent("Some thing went wrong");
		}
		finally {
			try {
				DBUtils.closeconnection(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public void updateEngineerPassword(String newpass) throws SomethingwentWent {
		
        Connection con=null;
		
		try {
			con=DBUtils.get_connection();
			String query="update engineer set password=? where Enid=? ";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, newpass);
			ps.setString(2, StaticVariable.engineer__Id);
			ps.executeLargeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingwentWent("Some thing went wrong");
		}
		finally {
			try {
				DBUtils.closeconnection(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<EngineerWithNumberOgProblem> AssignProblemToEngineer() throws SomethingwentWent, NoresultFound {
		// TODO Auto-generated method stub
		
		List<EngineerWithNumberOgProblem> list=new ArrayList<>();
		Connection con=null;
		try {
			con=DBUtils.get_connection();
			String query="select e.Enid,count(Pid) from engineer e left join problem p on e.Enid=p.Enid group by  e.Enid";
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			if(DBUtils.isRowPresent(rs)) {
				throw new NoresultFound("No data Present");
			}
			else {
				while(rs.next()) {
					list.add(new EngineerWithNumberOgProblem(rs.getString(1), rs.getInt(2)));
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingwentWent("something went wrong");
		}finally {
			try {
				DBUtils.closeconnection(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
		
	}

	@Override
	public void ProblemAssigntoEngineer(String ENid,int pid) throws SomethingwentWent {
		// TODO Auto-generated method stub
		Connection con=null;
		try {
			con=DBUtils.get_connection();
			String query="update problem  set Enid=? where pid=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, ENid);
			ps.setInt(2, pid);
			int res=ps.executeUpdate();
			if(res>0) {
				
			}else {
				throw new SomethingwentWent("Enter correct Engineer ID and Problem Id ");
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingwentWent("something went wrong");
		}
	}

	@Override
	public boolean confirmpassword(EngineerDtoImpl engDto) throws SomethingwentWent {
		
		
		    Connection con=null;
			
			try {
				con=DBUtils.get_connection();
				String query="select Enid from engineer where username=? and password=? ";
				PreparedStatement ps=con.prepareStatement(query);
				ps.setString(1, engDto.getUsername());
				ps.setString(2, engDto.getPassword());
				
				ResultSet rs=ps.executeQuery();
				if(DBUtils.isRowPresent(rs)) {
					return false;
				}
				else {
					return true;
				}
				
				
			} catch (ClassNotFoundException | SQLException e) {
				throw new SomethingwentWent("Some thing went wrong");
			}finally {
				try {
					DBUtils.closeconnection(con);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}

}
