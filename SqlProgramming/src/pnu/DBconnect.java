package pnu;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnect {

	public static void main(String[] args) {
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://10.125.121.222:3306/world";
			String username = "scott";
			String password = "tiger";
			
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, username, password);
			
			System.out.println("Connection success");
			con.close();

		}catch (Exception e) {
			System.out.println("Connection failure : " + e.getMessage());
		}

	}

}
