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
import javax.swing.JComboBox;

public class ConsltaAutor extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try {
			ConsltaAutor dialog = new ConsltaAutor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConsltaAutor() {
		setBounds(100, 100, 509, 156);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblAutor = new JLabel("AUTOR");
			lblAutor.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
			lblAutor.setBounds(10, 11, 79, 29);
			contentPanel.add(lblAutor);
		}
		
		JButton btnConsultas = new JButton("Consulta");
		btnConsultas.setBounds(396, 35, 87, 29);
		contentPanel.add(btnConsultas);
		
		JComboBox comboAutor = new JComboBox();
		comboAutor.setBounds(10, 64, 355, 43);
		contentPanel.add(comboAutor);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(396, 78, 87, 29);
		contentPanel.add(btnVolver);
	}
}
