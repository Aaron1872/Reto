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

public class ConsltaAnime extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try {
			ConsltaAnime dialog = new ConsltaAnime();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConsltaAnime() {
		setBounds(100, 100, 509, 156);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblAnime = new JLabel("ANIME");
			lblAnime.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
			lblAnime.setBounds(10, 11, 79, 29);
			contentPanel.add(lblAnime);
		}
		
		JButton btnConsulta = new JButton("Consulta");
		btnConsulta.setBounds(396, 35, 87, 29);
		contentPanel.add(btnConsulta);
		
		JComboBox comboAnime = new JComboBox();
		comboAnime.setBounds(10, 64, 355, 43);
		contentPanel.add(comboAnime);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(396, 78, 87, 29);
		contentPanel.add(btnVolver);
	}
}
