import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({ "/cambiaestoclaudiu/*", "/cambiaestoclaudiu" })
public class ServletPeriodista {

	private Gson gson = new GsonBuilder().setDateFormat("").create();

/*
	Todos los métodos reciben en la cabecera el código de seguridad del periodista,
		y tenemos que validar que existe antes de insertar o borrar.
		Además, en borrar validaremos que la noticia a borrar es de él. 
	
	GET /noticias: devuelve una lista con todas las noticias del periodista cuyo código de seguridad y el pasado por la cabecera
		error 405 si se intenta hacer GET a /noticia/xxx
	
	POST /noticia: recibe los datos de una noticia (sin id), lo guarda en la BD y devuelve la noticia con el id
		error 405 si se intenta hacer POST a /noticia/xxx
		error 403 si no puede insertar la noticia porque el periodista no existe
	
	DELETE /noticia/123: elimina la noticia 123 en la bd. No devuelve datos
		error 404 si no existe la noticia 123
		error 405 si se intenta hacer DELETE a /noticias	
		error 403 si la noticia no es del periodista
*/
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		if ("/libros".equals(request.getServletPath())) {
			List<Libro> lista = listaLibros();
			response.getWriter().write(gson.toJson(lista));
		}
		else { // /libro/xxxx
			int id = Integer.parseInt(request.getPathInfo().substring(1));
			Libro l = cargaLibro(id);
			if (l == null) {
					response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			} else {
					response.getWriter().write(gson.toJson(l));
			}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		if ("/libros".equals(request.getServletPath())) {
	  		String s = leerReader(request.getReader());
	  		Libro l = gson.fromJson(s, Libro.class);
	  		int id = insertaLibro(l);
	  		l.setId(id);
	  		response.setContentType("application/json");
	  		response.setCharacterEncoding("UTF-8");
	  		response.getWriter().write(gson.toJson(l));
		}
		else { // /libro/xxxx
	  		response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
		}
	}

	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
	    
		if ("/libros".equals(request.getServletPath())) {
	      		response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
	    	}
	    	else { // /libro/xxxx
	      		int id = Integer.parseInt(request.getPathInfo().substring(1));
	      		String s = leerReader(request.getReader());
	      		Libro l = gson.fromJson(s, Libro.class);
	      		if (l.getId() != id) {
	        		response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
	      		}
	      		else {
	        		actualizaLibro(l);
	             	}
	    	}
	  }
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		if ("/libros".equals(request.getServletPath())) {
	  		response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
		}
		else { // /libro/xxxx
      		int id = Integer.parseInt(request.getPathInfo().substring(1));
      		borraLibro(id);
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
