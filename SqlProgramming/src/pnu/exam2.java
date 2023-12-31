package pnu;

import java.sql.*;


public class exam2 {
	public static void main(String[] args) {
		Connection con = null;
		
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/world";
			String username = "scott";
			String password = "tiger";
			
			Class.forName(driver);
			con = DriverManager.getConnection(url,username,password);
			
			
			
			String str = "select city.Name, city.population from city where city.Countrycode = \"KOR\" "
					+ "order by city.population DESC "
					+ "limit 10";
			String del = "\t";
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(str);
			
			showData(con, str);
					
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void showData(Connection con, String str) throws Exception {
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(str);
		ResultSetMetaData rsmd = rs.getMetaData();
		int count = rsmd.getColumnCount();
		
		for (int i = 1; i <= count; i++) {
			System.out.print(String.format("%s" + "\t",  rsmd.getColumnName(i)));
		}
		System.out.println();
		
		while(rs.next()) {
			System.out.print(String.format("%s" + "\t", rs.getString("Name") ));
			System.out.print(String.format("%d" + "\t", rs.getInt("population") ));
			System.out.println("");
		}
		
		rs.close();
		st.close();
	}
}
