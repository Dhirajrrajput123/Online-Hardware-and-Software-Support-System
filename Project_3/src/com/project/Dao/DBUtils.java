package com.project.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtils {

	public static Connection get_connection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		ResourceBundle rs=ResourceBundle.getBundle("dbdetail");
		String url=rs.getString("url");
		String username=rs.getString("username");
		String password=rs.getString("password");
		Connection con=DriverManager.getConnection(url, username, password);
		return con; 
    }
	
	public static void closeconnection(Connection con) throws SQLException {
		if(con!=null) con.close();
	}
	
	public static boolean isRowPresent(ResultSet rs) throws SQLException {
		if(!rs.isBeforeFirst()&&rs.getRow()==0) {
			return true;
		}
		
		return false;
	}
}
