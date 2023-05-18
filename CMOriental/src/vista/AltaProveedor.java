package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Proveedor;
import modelo.Dao;
import modelo.DaoImplementacion;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextPane;
import javax.swing.JTextField;

public class AltaProveedor extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField textNif;
	private JTextField textNombre;
	private JTextField textLugar;
	private Dao dao;
	private JButton btnVolver;
	private JButton btnBaja;
	private JButton btnModi;
	private JButton btnAlta;
	private Proveedor prov;
	private String Snif; 
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 * @param pro 
	 * @param modal 
	 * @param padre 
	 * @param consulta 
	 */
	public AltaProveedor( boolean modal, Dao dao, Proveedor pro) {
		this.setModal(modal);
		this.dao=dao;
		prov=pro;
		
		setBounds(100, 100, 498, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblDni = new JLabel("NIF:");
			lblDni.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
			lblDni.setBounds(10, 42, 48, 29);
			contentPanel.add(lblDni);
		}
		{
			JLabel lblActor = new JLabel("Proveedor");
			lblActor.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
			lblActor.setBounds(10, 11, 79, 29);
			contentPanel.add(lblActor);
		}
		{
			JLabel lblNombre = new JLabel("Nombre: ");
			lblNombre.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
			lblNombre.setBounds(10, 82, 79, 29);
			contentPanel.add(lblNombre);
		}
		{
			JLabel textDirec = new JLabel("Direcci\u00F3n:");
			textDirec.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
			textDirec.setBounds(10, 122, 131, 29);
			contentPanel.add(textDirec);
		}
		
		textNif = new JTextField();
		textNif.setBounds(56, 48, 309, 20);
		contentPanel.add(textNif);
		textNif.setToolTipText("Un NIF de 8 numeros 1 letra ");
		textNif.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(78, 88, 287, 20);
		textNombre.setToolTipText("Introduce el nombre del proveedor");
		contentPanel.add(textNombre);
		
		textLugar = new JTextField();
		textLugar.setColumns(10);
		textLugar.setBounds(88, 128, 277, 20);
		textLugar.setToolTipText("Donde esta el proveedor");
		contentPanel.add(textLugar);
		{
			btnVolver = new JButton("Volver");
			btnVolver.setBounds(392, 207, 80, 20);
			btnVolver.addActionListener(this);
			contentPanel.add(btnVolver);
		}
		{
			btnBaja = new JButton("Baja");
			btnBaja.setBounds(392, 176, 80, 20);
			btnBaja.addActionListener(this);
			contentPanel.add(btnBaja);
		}
		{
			btnModi = new JButton("Modi");
			btnModi.setBounds(392, 145, 80, 20);
			btnModi.addActionListener(this);
			contentPanel.add(btnModi);
		}
		{
			btnAlta = new JButton("Alta");
			btnAlta.setBounds(392, 114, 80, 20);
			btnAlta.addActionListener(this);
			contentPanel.add(btnAlta);
		}
		
		if(pro == null) {
			btnBaja.setEnabled(false);
			btnModi.setEnabled(false);
			
		}else {
			btnAlta.setEnabled(false);
			textNif.enable(false);
			CargarProvedior(pro);
		}
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Snif =  textNif.getText();
		if(e.getSource().equals(btnAlta)) {
			AltaPro();
		}
		if(e.getSource().equals(btnModi)) {
			modificado(prov);
		}
		if(e.getSource().equals(btnBaja)) {
			borrado(prov);
		}
		if(e.getSource().equals(btnVolver)) {
			volver();
		}
		
		
		
		
	}
	
	
	
	private void modificado(Proveedor pro) {
		// TODO Auto-generated method stub
		String modnif=pro.getNif();
	
		if(validar()) {
			Proveedor prov = new Proveedor();
			
			prov.setNombre(textNombre.getText());
			prov.setUbicacion(textLugar.getText());
			prov.setNif(textNif.getText());
			
			dao.modificarProveedor(modnif, prov);
			limpiar();
			volver();
			JOptionPane.showMessageDialog(null, "Proveedor modificado correctamente","Borrado",JOptionPane.INFORMATION_MESSAGE);
		}
		
		
		
		
	}

	private void borrado(Proveedor pro) {
		// TODO Auto-generated method stub
		String nif=pro.getNif();
		
		dao.borradoProveedor(nif);
		limpiar();
		JOptionPane.showMessageDialog(null, "Proveedor borrado correctamente","Borrado",JOptionPane.INFORMATION_MESSAGE);
		volver();
	}

	private void AltaPro() {
		// TODO Auto-generated method stub
		
		if(validar()) {
			
			Proveedor pro = new Proveedor();
			//pro.setNif(textNif.getText());
			pro.setNombre(textNombre.getText());
			pro.setUbicacion(textLugar.getText());
			pro.setNif(textNif.getText());
			
			dao.altaProveedoro(pro);
			JOptionPane.showMessageDialog(null, "Alta hecha correctamente","Alta",JOptionPane.INFORMATION_MESSAGE);
			limpiar();
		}else {
			JOptionPane.showMessageDialog(null, "No puedes dejar parametros vacios", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		
		
	}

	private void limpiar() {
		// TODO Auto-generated method stub
		textNif.setText(null);
		textNombre.setText(null);
		textLugar.setText(null);
	}

	private void volver() {
		this.dispose();
	}

	
	public void CargarProvedior(Proveedor pro) {
		textNombre.setText(pro.getNombre());
		textNif.setText(pro.getNif());
		textLugar.setText(pro.getUbicacion());
		
		
	}
	
	
	private  boolean validar() {
		boolean bien=true;
		String letraMayus = "";
		if(textNif.getText().equalsIgnoreCase(null) || textNombre.getText().equalsIgnoreCase(null) || textLugar.getText().equalsIgnoreCase(null) ) {
			bien = false;
			
			
		}else {
			Pattern pat = Pattern.compile("[0-9]{8,9}[A-Z]");
			Matcher mat = pat.matcher(textNif.getText());
			
			if(!mat.matches()) {
				bien=false;
			}
			
			
		}
		
		
		return bien;
	}
	
}
