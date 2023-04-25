package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JTextField;

public class AltaProveedor extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textDNI;
	private JTextField textNombre;
	private JTextField textLugar;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try {
			AltaProveedor dialog = new AltaProveedor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AltaProveedor() {
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
			JLabel lblActor = new JLabel("ACTOR");
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
			JLabel lblA = new JLabel("Ubicaci\u00F3n:");
			lblA.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
			lblA.setBounds(10, 162, 131, 29);
			contentPanel.add(lblA);
		}
		{
			JLabel lblLugarNacimiento = new JLabel("Direcci\u00F3n:");
			lblLugarNacimiento.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
			lblLugarNacimiento.setBounds(10, 122, 131, 29);
			contentPanel.add(lblLugarNacimiento);
		}
		
		textDNI = new JTextField();
		textDNI.setBounds(56, 48, 309, 20);
		contentPanel.add(textDNI);
		textDNI.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(78, 88, 287, 20);
		contentPanel.add(textNombre);
		
		textLugar = new JTextField();
		textLugar.setColumns(10);
		textLugar.setBounds(88, 128, 277, 20);
		contentPanel.add(textLugar);
		{
			JLabel lblPaginaWeb = new JLabel("Pagina Web:");
			lblPaginaWeb.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
			lblPaginaWeb.setBounds(10, 201, 131, 29);
			contentPanel.add(lblPaginaWeb);
		}
		{
			textField = new JTextField();
			textField.setColumns(10);
			textField.setBounds(88, 168, 277, 20);
			contentPanel.add(textField);
		}
		{
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(98, 207, 267, 20);
			contentPanel.add(textField_1);
		}
		{
			JButton btnVolver = new JButton("Volver");
			btnVolver.setBounds(392, 207, 80, 20);
			contentPanel.add(btnVolver);
		}
		{
			JButton btnBaja = new JButton("Baja");
			btnBaja.setBounds(392, 176, 80, 20);
			contentPanel.add(btnBaja);
		}
		{
			JButton btnModi = new JButton("Modi");
			btnModi.setBounds(392, 145, 80, 20);
			contentPanel.add(btnModi);
		}
		{
			JButton btnAlta = new JButton("Alta");
			btnAlta.setBounds(392, 114, 80, 20);
			contentPanel.add(btnAlta);
		}
	}
}
