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

public class RegistrarseUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tIntroNombre;
	private JTextField tIntroEmal;
	private JTextField tIntroApellido;
	private JTextField tIntroNombreU;
	private JTextField tIntroContraseña;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 * @param b 
	 * @param inicioSesionRegistro 
	 */
	public RegistrarseUsuario(InicioSesionRegistro inicioSesionRegistro, boolean b) {
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
		
		tIntroContraseña = new JTextField();
		tIntroContraseña.setColumns(10);
		tIntroContraseña.setBounds(164, 276, 201, 20);
		contentPanel.add(tIntroContraseña);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRegistrar.setBounds(321, 332, 97, 31);
		contentPanel.add(btnRegistrar);
	}
}
