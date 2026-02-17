package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import models.Periodista;

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
	
	public static Periodista loginPeriodista(Connection con, Periodista periodista) {
		try {
			String q = "select 1 from periodista where codigo = ? and pwd = ?";
			
			PreparedStatement st = con.prepareStatement(q);
			st.setInt(1, periodista.getCodigo());
			st.setString(1, periodista.getPwd());
			st.execute();
			
			ResultSet rs = st.getResultSet();
			
			Periodista p = new Periodista(
					rs.getString("nombre"),
					rs.getString("email"),
					rs.getInt("codigo"),
					rs.getString("pwd"),
					rs.getString("seguridad"));
			p.setId(rs.getInt("idPeriodista"));
			
			if (rs.next()) return p;
		} catch (Exception e) {
			System.err.println("Error al comprobar el codigo\n"+e.getMessage());
		}
		return null;
	}
}
