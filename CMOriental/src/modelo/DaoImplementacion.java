package modelo;

import java.sql.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import com.mysql.cj.jdbc.CallableStatement;
import com.mysql.cj.protocol.Resultset;

import clases.Actor;
import clases.Anime;
import clases.Autor;
import clases.ContenidoMultimedia;
import clases.Editorial;
import clases.Estudio;
import clases.Manga;
import clases.Proveedor;
import clases.Usuarios;
import vista.AltaProveedor;
import vista.Usuario;

public class DaoImplementacion implements Dao {

	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;

	// usuarios
	private final String ALTAU = "INSERT INTO Usuario(Codigo_Usuario, Email, Nombre, Apellido, Contraseña) values (?,?,?,?,?)";
	private final String CONSULTA_USUARIO = "SELECT * FROM Usuario where Nombre = ? and Contraseña = ?";
	private final String CONSULTA_Admin = "SELECT Nombre,Contraseña FROM Usuario where Codigo_Usuario = 1";

	// Actores
	private final String ALTAA = "INSERT INTO Actor(DNI, Nombre, Fecha_nac, Lugar_nac) values  (?,?,?,?)";
	private final String SELECT_ACTORES = "SELECT * FROM Actor";
	private final String SELECT_ACTOR = "SELECT * FROM Actor where DNI=?";
	private final String MOD_ACTOR = "update Actor set Nombre=?,Fecha_nac=?,Lugar_nac=? where DNI=?";
	private final String DELETEACTOR = "delete from Actor  where DNI=?";
	private final String ACTUA = "INSERT INTO Actua(Codigo_Anime, DNI_Actor) values  (?,?)";
	
	

	// Estudios
	private final String ALTAE = "INSERT INTO Estudio(Nombre, Fecha_fun, AnimacionCaracteristica) values (?,?,?) ";
	private final String SELECT_Estudios = "SELECT * FROM Estudio";
	private final String SELECT_Estudio = "SELECT * FROM Estudio where nombre=?";
	private final String UPDATEEST = "update Estudio set Fecha_fun = ?, AnimacionCaracteristica = ? where Nombre = ?";
	private final String DELETEEST = "delete from Estudio where Nombre=?";

	// Proveedores
	private final String SELECT_PROVEEDORES = "SELECT * FROM Proveedor";
	private final String SELECT_PROVEEDOR = "SELECT * FROM Proveedor where NIF=?";
	private final String ALTAPRO = "INSERT INTO Proveedor(NIF,Nombre,Ubicacion) values  (?,?,?)";
	private final String DELETEPRO = "delete from Proveedor  where NIF=?";
	private final String UPDATEPRO = "update Proveedor set NIF=?,Nombre=?,Ubicacion=? where NIF=?";

	// Autor
	private final String ALTAAUTOR = "INSERT INTO Autor(DNI, Nombre,Ciudad_nac, Fecha_nac ) values  (?,?,?,?)";
	private final String UPDATEAU = "update Autor set Nombre=?, Ciudad_nac=?, Fecha_nac=? where DNI=?";
	private final String DELETEAUT = "delete from Autor  where DNI=?";
	private final String SELECT_AUTOR = "SELECT * FROM Autor where DNI=?";
	private final String SELECT_AUTORES = "SELECT * FROM Autor ";

	private final String SELECT_EDITORIALES = "SELECT * FROM Editorial ";
	private final String SELECT_EDITORIAL = "SELECT * FROM Editorial where ID_Editorial=?";

