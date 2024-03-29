package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;

public class Manga extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tableManga;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Manga dialog = new Manga();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Manga() {
		setBounds(100, 100, 450, 244);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblUsuarios = new JLabel("Manga");
			lblUsuarios.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
			lblUsuarios.setBounds(10, 0, 102, 29);
			contentPanel.add(lblUsuarios);
		}
		{
			JButton btnVolver = new JButton("Volver");
			btnVolver.setBounds(242, 174, 80, 20);
			contentPanel.add(btnVolver);
		}
		{
			JButton btnComprar = new JButton("Comprar");
			btnComprar.setBounds(344, 173, 80, 20);
			contentPanel.add(btnComprar);
		}
		
		tableManga = new JTable();
		tableManga.setBounds(41, 40, 365, 110);
		contentPanel.add(tableManga);
	}
}
