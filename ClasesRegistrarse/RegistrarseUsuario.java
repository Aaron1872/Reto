package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Dao;
import clases.Usuarios;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class RegistrarseUsuario extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField tIntroNombre;
	private JTextField tIntroEmal;
	private JTextField tIntroApellido;
	private JTextField tIntroNombreU;
	private JButton btnRegistrar;
	private Dao dao;
	private JPasswordField tIntroContraseña;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 * @param b 
	 * @param inicioSesionRegistro 
	 */
	public RegistrarseUsuario(InicioSesionRegistro vent, boolean modal, Dao dao) {
		super(vent);
		this.dao=dao;
		this.setModal(modal);
		setBounds(100, 100, 461, 413);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registrarse");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(163, 27, 111, 45);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(39, 134, 73, 17);
		contentPanel.add(lblNewLabel_1);
		
		tIntroNombre = new JTextField();
		tIntroNombre.setBounds(164, 134, 201, 20);
		contentPanel.add(tIntroNombre);
		tIntroNombre.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Email :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(39, 83, 73, 17);
		contentPanel.add(lblNewLabel_1_1);
		
		tIntroEmal = new JTextField();
		tIntroEmal.setColumns(10);
		tIntroEmal.setBounds(164, 83, 201, 20);
		contentPanel.add(tIntroEmal);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Apellido :");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(39, 182, 73, 17);
		contentPanel.add(lblNewLabel_1_1_1);
		
		tIntroApellido = new JTextField();
		tIntroApellido.setColumns(10);
		tIntroApellido.setBounds(164, 182, 201, 20);
		contentPanel.add(tIntroApellido);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Nombre Usuario :");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1.setBounds(39, 229, 114, 17);
		contentPanel.add(lblNewLabel_1_1_1_1);
		
		tIntroNombreU = new JTextField();
		tIntroNombreU.setColumns(10);
		tIntroNombreU.setBounds(163, 229, 201, 20);
		contentPanel.add(tIntroNombreU);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Contrase\u00F1a :");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_1.setBounds(39, 276, 103, 17);
		contentPanel.add(lblNewLabel_1_1_1_1_1);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRegistrar.setBounds(321, 332, 97, 31);
		btnRegistrar.addActionListener(this);
		contentPanel.add(btnRegistrar);
		
		tIntroContraseña = new JPasswordField();
		tIntroContraseña.setBounds(164, 276, 201, 20);
		contentPanel.add(tIntroContraseña);
		
	}
	
		
		private String  generarCodigo() {
			// TODO Auto-generated method stub
			
		    int i = 0;
			i++;
			String codigo=String.format("%04d",i);
			
			return codigo;
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource().equals(btnRegistrar)) {
				registroUsuario();
			}
		}


		private void registroUsuario() {
			// TODO Auto-generated method stub
			Usuarios usu;
			usu = new Usuarios();
			
			
			usu.setEmail(tIntroEmal.getText());
			usu.setNombre(tIntroNombre.getText());
			usu.setApellido(tIntroApellido.getText());
			usu.setContraseña(tIntroContraseña.getText());
			
			dao.altaUsuario(usu);
			
			limpiar();
		}


		private void limpiar() {
			// TODO Auto-generated method stub
			tIntroEmal.setText(null);
			tIntroNombre.setText(null);
			tIntroApellido.setText(null);
			tIntroContraseña.setText(null);
			tIntroNombreU.setText(null);
		}
}