	// MANGA
	private final String COMPRAMANGA = "{? = call ventaManga (?,?)}";
	private final String ALTACM = "INSERT INTO ContenidoMultimedia(Codigo,Titulo,Año_ini,Estado,Puntuacion, Codigo_Autor ) values  (?,?,?,?,?,?)";
	private final String ALTAMANGA = "INSERT INTO Manga(Codigo,ISBN,NUmTomos,Periodicidad,Precio,Stock,ID_Editorial) values  (?,?,?,?,?,?,?)";
	private final String UPDATEMANGA = "update  Manga set Codigo=?, ISBN=?, NUmTomos=?, Periodicidad=?, Precio=?,Stock=?, ID_Editorial=? where Codigo=?";
	private final String DELETEMANGA ="delete from  Manga  where Codigo=? ";
	private final String SELECT_MANGA = "SELECT * FROM  ContenidoMultimedia c join Manga m on c.Codigo=m.Codigo where c.Codigo=?";
	private final String SELECT_MANGAS = "SELECT * FROM Manga ";
	
	//Contenido Multimedia
	private final String SELECT_CMManga= "SELECT * FROM  ContenidoMultimedia c join Manga m on c.Codigo=m.Codigo where m.Codigo=c.Codigo ";
	private final String SELECT_CMAnime = "SELECT * FROM  ContenidoMultimedia c join Anime a on c.Codigo=a.Codigo where a.Codigo=c.Codigo ";
	private final String SELECT_CM = "SELECT * FROM  ContenidoMultimedia where Codigo=?";
	private final String Slect_COMPRA= "SELECT * FROM  ContenidoMultimedia c join Manga m on c.Codigo=m.Codigo join Compra co on m.Codigo=co.Codigo where Codigo_Usuario=? ";
	
	
	private final String UPDATECM = "update  ContenidoMultimedia set Codigo=?, Titulo=?, Año_ini=?, Estado=?, Puntuacion=?, Codigo_Autor=?  where Codigo=?";
	private final String SELECT_CMS = "SELECT * FROM ContenidoMultimedia ";
	private final String DELETECM ="delete from  ContenidoMultimedia  where Codigo=? ";
	
	//Anime
	private final String UPDATEANI = "update  Anime set Codigo=?, TipoAnime=?, Capitulos=?, Temporadas=?, Estudio=?  where Codigo=?";
	private final String ALTAANIME = "INSERT INTO  Anime (Codigo, Tipoanime, Capitulos, Temporadas, Estudio) values (?,?,?,?,?)";
	private final String DELETEANI = "delete from Anime  where codigo=?";
	private final String SELECT_ANI = "SELECT * FROM  Anime where Codigo=?";
	
	
	private final String DELETEACTUA ="delete from  Actua  where Codigo_Anime=? ";
	private final String DELETECOMPRA ="delete from  Compra  where Codigo=? ";
	private final String COMPRA = "INSERT INTO  Compra (Codigo_Usuario,Codigo) values (?,?)";
	
	
	
