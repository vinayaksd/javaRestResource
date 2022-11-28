package B3IAM.Restexample;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


public class serviceRest {
	
	
	public static Connection connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/restdb","root","abc123");
            return c;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            return null;
        }
    }
}
