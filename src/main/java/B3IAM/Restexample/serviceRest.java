package B3IAM.Restexample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


public class serviceRest {
	public static Connection c;
	
	public static Connection connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/restdb?enabledTLSProtocols=TLSv1.2","root","abc123");
           return c;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            return null;
        }
	} 
        public void insert(int id,String name,int sal,int dep,int mgr){
        	
    		try {
    			System.out.println("inside inserting....");
       		 int bonus=sal*15/100;
       		String sql="insert into Emps values(?,?,?,?,?,?)";
       		PreparedStatement ps;
    			ps = c.prepareStatement(sql);
    			ps.setInt(1, id);
    			ps.setString(2, name);
    			ps.setInt(3, sal);
    			ps.setInt(4, bonus);
    			ps.setInt(5, dep);
    			ps.setInt(6, mgr);
    			ps.execute();
    		} 
    		catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	}
		public void createtbStudents(int id, String name, String courses, int age) {
			try {
				String sql ="create table students(id int,name varchar(255),"
				PreparedStatement ps;
				
				
			}
			catch(Exception e) {
				
			}
			
		}
    }

