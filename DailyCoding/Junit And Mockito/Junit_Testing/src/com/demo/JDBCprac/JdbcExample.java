package com.demo.JDBCprac;
import java.sql.*;

public class JdbcExample {
	
	public static void main(String[] args) {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scott","aakash","qwe");
		
		Statement stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery("select * from emp where job='clerk'");
		int code;
		String title;
		String job;
		while(rs.next()) {
			code = rs.getInt(1);
			title = rs.getString(2);
			job = rs.getString(3);
			
			System.out.println(code+" "+title+" "+job);
		
		}
		int update = stmt.executeUpdate("update emp set sal=sal+1000 where job='clerk'");
		System.out.println(update+" rows updated");
		
		int delete = stmt.executeUpdate("delete from emp where job='clerk' and sal>2000");
		System.out.println(delete+" rows deleted");
		
		//insert
		int insert = stmt.executeUpdate("insert into emp values(1234,'aakash','clerk',1000)");
		System.out.println(insert+" rows inserted");
		 con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
