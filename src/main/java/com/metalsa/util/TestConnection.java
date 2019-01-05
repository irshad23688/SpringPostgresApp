package com.metalsa.util;
import com.metalsa.domain.MmrSubClassMasterUt;


public class TestConnection {
	public static void main(String[] s) {
		/*try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS=(HOST=130.61.80.158)\r\n" + 
							"					(PORT=1521)(PROTOCOL=tcp))(CONNECT_DATA=\r\n" + 
							"					(SID=etplnew)))","metalsa","ETpl_2018#");  
			System.out.println(con.isClosed());  
			con.close();
			System.out.println(con.isClosed());  

		}catch(Exception e){ System.out.println(e);}  */
		JsonCreator.createJson(new MmrSubClassMasterUt());


	}

}
