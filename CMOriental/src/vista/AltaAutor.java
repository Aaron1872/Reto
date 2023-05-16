package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Autor;
import modelo.Dao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class AltaAutor extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField textDNI;
	private JTextField textNombre;
	private JTextField textCiudad;
	private JTextField textFecha;
	private JButton btnAlta ;
	private Dao dao;
	private Autor au;
	private JButton btnVolver;
	private JButton btnBaja;
	private JButton btnMod;
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the dialog.
	 * @param object 
	 * @param dao 
	 * @param b 
	 */
	public AltaAutor(boolean b, Dao dao, Autor object) {
		this.dao=dao;
		au=object;
		this.setModal(b);
		setBounds(100, 100, 578, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setFont(new Font("Comic Sans MS", Font.BOLD, 19));
		lblAutor.setBounds(10, 11, 97, 42);
		contentPanel.add(lblAutor);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblDni.setBounds(32, 75, 97, 42);
		contentPanel.add(lblDni);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblNombre.setBounds(32, 110, 97, 42);
		contentPanel.add(lblNombre);
		
		JLabel lblCiudadNacimiento = new JLabel("Ciudad Nacimiento");
		lblCiudadNacimiento.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblCiudadNacimiento.setBounds(32, 148, 139, 42);
		contentPanel.add(lblCiudadNacimiento);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento");
		lblFechaNacimiento.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblFechaNacimiento.setBounds(32, 185, 139, 42);
		contentPanel.add(lblFechaNacimiento);
		
		btnMod = new JButton("Modi");
		btnMod.setBounds(472, 268, 80, 20);
		btnMod.addActionListener(this);
		contentPanel.add(btnMod);
		
		btnBaja = new JButton("Baja");
		btnBaja.setBounds(472, 299, 80, 20);
		btnBaja.addActionListener(this);
		contentPanel.add(btnBaja);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(472, 330, 80, 20);
		btnVolver.addActionListener(this);
		contentPanel.add(btnVolver);
		
		btnAlta = new JButton("Alta");
		btnAlta.setBounds(472, 237, 80, 20);
		btnAlta.addActionListener(this);
		contentPanel.add(btnAlta);
		
		textDNI = new JTextField();
		textDNI.setColumns(10);
		textDNI.setBounds(92, 89, 408, 20);
		contentPanel.add(textDNI);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(102, 124, 398, 20);
		contentPanel.add(textNombre);
		
		textCiudad = new JTextField();
		textCiudad.setColumns(10);
		textCiudad.setBounds(181, 162, 319, 20);
		contentPanel.add(textCiudad);
		
		textFecha = new JTextField();
		textFecha.setColumns(10);
		textFecha.setBounds(181, 199, 270, 20);
		contentPanel.add(textFecha);
		
		//Dependiendo si entras desde admin o consulta tienes avilitados unos botones u otros
		
		if(au==null) {
			btnBaja.setEnabled(false);
			btnMod.setEnabled(false);
		}else {
			btnAlta.setEnabled(false);
			textDNI.enable(false);
			CargarAutor(au);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource().equals(btnAlta)) {
			altaAu();
		}
		if(e.getSource().equals(btnMod)) {
			modAutor(au);
		}
		if(e.getSource().equals(btnVolver)) {
			volver();
		}
		if(e.getSource().equals(btnBaja)) {
			borrado(au);
		}
	}
	
	
	private void borrado(Autor au) {
		// TODO Auto-generated method stub
		
		//pasamos el dni para saber el autor que vamos a borrar
		String dni = au.getDni();
		dao.borraAutor(dni);
		limpiar();
		
	}
	
	private void modAutor(Autor au) {
		// TODO Auto-generated method stub
		if (validar()) {
			//pasamos los datos nuevos
			String dni = au.getDni();
			Autor aut = new Autor();
			aut.setNombre(textNombre.getText());
			aut.setCiudadNac(textCiudad.getText());
			aut.setFechaNac(LocalDate.parse(textFecha.getText()));
			dao.modAutor(dni, aut);
			limpiar();

			JOptionPane.showMessageDialog(null, "Autor modificado correctamente", "Modificado",JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Error al introducir datos", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void volver() {
		
		this.dispose();
		
	}
	
	private  boolean validar() {
		boolean bien=true;
		String letraMayus = "";
		//Para que no deje nada vacio
		if(textDNI.getText().equalsIgnoreCase(null) || textNombre.getText().equalsIgnoreCase(null) || textCiudad.getText().equalsIgnoreCase(null) || textFecha.getText().equalsIgnoreCase(null)) {
			bien = false;
			
			
		}else {
			//Valida el dni comprueba que tenga 8 numeros y al final una letra
			
			Pattern pat = Pattern.compile("[0-9]{8,9}[A-Z]");
			Matcher mat = pat.matcher(textDNI.getText());
			if(!mat.matches()) {
				bien=false;
			}
			
			
		}
		
		
		return bien;
	}
	
	
	private void altaAu() {
		// TODO Auto-generated method stub
		
		if(validar()) {
		//psamos los datos que ha escrito al dao por el objeto au
		DateTimeFormatter formateador= DateTimeFormatter.ofPattern("dd-MM-yyyy");
		Autor au =new Autor();
		au.setDni(textDNI.getText());
		au.setNombre(textNombre.getText());
		au.setCiudadNac(textCiudad.getText());
		au.setFechaNac(LocalDate.parse(textFecha.getText(), formateador));
		dao.altaAutor(au);
		
		limpiar();
		JOptionPane.showMessageDialog(null, "Alta correcta", "Alta",JOptionPane.INFORMATION_MESSAGE);
		
		}else {
			JOptionPane.showMessageDialog(null, "No puedes dejar parametros vacios", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public void CargarAutor(Autor au) {
		//Al entrar por consulta se rellena automaticamente con el selecccionado
		textDNI.setText(au.getDni());
		textNombre.setText(au.getNombre());
		textFecha.setText(au.getFechaNac().toString());
		textCiudad.setText(au.getCiudadNac());
		
	}
	
	private void limpiar() {
		// TODO Auto-generated method stub
		//Pone los parametros vacios
		textDNI.setText(null);
		textNombre.setText(null);
		textCiudad.setText(null);
		textFecha.setText(null);
	}
	
	
}
