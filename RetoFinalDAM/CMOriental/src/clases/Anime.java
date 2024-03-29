package clases;

import java.util.ArrayList;

public class Anime extends ContenidoMultimedia{

	//atributos
	private String tipoAnime;
	private int capitulos;
	private int temporadas;
	private String estudio;
	private String autores;
	
	//get Y set
	public String getTipoAnime() {
		return tipoAnime;
	}
	public void setTipoAnime(String tipoAnime) {
		this.tipoAnime = tipoAnime;
	}
	public int getCapitulos() {
		return capitulos;
	}
	public void setCapitulos(int capitulos) {
		this.capitulos = capitulos;
	}
	public int getTemporadas() {
		return temporadas;
	}
	public void setTemporadas(int temporadas) {
		this.temporadas = temporadas;
	}
	public final String getAutores() {
		return autores;
	}
	public final void setAutores(String autores) {
		this.autores = autores;
	}
	public final String getEstudio() {
		return estudio;
	}
	public final void setEstudio(String estudio) {
		this.estudio = estudio;
	}
}
