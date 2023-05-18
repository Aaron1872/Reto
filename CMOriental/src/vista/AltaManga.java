package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Dao;
import modelo.DaoImplementacion;
import clases.Autor;
import clases.ContenidoMultimedia;
import clases.Editorial;
import clases.Estudio;
import clases.Manga;
import clases.Proveedor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class AltaManga extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField textCodigo;
	private JTextField textTitulo;
	private JTextField textAño;
	private JTextField textPuntuacion;
	private JTextField textISBN;
	private JTextField textTomos;
	private JTextField textPeriozidad;
	private JTextField textPrecio;
	private JTextField textStock;
	private Dao dao;
	private JButton btnAlta;
	private JButton btnModi ;
	private JButton btnBaja ;
	private JButton btnVolver;
	private Manga manga;
	private JComboBox comboAutor ;
	private JComboBox comboEditorial;
	private JComboBox comboEstado;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 * @param b 
	 * @param dao 
	 * @param com 
	 * @param au 
	 * @param ed 
	 * @param admin 
	 */
	public AltaManga(boolean b, Dao dao, Manga man, ContenidoMultimedia com, Autor au, Editorial ed) {
		
		this.dao=dao;
		this.setModal(b);
		this.manga=man;
		getContentPane().setLayout(null);
		
		JLabel lblAnime = new JLabel("MANGA");
		lblAnime.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblAnime.setBounds(10, 11, 86, 23);
		getContentPane().add(lblAnime);
		setBounds(100, 100, 518, 629);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblAnime_1 = new JLabel("Codigo");
		lblAnime_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblAnime_1.setBounds(10, 67, 86, 23);
		contentPanel.add(lblAnime_1);
		
		JLabel lblAnime_2 = new JLabel("Titulo");
		lblAnime_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblAnime_2.setBounds(10, 115, 86, 23);
		contentPanel.add(lblAnime_2);
		
		JLabel lblAnime_3 = new JLabel("Autor");
		lblAnime_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblAnime_3.setBounds(10, 165, 86, 23);
		contentPanel.add(lblAnime_3);
		
		JLabel lblAnime_4 = new JLabel("A\u00F1o Inicio");
		lblAnime_4.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblAnime_4.setBounds(10, 214, 86, 23);
		contentPanel.add(lblAnime_4);
		
		JLabel lblAnime_4_1 = new JLabel("Estado");
		lblAnime_4_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblAnime_4_1.setBounds(10, 257, 86, 23);
		contentPanel.add(lblAnime_4_1);
		
		JLabel lblPuntuacion = new JLabel("Puntuacion");
		lblPuntuacion.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblPuntuacion.setBounds(10, 301, 86, 23);
		contentPanel.add(lblPuntuacion);
		
		JLabel lblISBN = new JLabel("ISBN");
		lblISBN.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblISBN.setBounds(10, 335, 86, 23);
		contentPanel.add(lblISBN);
		
		JLabel lblTomos = new JLabel("N\u00BATomos");
		lblTomos.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblTomos.setBounds(10, 357, 86, 47);
		contentPanel.add(lblTomos);
		
		JLabel lblEditorial = new JLabel("Editorial");
		lblEditorial.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblEditorial.setBounds(10, 405, 101, 23);
		contentPanel.add(lblEditorial);
		
		JLabel lblPeriozidad = new JLabel("Periodizidad");
		lblPeriozidad.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblPeriozidad.setBounds(10, 439, 101, 23);
		contentPanel.add(lblPeriozidad);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblPrecio.setBounds(10, 473, 86, 23);
		contentPanel.add(lblPrecio);
		
		textCodigo = new JTextField();
		textCodigo.setBounds(123, 71, 279, 20);
		contentPanel.add(textCodigo);
		textCodigo.setColumns(10);
		textCodigo.setToolTipText("Codigo de 4 numeros");
		
		textTitulo = new JTextField();
		textTitulo.setColumns(10);
		textTitulo.setBounds(123, 119, 279, 20);
		contentPanel.add(textTitulo);
		
		textAño = new JTextField();
		textAño.setColumns(10);
		textAño.setBounds(123, 218, 279, 20);
		contentPanel.add(textAño);
		
		textPuntuacion = new JTextField();
		textPuntuacion.setColumns(10);
		textPuntuacion.setBounds(123, 304, 279, 20);
		contentPanel.add(textPuntuacion);
		textPuntuacion.setToolTipText("Puntua entre 0-10");
		
		textISBN = new JTextField();
		textISBN.setColumns(10);
		textISBN.setBounds(123, 339, 279, 20);
		textISBN.setToolTipText("ISBN de 13 numeros");
		contentPanel.add(textISBN);
		
		textTomos = new JTextField();
		textTomos.setColumns(10);
		textTomos.setBounds(123, 373, 279, 20);
		contentPanel.add(textTomos);
		
		textPeriozidad = new JTextField();
		textPeriozidad.setColumns(10);
		textPeriozidad.setBounds(123, 443, 279, 20);
		contentPanel.add(textPeriozidad);
		textPeriozidad.setToolTipText("Cada cuanto tiempo sale ");
		
		comboEstado = new JComboBox();
		comboEstado.addItem("Proximamente");
		comboEstado.addItem("En emision");
		comboEstado.addItem("Finalizado");
		comboEstado.setSelectedIndex(-1);
		
		
		
		comboEstado.setBounds(123, 260, 279, 22);
		contentPanel.add(comboEstado);
		
		comboAutor = new JComboBox();
		comboAutor.setBounds(123, 168, 279, 22);
		contentPanel.add(comboAutor);
		
		btnAlta = new JButton("Alta");
		btnAlta.setBounds(412, 462, 80, 20);
		btnAlta.addActionListener(this);
		contentPanel.add(btnAlta);
		
	    btnModi = new JButton("Modi");
		btnModi.setBounds(412, 489, 80, 20);
		btnModi.addActionListener(this);
		contentPanel.add(btnModi);
		
		btnBaja = new JButton("Baja");
		btnBaja.setBounds(412, 520, 80, 20);
		btnBaja.addActionListener(this);
		contentPanel.add(btnBaja);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(412, 551, 80, 20);
		btnVolver.addActionListener(this);
		contentPanel.add(btnVolver);
		
		comboEditorial = new JComboBox();
		comboEditorial.setBounds(123, 408, 279, 22);
		contentPanel.add(comboEditorial);
		
		textPrecio = new JTextField();
		textPrecio.setColumns(10);
		textPrecio.setBounds(123, 477, 279, 20);
		contentPanel.add(textPrecio);
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblStock.setBounds(10, 507, 86, 23);
		contentPanel.add(lblStock);
		
		textStock = new JTextField();
		textStock.setColumns(10);
		textStock.setBounds(123, 508, 279, 20);
		contentPanel.add(textStock);
		
		cargarComboAutor(manga,com);
		cargarComboEditorial(manga,com);
		
		if(manga==null || com==null) {
			btnBaja.setEnabled(false);
			btnModi.setEnabled(false);
		}else {
			btnAlta.setEnabled(false);
			textCodigo.enable(false);
			cargarMangas(manga,com, au, ed);
		
		}
		
	
		
	}

	
	 

	private void cargarMangas(Manga manga, ContenidoMultimedia com, Autor au, Editorial ed) {
		// TODO Auto-generated method stub
		//Cargar el manga que has seleccionado al entrar por la vista de consultaManga
		textCodigo.setText(Integer.toString(com.getCodigo()));
		textISBN.setText(Integer.toString(manga.getIsbn()));
		textAño.setText(Integer.toString(com.getAñoInicio()));
		textPeriozidad.setText(manga.getPeriodicidad());
		textPrecio.setText(Float.toString(manga.getPrecio()));
		textPuntuacion.setText(Float.toString(com.getPuntuacion()));
		textStock.setText(Integer.toString(manga.getStock()));
		textTitulo.setText(com.getTitulo());
		textTomos.setText(Integer.toString(manga.getNumTomos()));
		comboEditorial.setSelectedItem(ed.getID_Editorial()+" | " +ed.getNombre());
		comboAutor.setSelectedItem(au.getDni() + " | " + au.getNombre());
		comboEstado.setSelectedItem(com.getEstado());
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnAlta)) {
			darAlta();
		}
		if(e.getSource().equals(btnBaja)) {
			baja(manga);
		}
		if(e.getSource().equals(btnModi)) {
			modificado(manga);
		}
		if(e.getSource().equals(btnVolver)) {
			volver();
		}
	}
	
	private String cogerAutor() {
		// coger la opcion seleccionada del combobox
		String dni;
		int donde;
			dni = (String) comboAutor.getSelectedItem();
			donde = dni.indexOf(" ");
			String au = dni.substring(0, donde);
			return au;
	}
	
	private String cogerEditorial() {
		String cadena;
		int donde;
		// coger la opcion seleccionada del combox
			cadena = (String) comboEditorial.getSelectedItem();
			donde = cadena.indexOf(" ");
			String id = cadena.substring(0, donde);
			return id;
	}
	
	private void modificado(Manga manga2) {
		// TODO Auto-generated method stub
		int cod = manga.getCodigo();
		Manga man = new Manga();


		
		if (validar()) {
			
			man.setCodigo(Integer.parseInt(textCodigo.getText()));
			man.setTitulo(textTitulo.getText());
			man.setPuntuacion(Float.parseFloat(textPuntuacion.getText()));
			man.setIsbn(Integer.parseInt(textISBN.getText()));
			man.setPeriodicidad(textPeriozidad.getText());
			man.setNumTomos(Integer.parseInt(textTomos.getText()));
			man.setPrecio(Float.parseFloat(textPrecio.getText()));
			man.setStock(Integer.parseInt(textStock.getText()));
			man.setAñoInicio(Integer.parseInt(textAño.getText()));

			man.setAutor(cogerAutor());

			man.setEstado(comboEstado.getSelectedItem().toString());
			man.setEditorial(cogerEditorial());

			if (dao.modManga(cod, man)) {
				JOptionPane.showMessageDialog(this, "Modificacion CORRECTO");
				limpiar();
				volver();
			} else {
				JOptionPane.showMessageDialog(null, "Modificacion INCORRECTO", "Error", JOptionPane.ERROR_MESSAGE);
				volver();
			}
		} else {

			JOptionPane.showMessageDialog(null, "Error, Comprueba los datos ", "Error de modificacion", JOptionPane.ERROR_MESSAGE);
		}
	

	}

	private void baja(Manga manga) {
		// TODO Auto-generated method stub
		int cod = manga.getCodigo();
		if(dao.borradoManga(cod)) {
			JOptionPane.showMessageDialog(this, "BAJA CORRECTA");
			
			
		}else {
			JOptionPane.showMessageDialog(null, "Error, Baja Incorrecta", "Baja", JOptionPane.ERROR_MESSAGE);
		}
		volver();
		
	}

	private void darAlta() {
		// TODO Auto-generated method stub

		Manga man = new Manga();


		if (validar()) {
			//en un Obejo manga pasamos los datos introducidos al dao
			man.setCodigo(Integer.parseInt(textCodigo.getText()));
			man.setTitulo(textTitulo.getText());
			man.setPuntuacion(Float.parseFloat(textPuntuacion.getText()));
			man.setIsbn(Integer.parseInt(textISBN.getText()));
			man.setPeriodicidad(textPeriozidad.getText());
			man.setNumTomos(Integer.parseInt(textTomos.getText()));
			man.setPrecio(Float.parseFloat(textPrecio.getText()));
			man.setStock(Integer.parseInt(textStock.getText()));
			man.setAñoInicio(Integer.parseInt(textAño.getText()));

			man.setAutor(cogerAutor());

			man.setEstado(comboEstado.getSelectedItem().toString());
			man.setEditorial(cogerEditorial());

			if (dao.altaManga(man)) {
				JOptionPane.showMessageDialog(this, "ALTA CORRECTO");
				limpiar();
			}

		} else {
			
			JOptionPane.showMessageDialog(null, "Error en algun parametro, Alta incorrecta", "Error Alta", JOptionPane.ERROR_MESSAGE);
		}
	}
	

	private void cargarComboAutor(Manga man, ContenidoMultimedia com) {
		String au;
		ArrayList<Autor> aut = dao.getAutor();
		int fila;
		//rellena la combobox con los datos de los autores
			for (int i = 0; i < aut.size(); i++) {
				comboAutor.addItem(aut.get(i).getDni() + " | " + aut.get(i).getNombre());
				
			}
			
			
				comboAutor.setSelectedIndex(-1);
			
	}
	
	
	private void cargarComboEditorial(Manga man, ContenidoMultimedia com) {
		Dao dao = new DaoImplementacion();
		ArrayList<Editorial> ed = dao.getEditorial();
		int fila;
		//Hace que el comboBox de WEditorial tenga las opciones de las Editoriales
		for (int i = 0; i < ed.size(); i++) {
			comboEditorial.addItem(ed.get(i).getID_Editorial()+" | " +ed.get(i).getNombre());
		}
			comboEditorial.setSelectedIndex(-1);
		
		
	}
	
	

	private void volver() {
		this.dispose();
	}
	
	private  boolean validar() {
		boolean bien=true;
		String letraMayus = "";
		//mirar que no hay datos vacios
		if(textCodigo.getText().equalsIgnoreCase(null) || textAño.getText().equalsIgnoreCase(null) || textISBN.getText().equalsIgnoreCase(null) || textPeriozidad.getText().equalsIgnoreCase(null)
			|| textPrecio.getText().equalsIgnoreCase(null) || textPuntuacion.getText().equalsIgnoreCase(null) || textStock.getText().equalsIgnoreCase(null) || textTitulo.getText().equalsIgnoreCase(null) || textTomos.getText().equalsIgnoreCase(null)
			|| comboEditorial.getSelectedIndex() ==-1 || comboAutor.getSelectedIndex() ==-1 || comboEstado.getSelectedIndex() ==-1) {
			
			bien = false;
			
			
		}else {
			//comprobar que el codigo es de 4 numeros
			Pattern pat = Pattern.compile("[0-9]{4}");
			Matcher mat = pat.matcher(textCodigo.getText());
			if(!mat.matches()) {
				bien=false;
			}
			/*
			 * Pattern pa = Pattern.compile("[0-9]{13}"); Matcher ma =
			 * pa.matcher(textISBN.getText()); if(!ma.matches()) { bien=false; }
			 */
			
			//mirar que la puntuacion este entr 0-10
			if(Float.parseFloat(textPuntuacion.getText()) < 0 || Float.parseFloat(textPuntuacion.getText()) > 10) {
				bien=false;
			}
			
			
		}
		
		
		return bien;
	}
	
	
	private void limpiar() {
		// TODO Auto-generated method stub
		//Psar los datos a nulos 
		
		textCodigo.setText(null);
		textISBN.setText(null);
		textAño.setText(null);
		textPeriozidad.setText(null);
		textPrecio.setText(null);
		textPuntuacion.setText(null);
		textStock.setText(null);
		textTitulo.setText(null);
		textTomos.setText(null);
		comboAutor.setSelectedIndex(-1);
		comboEditorial.setSelectedIndex(-1);
		comboEstado.setSelectedIndex(-1);
	}
}
