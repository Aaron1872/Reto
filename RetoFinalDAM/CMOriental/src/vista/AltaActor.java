package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Actor;
import clases.Proveedor;
import modelo.Dao;
import modelo.DaoImplementacion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JTextPane;
import javax.swing.JTextField;

public class AltaActor extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField textDNI;
	private JTextField textNombre;
	private JTextField textLugar;
	private Dao dao;
	private JButton btnVolver;
	private JButton btnBaja;
	private JButton btnModi;
	private JButton btnAlta;
	private JTextField textFecha;
	private Actor act;
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the dialog.
	 * @param object 
	 * @param dao 
	 * @param b 
	 */
	public AltaActor(boolean b, Dao dao, Actor object) {
		this.dao=dao;
		act=object;
		this.setModal(b);
		setBounds(100, 100, 509, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblDni = new JLabel("DNI: ");
			lblDni.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
			lblDni.setBounds(10, 57, 48, 29);
			contentPanel.add(lblDni);
		}
		{
			JLabel lblActor = new JLabel("ACTOR");
			lblActor.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
			lblActor.setBounds(10, 11, 79, 29);
			contentPanel.add(lblActor);
		}
		{
			JLabel lblNombre = new JLabel("Nombre: ");
			lblNombre.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
			lblNombre.setBounds(10, 97, 79, 29);
			contentPanel.add(lblNombre);
		}
		{
			JLabel lblFecha = new JLabel("Fecha Nacimiento: ");
			lblFecha.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
			lblFecha.setBounds(10, 177, 131, 29);
			contentPanel.add(lblFecha);
		}
		{
			JLabel lblLugarNacimiento = new JLabel("Lugar Nacimiento: ");
			lblLugarNacimiento.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
			lblLugarNacimiento.setBounds(10, 137, 131, 29);
			contentPanel.add(lblLugarNacimiento);
		}
		
		textDNI = new JTextField();
		textDNI.setBounds(68, 63, 319, 20);
		contentPanel.add(textDNI);
		textDNI.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(78, 103, 309, 20);
		contentPanel.add(textNombre);
		
		textLugar = new JTextField();
		textLugar.setColumns(10);
		textLugar.setBounds(145, 146, 242, 20);
		contentPanel.add(textLugar);
		
		btnAlta = new JButton("Alta");
		btnAlta.setBounds(403, 143, 80, 20);
		btnAlta.addActionListener(this);
		contentPanel.add(btnAlta);
		
		btnModi = new JButton("Modi");
		btnModi.setBounds(403, 174, 80, 20);
		btnModi.addActionListener(this);
		contentPanel.add(btnModi);
		
		btnBaja = new JButton("Baja");
		btnBaja.setBounds(403, 205, 80, 20);
		btnBaja.addActionListener(this);
		contentPanel.add(btnBaja);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(403, 236, 80, 20);
		btnVolver.addActionListener(this);
		contentPanel.add(btnVolver);
		
		textFecha = new JTextField();
		textFecha.setColumns(10);
		textFecha.setBounds(145, 183, 242, 20);
		contentPanel.add(textFecha);
		
		if(act==null) {
			btnBaja.setEnabled(false);
			btnModi.setEnabled(false);
		}else {
			btnAlta.setEnabled(false);
			textDNI.setEnabled(false);
			CargarActor(act);
		}
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnAlta)) {
			altaActor();	
			
		}
		if(e.getSource().equals(btnModi)) {
			modActor(act);
		}
		if(e.getSource().equals(btnBaja)) {
			baja(act);
		}
		if(e.getSource().equals(btnVolver)) {
			volver();
		}
	}
	
	private  boolean validar() {
		boolean bien=true;
		if(textDNI.getText().equalsIgnoreCase(null) && textNombre.getText().equalsIgnoreCase(null) && textFecha.getText().equalsIgnoreCase(null) && textLugar.getText().equalsIgnoreCase(null)) {
			bien = false;
		}
		
		
		
		
		return bien;
	}
	
	private void baja(Actor actt) {
		// TODO Auto-generated method stub
		String dni = actt.getDni();
		dao.bajaActor(dni);
		JOptionPane.showMessageDialog(null, "Actor borrado correctamente","Borrado",JOptionPane.INFORMATION_MESSAGE);
		volver();
	}
	
	private void modActor(Actor act) {
		// TODO Auto-generated method stub
		
		String dni = act.getDni();
		if(validar()) {
			Actor actt = new Actor();
			actt.setNombre(textNombre.getText());
			actt.setFechaNac(LocalDate.parse(textFecha.getText()));
			actt.setCiudadNac(textLugar.getText());
			
			dao.modiActor(dni, actt);
			limpiar();
			JOptionPane.showMessageDialog(null, "Actor modificado correctamente","Modificado",JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(null, "No puedes dejar parametros vacios", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		
	}
	private void altaActor() {
		// TODO Auto-generated method stub
		
		
		if(validar()) {
			
		Actor act = new Actor();
		act.setDni(textDNI.getText());
		act.setNombre(textNombre.getText());
		DateTimeFormatter formateador= DateTimeFormatter.ofPattern("dd-MM-yyyy");
		act.setFechaNac(LocalDate.parse(textFecha.getText(), formateador));
		act.setCiudadNac(textLugar.getText());
		dao.altaActor(act);
		
		limpiar();
		
		}else {
			JOptionPane.showMessageDialog(null, "No puedes dejar parametros vacios", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	

	public void CargarActor(Actor act) {
		
		textDNI.setText(act.getDni());
		textNombre.setText(act.getNombre());
		textFecha.setText(act.getFechaNac().toString());
		textLugar.setText(act.getCiudadNac());
		
		
	}
	private void volver() {
		this.dispose();
	}

	
	
	private void limpiar() {
		// TODO Auto-generated method stub
		textDNI.setText(null);
		textNombre.setText(null);
		textLugar.setText(null);
		textFecha.setText(null);
	}
}