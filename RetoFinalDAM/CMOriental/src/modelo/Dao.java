package modelo;


import java.util.ArrayList;

import javax.swing.JComboBox;

import clases.Actor;
import clases.Anime;
import clases.Autor;
import clases.ContenidoMultimedia;
import clases.Estudio;
import clases.Proveedor;
import clases.Usuarios;

public interface Dao {
	
	
	
	
	//Usuario
	public void altaUsuario(Usuarios usu);
	public boolean consultaUsuario(String nombre, String contraseņa);
	
	//Actor
	public void altaActor(Actor act);
	public Actor consultaActor(String dni);
	public void modiActor(String dni, Actor actt);
	public void bajaActor(String dni);
	public ArrayList<Actor> getActor();
	
	
	public void altaAnime(Anime ani);
	public void altaAutor(Autor au);
	
	//Estudio
	public void altaEstudios(Estudio est);
	public void modificarEstudio(Estudio est, String nombre);
	public void borradoEstudio(String nombre);
	public Estudio consultaEstudio(String nombre);
	public ArrayList<Estudio> getEstudio();
	
	
	public void altaManga(Usuarios mangas);
	
	//proveedor
	public void modificarProveedor(String modnif, Proveedor pro);
	public void altaProveedoro(Proveedor pro);
	public void borradoProveedor(String nif);
	public Proveedor consultaProveedor(String cifProveedor);
	public ArrayList<Proveedor> getProveedor();
	public void modificarAnime(Anime anim, String codigo);
	public void borradoAnime(String codigo);
	public ArrayList<Autor> getAutor();
	public Autor consultaAutor(String dni);
	public ContenidoMultimedia consultaCM(String cod);
	public ArrayList<ContenidoMultimedia> getCM();
	public Anime consultaAnime(String codigo);
	
	
	
	
}