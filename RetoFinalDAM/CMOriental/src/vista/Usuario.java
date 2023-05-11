package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Dao;

import javax.swing.JLabel;
import java.awt.Font;

public class Usuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Dao dao;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 * @param dao 
	 */
	public Usuario(Dao dao) {
		this.dao=dao;
		setBounds(100, 100, 450, 244);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblUsuarios = new JLabel("USUARIOS");
			lblUsuarios.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
			lblUsuarios.setBounds(24, 0, 102, 29);
			contentPanel.add(lblUsuarios);
		}
		{
			JButton btnAnime = new JButton("Anime");
			btnAnime.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			btnAnime.setBounds(24, 101, 158, 44);
			contentPanel.add(btnAnime);
		}
		{
			JButton btnManga = new JButton("Manga");
			btnManga.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			btnManga.setBounds(247, 101, 158, 44);
			contentPanel.add(btnManga);
		}
		{
			JButton btnVolver = new JButton("Volver");
			btnVolver.setBounds(325, 174, 80, 20);
			contentPanel.add(btnVolver);
		}
		{
			JLabel lblInfo = new JLabel("De que tipo de Contenido quieres informate");
			lblInfo.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
			lblInfo.setBounds(59, 40, 308, 50);
			contentPanel.add(lblInfo);
		}
	}

}
