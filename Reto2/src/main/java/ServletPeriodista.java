import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.sql.Connection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import dao.PeriodistaDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Noticia;
import models.Periodista;
import util.Conexion;

@WebServlet({ "/login/*", "/login" })
public class ServletPeriodista extends HttpServlet {

	private Gson gson = new GsonBuilder().setDateFormat("").create();
	
	private Connection con = Conexion.abreConexion();

/*
	POST /login: recibe un periodista y valida el código y la contraseña,
		devuelve el periodista con todos sus datos si es correcto
		error 404 si no existe 

  `idPeriodista` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(150) COLLATE utf8mb4_general_ci NOT NULL,
  `email` varchar(150) COLLATE utf8mb4_general_ci NOT NULL,
  `codigo` int NOT NULL,
  `pwd` varchar(150) COLLATE utf8mb4_general_ci NOT NULL,
  `seguridad` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,

*/		
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println(con);
		if ("/login".equals(request.getServletPath())) {
	  		String s = leerReader(request.getReader());
	  		try {
		  		Periodista p = gson.fromJson(s, Periodista.class);
		  		
		  		if (p == null) {
		  			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		  			return;
		  		}
		  		
		  		Periodista p2 = PeriodistaDAO.loginPeriodista(con, p);
		  		
		  		if (p2 == null) {
		  			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		  			return;
		  		}
		  		
		  		response.setContentType("application/json");
		  		response.setCharacterEncoding("UTF-8");
		  		response.getWriter().write(gson.toJson(p2));
			} catch (JsonSyntaxException e) {
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			}
		}
		else { // /login/xxxx
	  		response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
		}
	}
	
	//lee el contenido de un Reader y lo devuelve en un String
	public static String leerReader(Reader reader) throws IOException {
	   	char[] buffer = new char[1000];
	   	int leidos;
	   	StringBuilder sb = new StringBuilder();
	   	while ((leidos = reader.read(buffer)) > 0) {
    		sb.append(buffer, 0, leidos);
	   	}
	   	reader.close();
	   	return sb.toString();
	}
}
