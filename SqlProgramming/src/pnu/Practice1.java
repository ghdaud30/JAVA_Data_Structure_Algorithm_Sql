package pnu;

import java.sql.*;

public class Practice1 {

	public static void main(String[] args) {
		Connection con = null;
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/world";
			String username = "scott";
			String password = "tiger";
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
			System.out.println("Connection success");
			
			String str = "select * from world.city, world.country, world.countrylanguage limit 10";
			String str1 = "select population from world.country , world.countrylanguage where Countrycode = \"KOR\" "
					+ "order by population DESC "
					+ "limit 10";
			String del = "\t";
			
			showData(con,"city");
			showData(con,"country");
			showData(con,"countrylanguage");
			
			showData1(con,str1);
			
		}catch (Exception e) {
			System.out.println("Connection failure : " + e.getMessage());
		}

	}
	private static void showData(Connection con, String tablename) throws Exception{
		String del = "\t";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(String.format("select * from %s limit 10",tablename));
		ResultSetMetaData rsmd = rs.getMetaData();
		int count = rsmd.getColumnCount();
		System.out.println(count);
		
		System.out.println("=".repeat(50));
		System.out.println("Table Name is " + tablename);
		System.out.println("=".repeat(50));
		
		for(int i = 1; i <= count; i++) {
			System.out.print(String.format("%-" + rsmd.getColumnDisplaySize(i) + "s", rsmd.getColumnName(i)));
		}
		System.out.println("");
		
		
		while(rs.next()) { 
			for(int j = 1; j <= count; j++) {
				System.out.print(String.format("%-" + rsmd.getColumnDisplaySize(j) + "s", rs.getString(j)));
			}
			System.out.println();
			
		}
		
		rs.close();
		st.close();
	}
	
	private static void showData1(Connection con, String str) throws Exception{
		String del = "\t";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(str);
		
		System.out.println("=".repeat(50));
		
		while(rs.next()) {
			System.out.println(String.format("%10d", rs.getInt("population")) + del);
		}
		
		rs.close();
		st.close();
	}
	
	
	
	
	
	
	
	

}