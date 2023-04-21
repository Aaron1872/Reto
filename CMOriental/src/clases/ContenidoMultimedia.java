package clases;

import java.io.Serializable;
import java.time.LocalDate;

import utilidades.Utilidades;

public class ContenidoMultimedia{

	//atributos
	private int codigo;
	private String titulo;
	private String autor;
	private LocalDate a�oInicio;
	private String estado;
	private float puntuacion;
	//get &set
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public LocalDate getA�oInicio() {
		return a�oInicio;
	}
	public void setA�oInicio(LocalDate a�oInicio) {
		this.a�oInicio = a�oInicio;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public float getPuntuacion() {
		return puntuacion;
	}
	public void setPuntuacion(float puntuacion) {
		this.puntuacion = puntuacion;
	}
}