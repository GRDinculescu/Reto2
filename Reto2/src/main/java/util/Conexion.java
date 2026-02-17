package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	private static Connection instance;
	
	public static Connection abreConexion() {
		if (instance == null) {
			try {
				String url1 = "jdbc:mysql://localhost:3306/reto2";
				String user = "web";
				String password = "web";
			
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				instance = DriverManager.getConnection(url1, user, password);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		
		return instance;
	}
}

