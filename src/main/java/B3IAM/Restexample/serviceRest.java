package B3IAM.Restexample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class serviceRest {
	public static Connection c;

	public static Connection connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/restdb?enabledTLSProtocols=TLSv1.2&useSSL=false", "root", "abc123");
			return c;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	public void insert(int id, String name, int sal, int dep, int mgr) {

		try {
			System.out.println("inside inserting....");
			int bonus = sal * 15 / 100;
			String sql = "insert into Emps values(?,?,?,?,?,?)";
			PreparedStatement ps;
			ps = c.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setInt(3, sal);
			ps.setInt(4, bonus);
			ps.setInt(5, dep);
			ps.setInt(6, mgr);
			ps.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void createTable(String tableName, String[] col) {

		try {

			String sql = "create table " + tableName + "(";

			for (int i = 0; i < col.length; i++) {

				if (col[i].contains("id")) {

					if (i < col.length - 1) {
						sql += "id int,";
					}

					else
						sql += "id int)";
				}

				else {
					if (i < col.length - 1)
						sql += col[i] + " varchar(225),";
					else
						sql += col[i] + " varchar(225))";
				}
			}
			System.out.println(sql);
			Statement st = c.createStatement();
			st.execute(sql);

		} catch (Exception e) {
			e.getMessage();
		}

	}

	public void insert_Emps(Emps e) {
		try {
			System.out.println("inside inserting....");
			e.bonus = e.sal * 15 / 100;
			String sql = "insert into Emps values(?,?,?,?,?,?)";
			PreparedStatement ps;
			ps = c.prepareStatement(sql);
			ps.setInt(1, e.id);
			ps.setString(2, e.name);
			ps.setDouble(3, e.sal);
			ps.setDouble(4, e.bonus);
			ps.setInt(5, e.depid);
			ps.setInt(6, e.manager_id);
			ps.execute();
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}

	public void insert_names(String values) {
		try {
			System.out.println("inside inserting....");

			String[] val = values.split("\n");

			String sql = "insert into names values(?,?)";
			PreparedStatement ps;
			ps = c.prepareStatement(sql);
			for(int i=0;i<val.length;i++) {
			ps.setInt(1, i);
			ps.setString(2, val[i]);
		
			ps.execute();
			}
		}

		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
