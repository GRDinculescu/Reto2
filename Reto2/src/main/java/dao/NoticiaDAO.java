package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Noticia;
import models.Periodista;

public class NoticiaDAO {
	public static List<Noticia> listar(Connection con) {
		try {
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
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}
}
