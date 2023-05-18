package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Dao;
import vista.AltaProveedor;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Admin extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JButton btnModborProveedor;
	private Dao dao;
	private JButton btnAltaProveedor;
	private JButton btnModborAnime ;
	private JButton btnAltaManga;
	private JButton btnModborManga;
	private JButton btnAltaActor;
	private JButton btnModborActor;
	private JButton btnAltaEstudio;
	private JButton btnModborEstudio;
	private JButton btnAltaAutor;
	private JButton btnAutor;
	private JButton btnAltaAnime;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public Admin(Dao dao) {
		this.dao=dao;
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
		
		btnAltaAnime = new JButton("Alta Anime");
		btnAltaAnime.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnAltaAnime.addActionListener(this);
		btnAltaAnime.setBounds(10, 59, 158, 44);
		getContentPane().add(btnAltaAnime);
		
		btnAltaManga = new JButton("Alta Manga");
		btnAltaManga.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnAltaManga.setBounds(10, 135, 158, 44);
		btnAltaManga.addActionListener(this);
		getContentPane().add(btnAltaManga);
		
		btnAltaActor = new JButton("Alta Actor");
		btnAltaActor.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnAltaActor.setBounds(10, 203, 158, 44);
		btnAltaActor.addActionListener(this);
		getContentPane().add(btnAltaActor);
		
		btnAltaAutor = new JButton("Alta Autor");
		btnAltaAutor.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnAltaAutor.setBounds(10, 276, 158, 44);
		btnAltaAutor.addActionListener(this);
		getContentPane().add(btnAltaAutor);
		
		btnAltaProveedor = new JButton("Alta Proveedor");
		btnAltaProveedor.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnAltaProveedor.setBounds(10, 418, 158, 44);
		btnAltaProveedor.addActionListener(this);
		getContentPane().add(btnAltaProveedor);
		
		btnModborAnime = new JButton("Mod/Bor Anime");
		btnModborAnime.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnModborAnime.setBounds(246, 59, 195, 44);
		btnModborAnime.addActionListener(this);
		getContentPane().add(btnModborAnime);
		
		btnModborManga = new JButton("Mod/Bor Manga");
		btnModborManga.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnModborManga.setBounds(246, 135, 195, 44);
		btnModborManga.addActionListener(this);
		getContentPane().add(btnModborManga);
		
	    btnModborActor = new JButton("Mod/Bor Actor");
		btnModborActor.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnModborActor.setBounds(246, 203, 195, 44);
		btnModborActor.addActionListener(this);
		getContentPane().add(btnModborActor);
		
		btnModborEstudio = new JButton("Mod/Bor Estudio");
		btnModborEstudio.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnModborEstudio.setBounds(246, 349, 195, 44);
		btnModborEstudio.addActionListener(this);
		getContentPane().add(btnModborEstudio);
		
		btnModborProveedor = new JButton("Mod/Bor Proveedor");
		btnModborProveedor.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnModborProveedor.setBounds(246, 418, 195, 44);
		btnModborProveedor.addActionListener(this);
		getContentPane().add(btnModborProveedor);
		
		btnAltaEstudio = new JButton("Alta Estudio");
		btnAltaEstudio.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnAltaEstudio.setBounds(10, 349, 158, 44);
		btnAltaEstudio.addActionListener(this);
		getContentPane().add(btnAltaEstudio);
		
		btnAutor = new JButton("Mod/Bor Autor");
		btnAutor.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnAutor.setBounds(246, 276, 195, 44);
		btnAutor.addActionListener(this);
		getContentPane().add(btnAutor);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnModborProveedor)) {
			ConsltaProveedor pro = new ConsltaProveedor(this, dao);
			pro.setVisible(true);
			
		}
		if(e.getSource().equals(btnAltaProveedor)) {
			AltaProveedor altpro = new AltaProveedor(true, dao,null);
			altpro.setVisible(true);
			
		}
		if(e.getSource().equals(btnAltaManga)) {
			AltaManga  altm = new AltaManga(true, dao, null,null,null,null);
			altm.setVisible(true);
		}
		if(e.getSource().equals(btnModborManga)) {
			ConsltaManga man = new ConsltaManga(this,dao);
			man.setVisible(true);
		}
		if(e.getSource().equals(btnAltaActor)) {
			AltaActor act = new AltaActor(true, dao, null);
			act.setVisible(true);
		}
		if(e.getSource().equals(btnModborActor)) {
			ConsltaActor act = new ConsltaActor(this,dao);
			act.setVisible(true);
		}
		if(e.getSource().equals(btnAltaEstudio)) {
			AltaEstudio est = new AltaEstudio(true, dao, null);
			est.setVisible(true);
		}
		if(e.getSource().equals(btnModborEstudio)) {
			ConsltaEstudio conEst = new ConsltaEstudio(dao);
			conEst.setVisible(true);
		}
		if(e.getSource().equals(btnAltaAutor)) {
			AltaAutor alt = new AltaAutor(true,dao,null);
			alt.setVisible(true);
		}
		if(e.getSource().equals(btnAutor)) {
			ConsltaAutor aut = new  ConsltaAutor(dao);
			aut.setVisible(true);
		}
		if(e.getSource().equals(btnAltaAnime)) {
			AltaAnime altAni = new AltaAnime(true, dao, null, null, null);
			altAni.setVisible(true);
		}
		if(e.getSource().equals(btnModborAnime)) {
			ConsltaAnime conAni = new ConsltaAnime(null, dao);
			conAni.setVisible(true);
		}
	}
	
}
