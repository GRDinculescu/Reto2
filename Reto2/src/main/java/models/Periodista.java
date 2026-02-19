package models;

public class Periodista {
	private int idPeriodista;
	private String nombre;
	private String email;
	private int codigo;
	private String pwd;
	private String seguridad;
	public Periodista(String nombre, String email, int codigo, String pwd, String seguridad) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.codigo = codigo;
		this.pwd = pwd;
		this.seguridad = seguridad;
	}
	
	public int getId() {
		return idPeriodista;
	}
	public void setId(int id) {
		this.idPeriodista = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getSeguridad() {
		return seguridad;
	}
	public void setSeguridad(String seguridad) {
		this.seguridad = seguridad;
	}
	@Override
	public String toString() {
		return "Periodista [id=" + idPeriodista + ", nombre=" + nombre + ", email=" + email + ", codigo=" + codigo + ", pwd="
				+ pwd + ", seguridad=" + seguridad + "]";
	}
}
