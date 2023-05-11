package clases;

public class Usuarios {

	//atributos
	private int codigoUS;
	private String email;
	private String nombreUsuario;
	private String contraseña;
	private String nombre;
	private String apellido;
	//get & set
	public int getCodigoUS() {
		return codigoUS;
	}
	public void setCodigoUS(int codigoUS) {
		this.codigoUS = codigoUS;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
}