package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class IniciarSesion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textNomUsuario;
	private JTextField textContraseña;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the dialog.
	 * @param b 
	 * @param inicioSesionRegistro 
	 */
	public IniciarSesion(InicioSesionRegistro inicioSesionRegistro, boolean modal) {
		this.setModal(modal);
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
		
		textContraseña = new JTextField();
		textContraseña.setColumns(10);
		textContraseña.setBounds(183, 167, 210, 26);
		contentPanel.add(textContraseña);
		
		JLabel lblNewLabel_1 = new JLabel("Iniciar Sesion");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setBounds(156, 11, 146, 43);
		contentPanel.add(lblNewLabel_1);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLogin.setBounds(304, 224, 89, 26);
		contentPanel.add(btnLogin);
	}
}