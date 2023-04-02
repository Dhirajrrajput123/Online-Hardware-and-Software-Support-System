package com.project.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;
import com.project.Dto.EngineerDtoImpl;
import com.project.Dto.ProblemDtoImple;
import com.project.Dto.employeeDtoimple;
import com.project.Exception.NoresultFound;
import com.project.Exception.SomethingwentWent;
import com.project.Ui.EmployeeUi;

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
	public void updateProblem() throws SomethingwentWent {
        Connection con=null;
		
		try {
			con=DBUtils.get_connection();
					
			
//			PreparedStatement ps=con.prepareStatement(query);
			
//			ps.executeUpdate();
			
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
	public void addProblem(ProblemDtoImple problemDto) throws SomethingwentWent {
		// TODO Auto-generated method stub
		
		 Connection con=null;
			
			try {
				con=DBUtils.get_connection();
				String query="insert into problem (problem_name,category,pstatus,Enid,empid) values (?,?,?,?,?)";
				PreparedStatement ps=con.prepareStatement(query);
				ps.setString(1, problemDto.getProblemName());
				ps.setString(2, problemDto.getCategory());
				ps.setInt(3, problemDto.getPstatus());
				ps.setString(4, problemDto.getEnid());
				ps.setInt(5, problemDto.getEmpid());
                
				ps.executeUpdate();
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
	public List<ProblemDtoImple> seeAllProblemAssignbyEmployee() throws SomethingwentWent, NoresultFound {
		List<ProblemDtoImple> list=new ArrayList<>();
		Connection con=null;
		
		try {
			con=DBUtils.get_connection();
			String query="select * from problem  where empid=?";			
			
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, StaticVariable.employee__Id);
			ResultSet rs=ps.executeQuery();
			if(DBUtils.isRowPresent(rs)) {
				throw new NoresultFound("No result found");
			}
			else {
				while(rs.next()) {
					list.add(new ProblemDtoImple(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6)));
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
	public void changeEmpPassword(String newPass,Scanner sc) throws SomethingwentWent {
		// TODO Auto-generated method stub
		
        Connection con=null;
		
		try {
			con=DBUtils.get_connection();

			String query="update employee set password=? where empid=?";			
			
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, newPass);
			ps.setInt(2, StaticVariable.employee__Id);
			try {
				EmployeeUi.confirmPassword(sc);
				ps.executeUpdate();
			} catch (SomethingwentWent | NoresultFound e) {
				throw new SomethingwentWent("Plese enter correct old password");
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
	public String SeeProblemStatus(int pid) throws SomethingwentWent {
		// TODO Auto-generated method stub
		Connection con=null;
		
		try {
			con=DBUtils.get_connection();
			String query="select * from problem where pid=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, pid);
			ResultSet rs=ps.executeQuery();
			if(DBUtils.isRowPresent(rs)) {
				throw new SomethingwentWent("No problem Present in this problem id");
				
			}
			else {
				
				rs.next();
				if(rs.getString(4).equals("0")) {
					return "Your Problem resolve Soon";
				}
				else if(rs.getString(4).equals("1")) {
					return "Problem resolve successfully";
				}
				else {
					return "Your Problem is in prograss";
				}
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingwentWent("Something went wrong");
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
	public void updateProblemStatus(int pid) throws SomethingwentWent,NoresultFound {
		
        Connection con=null;
		
		try {
			con=DBUtils.get_connection();
			String query="update problem set pstatus=1 where pid=? and Enid=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, pid);
			ps.setString(2, StaticVariable.engineer__Id);
			int n=ps.executeUpdate();
			if(n==0) {
				throw new NoresultFound("no query present ");
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingwentWent("Something went wrong");
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
