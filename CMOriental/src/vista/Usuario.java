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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Usuario extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private Dao dao;
	private JButton btnManga;
	private JButton btnAnime;
	private JButton btnVolver;
	private int cod;
	private JButton btnVerCompras;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 * @param dao 
	 * @param cod 
	 * @param cod 
	 */
	public Usuario(Dao dao, int cod) {
		this.dao=dao;
		this.cod=cod;
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
			btnAnime = new JButton("Anime");
			btnAnime.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			btnAnime.setBounds(24, 101, 158, 44);
			btnAnime.addActionListener(this);
			contentPanel.add(btnAnime);
		}
		{
			btnManga = new JButton("Manga");
			btnManga.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			btnManga.setBounds(247, 101, 158, 44);
			btnManga.addActionListener(this);
			contentPanel.add(btnManga);
		}
		{
			btnVolver = new JButton("Volver");
			btnVolver.setBounds(24, 174, 80, 20);
			btnVolver.addActionListener(this);
			contentPanel.add(btnVolver);
		}
		{
			JLabel lblInfo = new JLabel("De que tipo de Contenido quieres informate");
			lblInfo.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
			lblInfo.setBounds(59, 40, 308, 50);
			contentPanel.add(lblInfo);
		}
		{
			btnVerCompras = new JButton("Tus Compras");
			btnVerCompras.setBounds(247, 156, 158, 23);
			btnVerCompras.addActionListener(this);
			contentPanel.add(btnVerCompras);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnAnime)) {
			verAnime();
		}
		if(e.getSource().equals(btnManga)) {
			verManga();
		}
		if(e.getSource().equals(btnVerCompras)) {
			tusCompras();
		}
		
		if(e.getSource().equals(btnVolver)) {
			volver();
		}
	}
	
	
	private void tusCompras() {
		// TODO Auto-generated method stub
		TusCompras tc = new TusCompras(dao,cod);
		tc.setVisible(true);
	}
	
	
	private void cerrar() {
		this.dispose();
	}
	
	private void volver() {
		cerrar();
		IniciarSesion ini = new IniciarSesion(null,true,dao);
		ini.setVisible(true);
		
	}
	
	private void verManga() {
		// TODO Auto-generated method stub
		cerrar();
		VerManga man = new VerManga(true,dao,cod);
		man.setVisible(true);
		
	}
	
	private void verAnime() {
		// TODO Auto-generated method stub
		cerrar();
		VerAnime ani = new VerAnime(true,dao,cod);
		ani.setVisible(true);
		
		
	}

}
