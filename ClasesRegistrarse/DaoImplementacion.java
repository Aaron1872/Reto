package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import clases.Actor;
import clases.Anime;
import clases.Autor;
import clases.Estudio;
import clases.Proveedor;
import clases.Usuarios;

public class DaoImplementacion implements Dao{
	private Connection con;
	private PreparedStatement stmt;
	
	private final String ALTAU = "INSERT INTO Usuario(Codigo_Usuario, Email, Nombre, Apellido, Contraseña) values (?,?,?,?,?)";
	private final String ALTAE = "INSERT INTO Estudio(Nombre, Fecha_fun, NumEmp, PreAnu, AnimacionCaracteristica) values (?,?,?,?,?) ";
	private final String ALTAA = "INSERT INTO Actor(DNI, Nombre, Fecha_nac, Lugar_nac) values  (?,?,?,?)";
	private final String DELETEP = "delete * from Propietario ";
	private final String DELETECH = "delete from Coche  where id=?";
	private final String CONSULTA_PROPIETARIOS = "select * from propietario" ;
	
	
	private void openConnection(){
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/contenidomultimedia?serverTimezone=Europe/Madrid&useSSL=false", "root","abcd*1234");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void closeConnection() throws SQLException {
		try{
			if (stmt != null) 
				stmt.close();
			if(con != null) 
				con.close();
				
		}catch (SQLException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void altaUsuario(Usuarios usu) {
		
		this.openConnection();
		
		try {
			
			stmt=con.prepareStatement(ALTAU);
			stmt.setInt(1,usu.getCodigoUS() );
			stmt.setString(2, usu.getEmail());
			stmt.setString(3,usu.getNombre());
			stmt.setString(4, usu.getApellido());
			stmt.setString(5, usu.getContraseña());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}try {
			closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

	@Override
	public void altaActor(Actor act) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void altaAnime(Anime ani) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void altaAutor(Autor au) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void altaEstudio(Estudio est) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void altaManga(Usuarios mangas) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void altaProveedoro(Proveedor pro) {
		// TODO Auto-generated method stub
		
	}
	
	
	

	
	
}