	private void openConnection() {

		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/contenidomultimedia?serverTimezone=Europe/Madrid&useSSL=false", "root",
					"abcd*1234");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void closeConnection() throws SQLException {
		try {
			if (stmt != null)
				stmt.close();
			if (con != null)
				con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public int consultaUsuario(String nombre, String contraseña) {
		int cod=0;
		this.openConnection();
		try {

			stmt = con.prepareStatement(CONSULTA_USUARIO);

			stmt.setString(1, nombre);
			stmt.setString(2, contraseña);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				
				cod = rs.getInt("Codigo_Usuario");
			}else {
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		return cod;

	}

	public void altaUsuario(Usuarios usu) {

		this.openConnection();

		try {

			stmt = con.prepareStatement(ALTAU);
			stmt.setInt(1, usu.getCodigoUS());
			stmt.setString(2, usu.getEmail());
			stmt.setString(3, usu.getNombre());
			stmt.setString(4, usu.getApellido());
			stmt.setString(5, usu.getContraseña());

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

																												// Actor

	@Override
	public void altaActor(Actor act) {
		// TODO Auto-generated method stub
		this.openConnection();

		try {

			stmt = con.prepareStatement(ALTAA);
			stmt.setString(1, act.getDni());
			stmt.setString(2, act.getNombre());
			stmt.setDate(3, Date.valueOf(act.getFechaNac()));
			stmt.setString(4, act.getCiudadNac());

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Actor> getActor() {
		// TODO Auto-generated method stub
		this.openConnection();
		Actor act;
		ResultSet rs;
		ArrayList<Actor> actores = new ArrayList<>();
		try {

			stmt = con.prepareStatement(SELECT_ACTORES);
			rs = stmt.executeQuery();

			while (rs.next()) {

				act = new Actor();
				act.setDni(rs.getString("DNI"));
				act.setNombre(rs.getString("Nombre"));
				act.setFechaNac(Date.valueOf(rs.getString("Fecha_nac")).toLocalDate());
				act.setCiudadNac(rs.getString("Lugar_nac"));

				actores.add(act);

			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		try {
			this.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return actores;

	}

	@Override
	public Actor consultaActor(String dni) {
		// TODO Auto-generated method stub
		Actor act = null;
		this.openConnection();

		try {
			stmt = con.prepareStatement(SELECT_ACTOR);

			stmt.setString(1, dni);
			rs = stmt.executeQuery();

			if (rs.next()) {
				act = new Actor();
				act.setDni(rs.getString("DNI"));
				act.setNombre(rs.getString("Nombre"));
				act.setFechaNac(Date.valueOf(rs.getString("Fecha_nac")).toLocalDate());
				act.setCiudadNac(rs.getString("Lugar_nac"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return act;
	}

	@Override
	public void modiActor(String dni, Actor actt) {
		// TODO Auto-generated method stub
		this.openConnection();

		try {

			stmt = con.prepareStatement(MOD_ACTOR);

			stmt.setString(1, actt.getNombre());
			stmt.setDate(2, Date.valueOf(actt.getFechaNac()));
			stmt.setString(3, actt.getCiudadNac());
			stmt.setString(4, dni);

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void bajaActor(String dni) {
		// TODO Auto-generated method stub
		this.openConnection();

		try {
			stmt = con.prepareStatement(DELETEACTOR);

			stmt.setString(1, dni);
			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

																													// Estudio

	@Override
	public void altaEstudios(Estudio est) {
		this.openConnection();

		try {

			stmt = con.prepareStatement(ALTAE);
			stmt.setString(1, est.getNombre());
			stmt.setDate(2, Date.valueOf(est.getFechaFun()));
			stmt.setString(3, est.getCaracteristica());

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void modificarEstudio(Estudio est, String nombre) {
		// TODO Auto-generated method stub
		this.openConnection();

		try {
			stmt = con.prepareStatement(UPDATEEST);

			stmt.setDate(1, Date.valueOf(est.getFechaFun()));
			stmt.setString(2, est.getCaracteristica());
			stmt.setString(3, nombre);

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void borradoEstudio(String nombre) {
		// TODO Auto-generated method stub

		this.openConnection();

		try {
			stmt = con.prepareStatement(DELETEEST);

			stmt.setString(1, nombre);
			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Estudio consultaEstudio(String nombre) {
		// TODO Auto-generated method stub

		Estudio est = null;
		this.openConnection();

		try {
			stmt = con.prepareStatement(SELECT_Estudio);

			stmt.setString(1, nombre);
			rs = stmt.executeQuery();

			if (rs.next()) {
				est = new Estudio();
				est.setNombre(rs.getString("Nombre"));
				est.setFechaFun(Date.valueOf(rs.getString("Fecha_fun")).toLocalDate());
				est.setCaracteristica(rs.getString("AnimacionCaracteristica"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return est;
	}

	@Override
	public ArrayList<Estudio> getEstudio() {
		// TODO Auto-generated method stub
		this.openConnection();
		Estudio estu;
		ResultSet rs;
		ArrayList<Estudio> est = new ArrayList<>();
		try {
			stmt = con.prepareStatement(SELECT_Estudios);
			rs = stmt.executeQuery();
			while (rs.next()) {
				estu = new Estudio();
				estu.setNombre(rs.getString("Nombre"));
				estu.setFechaFun(Date.valueOf(rs.getString("Fecha_fun")).toLocalDate());
				estu.setCaracteristica(rs.getString("AnimacionCaracteristica"));

				est.add(estu);

			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		try {
			this.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return est;
	}

																											// Autor

	@Override
	public void altaAutor(Autor au) {
		// TODO Auto-generated method stub
		this.openConnection();
		try {

			stmt = con.prepareStatement(ALTAAUTOR);
			stmt.setString(1, au.getDni());
			stmt.setString(2, au.getNombre());
			stmt.setString(3, au.getCiudadNac());
			stmt.setDate(4, Date.valueOf(au.getFechaNac()));

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void modAutor(String dni, Autor aut) {
		// TODO Auto-generated method stub
		this.openConnection();

		try {
			stmt = con.prepareStatement(UPDATEAU);

			stmt.setString(1, aut.getNombre());
			stmt.setString(2, aut.getCiudadNac());
			stmt.setDate(3, Date.valueOf(aut.getFechaNac()));

			stmt.setString(4, dni);
			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void borraAutor(String dni) {
		// TODO Auto-generated method stub

		this.openConnection();

		try {
			stmt = con.prepareStatement(DELETEAUT);

			stmt.setString(1, dni);
			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Autor> getAutor() {
		// TODO Auto-generated method stub
		this.openConnection();
		Autor au;
		ResultSet rs;
		ArrayList<Autor> aut = new ArrayList<>();
		try {
			stmt = con.prepareStatement(SELECT_AUTORES);
			rs = stmt.executeQuery();
			while (rs.next()) {
				au = new Autor();
				au.setDni(rs.getString("DNI"));
				au.setNombre(rs.getString("Nombre"));
				au.setCiudadNac(rs.getString("Ciudad_nac"));
				au.setFechaNac(Date.valueOf(rs.getString("Fecha_nac")).toLocalDate());

				aut.add(au);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			this.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return aut;
	}

	@Override
	public Autor consultaAutor(String dni) {
		// TODO Auto-generated method stub
		Autor au = null;
		this.openConnection();

		try {
			stmt = con.prepareStatement(SELECT_AUTOR);

			stmt.setString(1, dni);
			rs = stmt.executeQuery();

			if (rs.next()) {
				au = new Autor();
				au.setDni(rs.getString("DNI"));
				au.setNombre(rs.getString("Nombre"));
				au.setCiudadNac(rs.getString("Ciudad_nac"));
				au.setFechaNac(Date.valueOf(rs.getString("Fecha_nac")).toLocalDate());

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return au;
	}

	

	
																									// Proveedores
	@Override
	public void altaProveedoro(Proveedor pro) {
		// TODO Auto-generated method stub
		this.openConnection();

		try {

			stmt = con.prepareStatement(ALTAPRO);
			stmt.setString(1, pro.getNif());
			stmt.setString(2, pro.getNombre());
			stmt.setString(3, pro.getUbicacion());
			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public ArrayList<Proveedor> getProveedor() {
		// TODO Auto-generated method stub
		this.openConnection();
		Proveedor prove;
		ResultSet rs;
		ArrayList<Proveedor> pro = new ArrayList<>();
		try {
			stmt = con.prepareStatement(SELECT_PROVEEDORES);
			rs = stmt.executeQuery();
			while (rs.next()) {
				prove = new Proveedor();
				prove.setNif(rs.getString("NIF"));
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

	@Override
	public Proveedor consultaProveedor(String cifProveedor) {
		// TODO Auto-generated method stub

		Proveedor pro = null;
		this.openConnection();

		try {
			stmt = con.prepareStatement(SELECT_PROVEEDOR);

			stmt.setString(1, cifProveedor);
			rs = stmt.executeQuery();

			if (rs.next()) {
				pro = new Proveedor();
				pro.setNif(rs.getString("NIF"));
				pro.setNombre(rs.getString("Nombre"));
				pro.setUbicacion(rs.getString("Ubicacion"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pro;
	}

	@Override
	public void borradoProveedor(String nif) {
		// TODO Auto-generated method stub
		Proveedor pro = null;
		this.openConnection();

		try {
			stmt = con.prepareStatement(DELETEPRO);

			stmt.setString(1, nif);
			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void modificarProveedor(String modnif, Proveedor pro) {
		// TODO Auto-generated method stub
		this.openConnection();

		try {
			stmt = con.prepareStatement(UPDATEPRO);

			stmt.setString(1, pro.getNif());
			stmt.setString(2, pro.getNombre());
			stmt.setString(3, pro.getUbicacion());
			stmt.setString(4, modnif);

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
																									//EDITORIAL

	@Override
	public ArrayList<Editorial> getEditorial() {
		// TODO Auto-generated method stub
		this.openConnection();
		Editorial ed;
		ResultSet rs;
		ArrayList<Editorial> edi = new ArrayList<>();
		try {
			stmt = con.prepareStatement(SELECT_EDITORIALES);
			rs = stmt.executeQuery();
			while (rs.next()) {
				ed = new Editorial();
				ed.setID_Editorial(rs.getInt("ID_Editorial"));
				ed.setNombre(rs.getString("Nombre"));
				ed.setDirector(rs.getString("Director"));
				ed.setUbicacion(rs.getString("Ubicacion"));

				edi.add(ed);

			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		try {
			this.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return edi;
	}
	
	@Override
	public Editorial consultaEditorial(String id) {
		// TODO Auto-generated method stub
		Editorial ed = null;
		this.openConnection();

		try {
			stmt = con.prepareStatement(SELECT_EDITORIAL);

			stmt.setString(1, id);
			rs = stmt.executeQuery();

			if (rs.next()) {
				ed = new Editorial();
				ed.setID_Editorial(rs.getInt("ID_Editorial"));
				ed.setNombre(rs.getString("Nombre"));
				ed.setDirector(rs.getString("Director"));
				ed.setUbicacion(rs.getString("Ubicacion"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ed;
	}

	
	

																												// MANGA

	@Override
	public boolean altaManga(Manga man) {
		// TODO Auto-generated method stub
		boolean altaCorrecta = false;
		this.openConnection();

		try {
			//Insert contenidoMultimedia
			stmt = con.prepareStatement(ALTACM);
			
			stmt.setInt(1, man.getCodigo());
			stmt.setString(2, man.getTitulo());
			stmt.setInt(3, man.getAñoInicio());
			stmt.setString(4, man.getEstado().toString());
			stmt.setFloat(5, man.getPuntuacion());
			stmt.setString(6, man.getAutor().toString());
			
			//insert manga
			if (stmt.executeUpdate() == 1) {
				
				stmt = con.prepareStatement(ALTAMANGA);
				
				stmt.setInt(1, man.getCodigo());
				stmt.setInt(2, man.getIsbn());
				stmt.setInt(3, man.getNumTomos());
				stmt.setString(4, man.getPeriodicidad());
				stmt.setFloat(5, man.getPrecio());
				stmt.setInt(6, man.getStock());
				stmt.setString(7, man.getEditorial().toString());

				if (stmt.executeUpdate() == 1) {
					altaCorrecta = true;

				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return altaCorrecta;

	}

	@Override
	public boolean borradoManga(int cod) {
		// TOthis.openConnection();DO Auto-generated method stub
		this.openConnection();
		boolean correcto=true;
		

		try {
			//Borrar la parte de manga
			stmt = con.prepareStatement(DELETEMANGA);
			stmt.setInt(1,cod);
			stmt.executeUpdate();
			
			//borrar la perte de contenido multimedia
				stmt = con.prepareStatement(DELETECM);
				stmt.setInt(1,cod);
				stmt.executeUpdate();
				
			
		
			
			
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return correcto;
	}

	@Override
	public ArrayList<ContenidoMultimedia> getCM(boolean es ) {
		// TODO Auto-generated method stub
		this.openConnection();
		ContenidoMultimedia com;
		ResultSet rs;
		boolean esManga = es;
		ArrayList<ContenidoMultimedia> cm = new ArrayList<>();
		try {
			
			if(esManga) {
				stmt = con.prepareStatement(SELECT_CMManga);
				
				rs = stmt.executeQuery();
			}else {
				stmt = con.prepareStatement(SELECT_CMAnime);
				rs = stmt.executeQuery();
			}
			while (rs.next()) {
				
				com = new ContenidoMultimedia();
				
				com.setCodigo(rs.getInt("Codigo"));
				com.setTitulo(rs.getString("Titulo"));
				com.setAñoInicio(rs.getInt("Año_ini"));
				com.setEstado(rs.getString("Estado"));
				com.setPuntuacion(rs.getFloat("Puntuacion"));
				com.setAutor(rs.getString("Codigo_Autor"));
				
				cm.add(com);
					
				}
				

			

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		try {
			this.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cm;
	}
	
	@Override
	public List<Manga> getMangas( ) {
		// TODO Auto-generated method stub
		this.openConnection();
		Manga man;
		ResultSet rs;
	
		List<Manga> mangas = new ArrayList<>();
		try {
			
		
				stmt = con.prepareStatement(SELECT_CMManga);
				
				rs = stmt.executeQuery();
			
			
			while (rs.next()) {
				
				man = new Manga();
				
				man.setCodigo(rs.getInt("Codigo"));
				man.setTitulo(rs.getString("Titulo"));
				man.setAñoInicio(rs.getInt("Año_ini"));
				man.setEstado(rs.getString("Estado"));
				man.setPuntuacion(rs.getFloat("Puntuacion"));
				man.setAutor(rs.getString("Codigo_Autor"));
				man.setIsbn(rs.getInt("ISBN"));
				man.setPrecio(rs.getFloat("Precio"));
				man.setStock(rs.getInt("Stock"));
				mangas.add(man);
					
				}
				

			

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		try {
			this.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return mangas;
	}
	
	@Override
	public List<Manga> getMangasUsuario(int cod) {
		// TODO Auto-generated method stub
		this.openConnection();
		Manga man;
		ResultSet rs;
	
		List<Manga> mangas = new ArrayList<>();
		try {
			
		
				stmt = con.prepareStatement(Slect_COMPRA);
				stmt.setInt(1, cod);
				rs = stmt.executeQuery();
			
			
			while (rs.next()) {
				
				man = new Manga();
				
				man.setCodigo(rs.getInt("Codigo"));
				man.setTitulo(rs.getString("Titulo"));
				man.setAñoInicio(rs.getInt("Año_ini"));
				man.setEstado(rs.getString("Estado"));
				man.setPuntuacion(rs.getFloat("Puntuacion"));
				man.setAutor(rs.getString("Codigo_Autor"));
				man.setIsbn(rs.getInt("ISBN"));
				man.setPrecio(rs.getFloat("Precio"));
				man.setStock(rs.getInt("Stock"));
				mangas.add(man);
					
				}
				

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		try {
			this.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return mangas;
	}

	


	@Override
	public ContenidoMultimedia consultaCM(int cod) {
		// TODO Auto-generated method stub
		ContenidoMultimedia com= null;
		this.openConnection();

		try {
			stmt = con.prepareStatement(SELECT_CM);

			stmt.setInt(1, cod);
			rs = stmt.executeQuery();

			if (rs.next()) {
				com = new ContenidoMultimedia();
				com.setCodigo(rs.getInt("Codigo"));
				com.setTitulo(rs.getString("Titulo"));
				com.setAñoInicio(rs.getInt("Año_ini"));
				com.setEstado(rs.getString("Estado"));
				com.setPuntuacion(rs.getFloat("Puntuacion"));
				com.setAutor(rs.getString("Codigo_Autor"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return com;
	}
	

	@Override
	public Manga consultaManga(int cod) {
		// TODO Auto-generated method stub
		Manga man= null;
		this.openConnection();

		try {
			stmt = con.prepareStatement(SELECT_MANGA);

			stmt.setInt(1, cod);
			rs = stmt.executeQuery();

			if (rs.next()) {
				man = new Manga();
				man.setCodigo(rs.getInt("Codigo"));
				man.setTitulo(rs.getString("Titulo"));
				man.setAñoInicio(rs.getInt("Año_ini"));
				man.setEstado(rs.getString("Estado"));
				man.setPuntuacion(rs.getFloat("Puntuacion"));
				man.setAutor(rs.getString("Codigo_Autor"));
				man.setIsbn(rs.getInt("ISBN"));
				man.setNumTomos(rs.getInt("NumTomos"));
				man.setPeriodicidad(rs.getString("Periodicidad"));
				man.setPrecio(rs.getFloat("Precio"));
				man.setStock(rs.getInt("Stock"));
				man.setEditorial(rs.getString("ID_Editorial"));
				
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return man;
	}

	
	@Override
	public boolean modManga(int cod, Manga man) {
		// TODO Auto-generated method stub
		this.openConnection();
		boolean altaCorrecta = false;
		
		
		try {
			//modificar contenido multimedia
			stmt = con.prepareStatement(UPDATECM);
			
			stmt.setInt(1, man.getCodigo());
			stmt.setString(2, man.getTitulo());
			stmt.setInt(3, man.getAñoInicio());
			stmt.setString(4, man.getEstado().toString());
			stmt.setFloat(5, man.getPuntuacion());
			stmt.setString(6, man.getAutor().toString());
			stmt.setInt(7, cod);
			
			
			//modificacion manga
			if (stmt.executeUpdate() == 1) {
				
				stmt = con.prepareStatement(UPDATEMANGA);
				
				stmt.setInt(1, man.getCodigo());
				stmt.setInt(2, man.getIsbn());
				stmt.setInt(3, man.getNumTomos());
				stmt.setString(4, man.getPeriodicidad());
				stmt.setFloat(5, man.getPrecio());
				stmt.setInt(6, man.getStock());
				stmt.setString(7, man.getEditorial().toString());
				stmt.setInt(8, cod);
				if (stmt.executeUpdate() == 1) {
					altaCorrecta = true;

				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return altaCorrecta;
	}
	
																							
																										//Anime
	
	
	@Override
	public Anime consultaAnime(int codigo) {
		// TODO Auto-generated method stub

		Anime ani = null;
		this.openConnection();

		try {
			stmt = con.prepareStatement(SELECT_ANI);

			stmt.setInt(1, codigo);
			rs = stmt.executeQuery();

			if (rs.next()) {
				ani = new Anime();
				ani.setCodigo(rs.getInt("Codigo"));
				ani.setTipoAnime(rs.getString("TipoAnime"));
				ani.setCapitulos(rs.getInt("Capitulos"));
				ani.setTemporadas(rs.getInt("Temporadas"));
				ani.setEstudio(rs.getString("Estudio"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ani;
	}
	
	
	@Override
	public void borradoAnime(int codigo) {
		this.openConnection();

		try {
			
			stmt = con.prepareStatement(DELETEACTUA);
			stmt.setInt(1, codigo);
			stmt.executeUpdate();
			
			stmt = con.prepareStatement(DELETECOMPRA);
			stmt.setInt(1, codigo);
			stmt.executeUpdate();
			
			stmt = con.prepareStatement(DELETEANI);
			stmt.setInt(1, codigo);
			stmt.executeUpdate();
			
			stmt = con.prepareStatement(DELETEMANGA);
			stmt.setInt(1, codigo);
			stmt.executeUpdate();
			
			stmt = con.prepareStatement(DELETECM);
			stmt.setInt(1, codigo);
			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Override
	public void modificarAnime(Anime ani,int codigo) {
		boolean altaCorrecta = false;
		this.openConnection();

		try {

			stmt = con.prepareStatement(UPDATECM);
			stmt.setInt(1, ani.getCodigo());
			stmt.setString(2, ani.getTitulo());
			stmt.setInt(3, ani.getAñoInicio());
			stmt.setString(4, ani.getEstado());
			stmt.setFloat(5, ani.getPuntuacion());
			stmt.setString(6, ani.getAutor().toString());
			stmt.setInt(7, codigo);

			if (stmt.executeUpdate() == 1) {
				
				stmt = con.prepareStatement(UPDATEANI);
				stmt.setInt(1, ani.getCodigo());
				stmt.setString(2, ani.getTipoAnime());
				stmt.setInt(3, ani.getCapitulos());
				stmt.setInt(4, ani.getTemporadas());
				stmt.setString(5, ani.getEstudio());
				stmt.setInt(6, codigo);
				stmt.executeUpdate() ;
					
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Override
	public void altaAnime(Anime ani, ArrayList<Actor> actores ) {
		boolean altaCorrecta = false;
		this.openConnection();

		try {

			stmt = con.prepareStatement(ALTACM);
			stmt.setInt(1, ani.getCodigo());
			stmt.setString(2, ani.getTitulo());
			stmt.setInt(3, ani.getAñoInicio());
			stmt.setString(4, ani.getEstado());
			stmt.setFloat(5, ani.getPuntuacion());
			stmt.setString(6, ani.getAutor().toString());

			if (stmt.executeUpdate() == 1) {
				stmt = con.prepareStatement(ALTAANIME);
				stmt.setInt(1, ani.getCodigo());
				stmt.setString(2, ani.getTipoAnime());
				stmt.setInt(3, ani.getCapitulos());
				stmt.setInt(4, ani.getTemporadas());
				stmt.setString(5, ani.getEstudio());
				
				if (stmt.executeUpdate() == 1) {
					altaCorrecta = true;
					stmt = con.prepareStatement(ACTUA);
					stmt.setInt(1, ani.getCodigo());
					for(Actor a:actores) {
						stmt.setString(2,a.getDni());
					}
					stmt.executeUpdate();
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Override
	public List<Anime> getAnimes( ) {
		// TODO Auto-generated method stub
		this.openConnection();
		Anime an;
		ResultSet rs;
	
		List<Anime> animes = new ArrayList<>();
		try {
			
		
				stmt = con.prepareStatement(SELECT_CMAnime);
				
				rs = stmt.executeQuery();
			
			
			while (rs.next()) {
				
				an = new Anime();
				
				an.setCodigo(rs.getInt("Codigo"));
				an.setTitulo(rs.getString("Titulo"));
				an.setAñoInicio(rs.getInt("Año_ini"));
				an.setEstado(rs.getString("Estado"));
				an.setPuntuacion(rs.getFloat("Puntuacion"));
				an.setTipoAnime(rs.getString("TipoAnime"));
				an.setCapitulos(rs.getInt("Capitulos"));
				an.setTemporadas(rs.getInt("Temporadas"));
				an.setEstudio(rs.getString("Estudio"));
				animes.add(an);
				
					
				}
				

			

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		try {
			this.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return animes;
	}

	@Override
	public boolean ventaManga(int cod, int cant, int codi) {
		// TODO Auto-generated method stub
		boolean buenaventa=false;
		this.openConnection();
		
		CallableStatement cs = null;
		try {

			cs = (CallableStatement) con.prepareCall(COMPRAMANGA);
			cs.registerOutParameter(1, Types.BOOLEAN);
			cs.setInt(2,cod);
			cs.setInt(3,cant);
			cs.execute();
		
				if (cs.getBoolean(1)) {
					buenaventa = true;
				}else {
					buenaventa = false;
				}
				
				rs = stmt.executeQuery();
				
				
				while (rs.next()) {
				stmt = con.prepareStatement(COMPRA);
				stmt.setInt(1, codi);
				stmt.setInt(2, cod);
				
				stmt.executeUpdate();
				
			}
				
					
				
				
				

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return buenaventa;
	}

	

	

	

	
}