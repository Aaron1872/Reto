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
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;

public class RegistrarseUsuario extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField tIntroNombre;
	private JTextField tIntroEmal;
	private JTextField tIntroApellido;
	private JTextField tIntroNombreU;
	private JButton btnRegistrar;
	private JButton btnVolver;
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
		contentPanel.setBackground(new Color(240, 240, 240));
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
		tIntroNombre.setToolTipText("Introduce tu nombre");
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
		tIntroEmal.setToolTipText("Introduce un email valido");
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Apellido :");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(39, 182, 73, 17);
		contentPanel.add(lblNewLabel_1_1_1);
		
		tIntroApellido = new JTextField();
		tIntroApellido.setColumns(10);
		tIntroApellido.setBounds(164, 182, 201, 20);
		tIntroApellido.setToolTipText("Introduce tu apellido");
		contentPanel.add(tIntroApellido);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Nombre Usuario :");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1.setBounds(39, 229, 114, 17);
		contentPanel.add(lblNewLabel_1_1_1_1);
		
		tIntroNombreU = new JTextField();
		tIntroNombreU.setColumns(10);
		tIntroNombreU.setBounds(163, 229, 201, 20);
		tIntroNombreU.setToolTipText("Introduce tu nombre como usuario");
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
		
		btnVolver = new JButton("volver");
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVolver.setBounds(39, 332, 97, 31);
		btnVolver.addActionListener(this);
		contentPanel.add(btnVolver);
		
	}
	
		

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource().equals(btnRegistrar)) {
				registroUsuario();
			}
			if(e.getSource().equals(btnVolver)) {
				volver();
			}
		}

		private void volver() {
			// TODO Auto-generated method stub
			this.dispose();
			InicioSesionRegistro ini = new InicioSesionRegistro(dao);
			ini.setVisible(true);
			
		}
		private void registroUsuario() {
			// TODO Auto-generated method stub
			
			
			Usuarios usu;
			usu = new Usuarios();
			
			if(validar()) {
				
			
			usu.setEmail(tIntroEmal.getText());
			usu.setNombre(tIntroNombre.getText());
			usu.setApellido(tIntroApellido.getText());
			usu.setContraseña(tIntroContraseña.getText());
			
			//Pasamos los datos y al registrar se abre la vista de Iniciar sesion
			dao.altaUsuario(usu);
			JOptionPane.showMessageDialog(null, "Registrado","Registro",JOptionPane.INFORMATION_MESSAGE);
			IniciarSesion ins = new IniciarSesion(null, true, dao);
			this.dispose();
			ins.setVisible(true);
			
			
			}else {
				JOptionPane.showMessageDialog(null, "Error al registrarse", "Error", JOptionPane.ERROR_MESSAGE);
			}
			
			limpiar();
		}
  
		private  boolean validar() {
			boolean bien=true;
			String letraMayus = "";
			if(tIntroEmal.getText().equalsIgnoreCase(null) || tIntroNombre.getText().equalsIgnoreCase(null) || tIntroNombreU.getText().equalsIgnoreCase(null) || tIntroApellido.getText().equalsIgnoreCase(null) || tIntroContraseña.getText().equalsIgnoreCase(null)) {
				bien = false;
				
			}else {
				//Comprueba el email mira si tiene un @ y mas tarde un . 
				Pattern pattern = Pattern
		                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
				
				Matcher mat = pattern.matcher(tIntroEmal.getText());
				if(!mat.matches()) {
					bien=false;
				}
				
				
			}
			
			
			return bien;
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
