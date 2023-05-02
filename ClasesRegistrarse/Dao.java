package modelo;


import clases.Actor;
import clases.Anime;
import clases.Autor;
import clases.Estudio;
import clases.Proveedor;
import clases.Usuarios;

public interface Dao {
	
	public void altaUsuario(Usuarios usu);
	
	public void altaActor(Actor act);
	public void altaAnime(Anime ani);
	public void altaAutor(Autor au);
	public void altaEstudio(Estudio est);
	public void altaManga(Usuarios mangas);
	public void altaProveedoro(Proveedor pro);
	
	
}