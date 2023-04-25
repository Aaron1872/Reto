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

public class Admin extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Admin dialog = new Admin();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Admin() {
		setBounds(100, 100, 494, 512);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 478, 1);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel lblAdmin = new JLabel("ADMIN");
		lblAdmin.setFont(new Font("Comic Sans MS", Font.PLAIN, 23));
		lblAdmin.setBounds(10, 0, 100, 33);
		getContentPane().add(lblAdmin);
		
		JButton btnAltaAnime = new JButton("Alta Anime");
		btnAltaAnime.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnAltaAnime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAltaAnime.setBounds(10, 59, 158, 44);
		getContentPane().add(btnAltaAnime);
		
		JButton btnAltaManga = new JButton("Alta Manga");
		btnAltaManga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAltaManga.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnAltaManga.setBounds(10, 135, 158, 44);
		getContentPane().add(btnAltaManga);
		
		JButton btnAltaActor = new JButton("Alta Actor");
		btnAltaActor.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnAltaActor.setBounds(10, 203, 158, 44);
		getContentPane().add(btnAltaActor);
		
		JButton btnAltaAutor = new JButton("Alta Autor");
		btnAltaAutor.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnAltaAutor.setBounds(10, 276, 158, 44);
		getContentPane().add(btnAltaAutor);
		
		JButton btnAltaProveedor = new JButton("Alta Proveedor");
		btnAltaProveedor.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnAltaProveedor.setBounds(10, 418, 158, 44);
		getContentPane().add(btnAltaProveedor);
		
		JButton btnModborAnime = new JButton("Mod/Bor Anime");
		btnModborAnime.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnModborAnime.setBounds(246, 59, 195, 44);
		getContentPane().add(btnModborAnime);
		
		JButton btnModborManga = new JButton("Mod/Bor Manga");
		btnModborManga.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnModborManga.setBounds(246, 135, 195, 44);
		getContentPane().add(btnModborManga);
		
		JButton btnModborActor = new JButton("Mod/Bor Actor");
		btnModborActor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModborActor.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnModborActor.setBounds(246, 203, 195, 44);
		getContentPane().add(btnModborActor);
		
		JButton btnModborEstudio = new JButton("Mod/Bor Estudio");
		btnModborEstudio.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnModborEstudio.setBounds(246, 349, 195, 44);
		getContentPane().add(btnModborEstudio);
		
		JButton btnModborProveedor = new JButton("Mod/Bor Proveedor");
		btnModborProveedor.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnModborProveedor.setBounds(246, 418, 195, 44);
		getContentPane().add(btnModborProveedor);
		
		JButton btnAltaEstudio = new JButton("Alta Estudio");
		btnAltaEstudio.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnAltaEstudio.setBounds(10, 349, 158, 44);
		getContentPane().add(btnAltaEstudio);
		
		JButton btnAltaAnime_8_1 = new JButton("Mod/Bor Autor");
		btnAltaAnime_8_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnAltaAnime_8_1.setBounds(246, 276, 195, 44);
		getContentPane().add(btnAltaAnime_8_1);
	}
}
