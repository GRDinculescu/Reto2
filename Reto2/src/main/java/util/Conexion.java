package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	
	public static Connection abreConexion()
	{
		try
		{
			String url1 = "jdbc:mysql://localhost:3306/reto2";
			String user = "web";
			String password = "web";
		
			Class.forName("com.mysql.jdbc.Driver");
			
			return DriverManager.getConnection(url1, user, password);
		}
		
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
}

