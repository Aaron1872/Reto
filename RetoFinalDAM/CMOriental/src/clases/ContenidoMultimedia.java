package clases;

import java.io.Serializable;
import java.time.LocalDate;

import utilidades.Utilidades;

public class ContenidoMultimedia{

	//atributos
	private String codigo;
	private String titulo;
	private String autor;
	private int añoInicio;
	private String estado;
	private float puntuacion;
	//get &set
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
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
	public int getAñoInicio() {
		return añoInicio;
	}
	public void setAñoInicio(int añoInicio) {
		this.añoInicio = añoInicio;
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
