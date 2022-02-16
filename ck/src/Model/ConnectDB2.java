package Model;


import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class ConnectDB2 {
	Connection conn;
	Statement stmt;
	ResultSet rs;
	PreparedStatement ps;
	public Connection connect(){
		try {
			 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	            String connectionURL = "jdbc:sqlserver://DESKTOP-VSP7AT1\\SQLEXPRESS:1434;database=Quanlythuenha;user=sa;password=034593478221it324";
	            conn = DriverManager.getConnection(connectionURL);
			System.out.println("Connected...");
		} catch (Exception e) {
			System.out.println("Failed...");
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void closeConnection(Connection con) {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
public int executeDB2(String sql) { //insert, update, delete
	int record2=0;
	try {
		connect();
		stmt = conn.createStatement();
		record2 = stmt.executeUpdate(sql); //so luong hang thay doi sau khi thuc hien 1 trong 3 cau lenh tren
	
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	finally {
		try {
			conn.close();
			stmt.close();
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
	}
	return record2;
}

public ResultSet Listcustomer(String sql) {
	try {
		connect();
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	finally {
		try {
			//conn.close();
			//stmt.close();
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
	}
	return rs;

}


}






