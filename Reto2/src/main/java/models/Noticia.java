package models;

import java.util.Date;

/*  
  `idnoticia` int NOT NULL AUTO_INCREMENT,
  `idPeriodista` int NOT NULL,
  `titular` varchar(150) COLLATE utf8mb4_general_ci NOT NULL,
  `texto` varchar(5000) COLLATE utf8mb4_general_ci NOT NULL,
  `fecha` date NOT NULL,
*/
public class Noticia {
	private int id;
	private Periodista periodista;
	private String titular;
	private String texto;
	private Date fecha;
	
	public Noticia(Periodista periodista, String titular, String texto, Date fecha) {
		this.periodista = periodista;
		this.titular = titular;
		this.texto = texto;
		this.fecha = fecha;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Periodista getPeriodista() {
		return periodista;
	}
	public void setPeriodista(Periodista periodista) {
		this.periodista = periodista;
	}
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	@Override
	public String toString() {
		return "Noticia [id=" + id + ", periodista=" + periodista + ", titular=" + titular + ", texto=" + texto
				+ ", fecha=" + fecha + "]";
	}
}
