package com.metalsa.util;
import java.sql.Connection;
import java.sql.DriverManager;


public class TestConnection {
	public static void main(String[] s) {
		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS=(HOST=130.61.80.158)\r\n" + 
							"					(PORT=1521)(PROTOCOL=tcp))(CONNECT_DATA=\r\n" + 
							"					(SID=etplnew)))","sys as sysdba","ETpl_2018#");  
			System.out.println(con.isClosed());  
			con.close();
			System.out.println(con.isClosed());  

		}catch(Exception e){ System.out.println(e);}  


	}

}
