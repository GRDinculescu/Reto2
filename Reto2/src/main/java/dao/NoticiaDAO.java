package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Noticia;
import models.Periodista;

public class NoticiaDAO {
	public static List<Noticia> listar(Connection con) throws SQLException {
		String q = "select * from noticia n "
				+ "inner join periodista p on n.idPeriodista = p.idPeriodista";
		Statement st = con.createStatement();
		st.execute(q);
		
		List<Noticia> noticias = new ArrayList<>();
		
		ResultSet rs = st.getResultSet();
		while (rs.next()) {
			Periodista p = new Periodista(
					rs.getString("nombre"),
					rs.getString("email"),
					rs.getInt("codigo"),
					rs.getString("pwd"),
					rs.getString("seguridad"));
			p.setId(rs.getInt("idPeriodista"));
			
			Noticia n = new Noticia(
					p,
					rs.getString("titular"),
					rs.getString("texto"),
					rs.getDate("fecha"));
			n.setId(rs.getInt("idnoticia"));
			
			noticias.add(n);
		}
		
		return noticias;
	}
	
	public static Noticia buscar(Connection con, int id) throws SQLException {
		String q = "select * from noticia n "
				+ "inner join periodista p on n.idPeriodista = p.idPeriodista "
				+ "where idnoticia = ?";
		PreparedStatement st = con.prepareStatement(q);
		st.setInt(1, id);
		st.execute();
		
		ResultSet rs = st.getResultSet();
		if (rs.next()) {
			Periodista p = new Periodista(
					rs.getString("nombre"),
					rs.getString("email"),
					rs.getInt("codigo"),
					rs.getString("pwd"),
					rs.getString("seguridad"));
			p.setId(rs.getInt("idPeriodista"));
			
			Noticia n = new Noticia(
					p,
					rs.getString("titular"),
					rs.getString("texto"),
					rs.getDate("fecha"));
			n.setId(rs.getInt("idnoticia"));
			
			return n;
		}
		return null;
	}
	
	public static int insertar(Connection con, Noticia n) throws SQLException {
		String q = "insert into noticia(idPeriodista, titular, texto, fecha)"
				+ "values (?,?,?,?)";
		PreparedStatement st = con.prepareStatement(q, PreparedStatement.RETURN_GENERATED_KEYS);
		st.setInt(1, n.getPeriodista().getId());
		st.setString(2, n.getTitular());
		st.setString(3, n.getTexto());
		st.setDate(4, new Date(n.getFecha().getTime()));
		st.executeUpdate();

		ResultSet rs = st.getGeneratedKeys();
		
		if (rs.next()) return rs.getInt(1);
		return -1;
	}
	
	public static boolean verificarPropiedad(Connection con, int id, String seguridad) throws SQLException {
		String q = "select 1 from noticia n "
				+ "inner join periodista p on n.idPeriodista = p.idPeriodista "
				+ "where idnoticia = ? and seguridad = ?";
		PreparedStatement st = con.prepareStatement(q);
		st.setInt(1, id);
		st.setString(2, seguridad);
		st.execute();

		ResultSet rs = st.getResultSet();
		
		if (rs.next()) return true;
		return false;
	}
		
	public static void borrar(Connection con, int id) throws SQLException {
		String q = "delete from noticia where idnoticia = ?;";
		PreparedStatement st = con.prepareStatement(q);
		st.setInt(1, id);
		st.executeUpdate();
	}
}
