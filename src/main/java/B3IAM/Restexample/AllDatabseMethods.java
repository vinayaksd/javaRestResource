package B3IAM.Restexample;

import java.sql.Connection;


import com.mysql.jdbc.Statement;

public class AllDatabseMethods {
	
	public Connection con = serviceRest.connect();
	public String createTableStuds(int id, String name, String courses,int age,String college) {
		
		String createsql="create table students(id int,name varchar(255),"
				+ "courses varchar(255),age int,college varchar(255)";
		
		Statement st = con.createStatement();
		
		return null;
		
	}
}
