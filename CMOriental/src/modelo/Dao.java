package modelo;


import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

import clases.Actor;
import clases.Anime;
import clases.Autor;
import clases.ContenidoMultimedia;
import clases.Editorial;
import clases.Estudio;
import clases.Manga;
import clases.Proveedor;
import clases.Usuarios;

public interface Dao {
	
	
	
	
	//Usuario
	public void altaUsuario(Usuarios usu);
	public int consultaUsuario(String nombre, String contraseña);
	
	//Actor
	public void altaActor(Actor act);
	public Actor consultaActor(String dni);
	public void modiActor(String dni, Actor actt);
	public void bajaActor(String dni);
	public ArrayList<Actor> getActor();
	
	//Editorial
	public ArrayList<Editorial> getEditorial();
	public Editorial consultaEditorial(String id);
	
	//Anime
	public void altaAnime(Anime ani, ArrayList<Actor> actores);
	public Anime consultaAnime(int codigo);
	public void modificarAnime(Anime anim, int codigo);
	public void borradoAnime(int codigo);
	public List<Anime> getAnimes();
	
	//Autor
	public void altaAutor(Autor au);
	public void modAutor(String dni, Autor aut);
	public void borraAutor(String dni);
	public ArrayList<Autor> getAutor();
	public Autor consultaAutor(String string);
	
	//Estudio
	public void altaEstudios(Estudio est);
	public void modificarEstudio(Estudio est, String nombre);
	public void borradoEstudio(String nombre);
	public Estudio consultaEstudio(String nombre);
	public ArrayList<Estudio> getEstudio();
	
	//Manga
	public boolean ventaManga(int cod,int cant, int codi);
	public boolean altaManga(Manga man);
	public boolean modManga(int cod, Manga man);
	public boolean borradoManga(int cod);
	public Manga consultaManga(int cod);
	public List<Manga> getMangas();
	public List<Manga> getMangasUsuario(int cod);
	
	
	//Contenido Multimedia
	public ArrayList<ContenidoMultimedia> getCM( boolean es);
	public ContenidoMultimedia consultaCM(int string);
	
	
	
	//proveedor
	public void modificarProveedor(String modnif, Proveedor pro);
	public void altaProveedoro(Proveedor pro);
	public void borradoProveedor(String nif);
	public Proveedor consultaProveedor(String cifProveedor);
	public ArrayList<Proveedor> getProveedor();
	
	
	
}