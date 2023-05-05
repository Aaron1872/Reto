package principal;

import modelo.Dao;
import modelo.DaoImplementacion;
import vista.InicioSesionRegistro;

public class Principal {

	public static void main(String[] args) {
		Dao dao = new DaoImplementacion();
		
		InicioSesionRegistro principal = new InicioSesionRegistro(dao);
		principal.setVisible(true);

	}
  
}
