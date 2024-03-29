package clases;

import java.io.Serializable;
import java.time.LocalDate;

import utilidades.Utilidades;

public class Autor implements Serializable{

	//atributos
	private String dni;
	private String nombre;
	private LocalDate fechaNac;
	private String ciudadNac;
	//get & set
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDate getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}
	public String getCiudadNac() {
		return ciudadNac;
	}
	public void setCiudadNac(String ciudadNac) {
		this.ciudadNac = ciudadNac;
	}
}
