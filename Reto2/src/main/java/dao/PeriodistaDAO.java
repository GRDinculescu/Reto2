package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PeriodistaDAO {
	public static boolean existeCodigo(Connection con, String codigo) {
		try {
			String q = "select 1 from periodista where seguridad = ?";
			
			PreparedStatement st = con.prepareStatement(q);
			st.setString(1, codigo);
			st.execute();
			
			ResultSet rs = st.getResultSet();
			
			if (rs.next()) return true;
		} catch (Exception e) {
			System.err.println("Error al comprobar el codigo\n"+e.getMessage());
		}
		return false;
	}
}
