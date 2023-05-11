package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Usuarios;
import modelo.Dao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class IniciarSesion extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField textNomUsuario;
	private JPasswordField textContraseña;
	private JButton btnLogin;
	private Dao dao;
	private JButton btnVolver ;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 * @param b 
	 * @param inicioSesionRegistro 
	 */
	public IniciarSesion(InicioSesionRegistro inicioSesionRegistro, boolean modal, Dao dao) {
		this.setModal(modal);
		this.dao=dao;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nombre Usuario :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(27, 69, 146, 35);
		contentPanel.add(lblNewLabel);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a :");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblContrasea.setBounds(27, 161, 146, 35);
		contentPanel.add(lblContrasea);

		textNomUsuario = new JTextField();
		textNomUsuario.setBounds(183, 75, 210, 26);
		contentPanel.add(textNomUsuario);
		textNomUsuario.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Iniciar Sesion");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setBounds(156, 11, 146, 43);
		contentPanel.add(lblNewLabel_1);

		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLogin.setBounds(304, 224, 89, 26);
		btnLogin.addActionListener(this);
		contentPanel.add(btnLogin);

		textContraseña = new JPasswordField();
		textContraseña.setBounds(183, 161, 210, 29);
		contentPanel.add(textContraseña);
		
		btnVolver = new JButton("volver");
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVolver.setBounds(41, 227, 89, 26);
		btnVolver.addActionListener(this);
		contentPanel.add(btnVolver);
	}
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(btnLogin)) {
			iniciarSesion();
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


	public void iniciarSesion() {
		char[] clave = textContraseña.getPassword();
		String claveFinal = new String(clave);
		Usuarios usu = null;
		String nombre = textNomUsuario.getText();
		String contraseña = textContraseña.getText();
		boolean admin=false;

		
		if (dao.consultaUsuario(nombre, contraseña) && nombre.equalsIgnoreCase("Admin")) {
			dispose();
			JOptionPane.showMessageDialog(null, "Bienvenido al Sistema","Ingresaste como administrador",JOptionPane.INFORMATION_MESSAGE);
			Admin a = new Admin(dao);
			a.setVisible(true);
		}else if(dao.consultaUsuario(nombre, contraseña)) {
			dispose();
			JOptionPane.showMessageDialog(null, "Bienvenido al Sistema","Ingresaste como usuario",JOptionPane.INFORMATION_MESSAGE);
			Usuario u = new Usuario(dao);
			u.setVisible(true);
		}else {
			JOptionPane.showMessageDialog(null, "Usuario o Contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
			textNomUsuario.setText("");
			textContraseña.setText("");
			textNomUsuario.requestFocus();
		} 
	}
}