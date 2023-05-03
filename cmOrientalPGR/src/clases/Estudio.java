package clases;

import java.time.LocalDate;

public class Estudio extends Anime{

	//atributos
	private String nombre;
	private LocalDate fechaFun;
	private String caracteristica;
	//get & set
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDate getFechaFun() {
		return fechaFun;
	}
	public void setFechaFun(LocalDate fechaFun) {
		this.fechaFun = fechaFun;
	}
	public String getCaracteristica() {
		return caracteristica;
	}
	public void setCaracteristica(String caracteristica) {
		this.caracteristica = caracteristica;
	}
	
}
