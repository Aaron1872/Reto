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

public class AltaEstudio extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textNombre;
	private JTextField textFecha;
	private JTextField textCaract;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AltaEstudio dialog = new AltaEstudio();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AltaEstudio() {
		setBounds(100, 100, 639, 253);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblEstudio = new JLabel("Estudio");
			lblEstudio.setFont(new Font("Comic Sans MS", Font.BOLD, 19));
			lblEstudio.setBounds(10, 11, 85, 35);
			contentPanel.add(lblEstudio);
		}
		{
			JLabel lblNombre = new JLabel("Nombre");
			lblNombre.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
			lblNombre.setBounds(33, 71, 85, 35);
			contentPanel.add(lblNombre);
		}
		{
			JLabel lblFechaFundacion = new JLabel("Fecha fundacion");
			lblFechaFundacion.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
			lblFechaFundacion.setBounds(33, 117, 137, 35);
			contentPanel.add(lblFechaFundacion);
		}
		{
			JLabel lblCaracteristicas = new JLabel("Caracteristicas");
			lblCaracteristicas.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
			lblCaracteristicas.setBounds(33, 163, 124, 35);
			contentPanel.add(lblCaracteristicas);
		}
		{
			textNombre = new JTextField();
			textNombre.setColumns(10);
			textNombre.setBounds(178, 81, 341, 20);
			contentPanel.add(textNombre);
		}
		{
			textFecha = new JTextField();
			textFecha.setColumns(10);
			textFecha.setBounds(180, 127, 341, 20);
			contentPanel.add(textFecha);
		}
		{
			textCaract = new JTextField();
			textCaract.setColumns(10);
			textCaract.setBounds(178, 173, 341, 20);
			contentPanel.add(textCaract);
		}
		{
			JButton btnModi = new JButton("Modi");
			btnModi.setBounds(531, 112, 80, 20);
			contentPanel.add(btnModi);
		}
		{
			JButton btnBaja = new JButton("Baja");
			btnBaja.setBounds(531, 142, 80, 20);
			contentPanel.add(btnBaja);
		}
		{
			JButton btnVolver = new JButton("Volver");
			btnVolver.setBounds(531, 173, 80, 20);
			contentPanel.add(btnVolver);
		}
		{
			JButton btnAlta = new JButton("Alta");
			btnAlta.setBounds(531, 81, 80, 20);
			contentPanel.add(btnAlta);
		}
	}

}
