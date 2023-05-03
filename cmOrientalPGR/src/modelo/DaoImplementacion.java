package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.mysql.cj.protocol.Resultset;

import clases.Actor;
import clases.Anime;
import clases.Autor;
import clases.Estudio;

import clases.Proveedor;
import clases.Usuarios;
import vista.Usuario;

public class DaoImplementacion implements Dao{
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;

	private final String ALTAU = "INSERT INTO Usuario(Codigo_Usuario, Email, Nombre, Apellido, Contrase�a) values (?,?,?,?,?)";
	private final String ALTAE = "INSERT INTO Estudio(Nombre, Fecha_fun, NumEmp, PreAnu, AnimacionCaracteristica) values (?,?,?,?,?) ";
	private final String ALTAA = "INSERT INTO Actor(DNI, Nombre, Fecha_nac, Lugar_nac) values  (?,?,?,?)";
	private final String DELETEP = "delete * from Propietario ";
	private final String DELETECH = "delete from Coche  where id=?";
	private final String CONSULTA_USUARIO = "SELECT * FROM Usuario where Nombre = ? and Contrase�a = ?";
	private final String CONSULTA_Admin = "SELECT Nombre,Contrase�a FROM Usuario where Codigo_Usuario = 1";
	private final String SELECT_PROVEEDOR = "SELECT * FROM Proveedor";
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
			stmt.setString(5, usu.getContrase�a());

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

	@Override
	public boolean consultaUsuario(String nombre, String contrase�a) {
		boolean esta = false;
		this.openConnection();
		try {

			stmt=con.prepareStatement(CONSULTA_USUARIO);

			stmt.setString(1,nombre);
			stmt.setString(2,contrase�a);


			ResultSet rs  = stmt.executeQuery();
			
			if(rs.next()) {
				esta = true;
			}
			
			
			


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}try {
			closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();


	}

		return esta;

	}

	@Override
	public ArrayList<Proveedor> getProveedor() {
		// TODO Auto-generated method stub
		this.openConnection();
		Proveedor prove;
		ResultSet rs;
		ArrayList<Proveedor> pro = new ArrayList<>();
		try {
			stmt = con.prepareStatement(SELECT_PROVEEDOR);
			rs = stmt.executeQuery();
			while (rs.next()) {
				prove = new Proveedor();
				prove.setNif(rs.getInt("NIF"));
				prove.setNombre(rs.getString("Nombre"));
				prove.setUbicacion(rs.getString("Ubicacion"));
				
				pro.add(prove);
				
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		try {
			this.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pro;
	}

	

}