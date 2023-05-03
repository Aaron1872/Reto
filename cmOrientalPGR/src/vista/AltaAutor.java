package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class AltaAutor extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textDNI;
	private JTextField textNombre;
	private JTextField textCiudad;
	private JTextField textFecha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AltaAutor dialog = new AltaAutor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AltaAutor() {
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
		
		JButton btnAlta = new JButton("Modi");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAlta.setBounds(472, 268, 80, 20);
		contentPanel.add(btnAlta);
		
		JButton btnAlta_1 = new JButton("Baja");
		btnAlta_1.setBounds(472, 299, 80, 20);
		contentPanel.add(btnAlta_1);
		
		JButton btnAlta_2 = new JButton("Volver");
		btnAlta_2.setBounds(472, 330, 80, 20);
		contentPanel.add(btnAlta_2);
		
		JButton btnAlta_3 = new JButton("Alta");
		btnAlta_3.setBounds(472, 237, 80, 20);
		contentPanel.add(btnAlta_3);
		
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
		textFecha.setBounds(181, 199, 270, 151);
		contentPanel.add(textFecha);
	}
}
