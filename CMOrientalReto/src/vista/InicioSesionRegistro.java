package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Dao;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InicioSesionRegistro extends JFrame implements ActionListener{

	private JPanel contentPane;
	JButton IniciarS;
	JButton btnRegistrarte;
	private Dao dao;
	
	public InicioSesionRegistro(Dao dao) {
		this.dao=dao;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		IniciarS = new JButton("Iniciar Sesion");
		IniciarS.setFont(new Font("Tahoma", Font.PLAIN, 18));
		IniciarS.setBounds(143, 72, 295, 59);
		IniciarS.addActionListener(this);
		contentPane.add(IniciarS);
		
		
	    btnRegistrarte = new JButton("Registrarte");
		btnRegistrarte.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRegistrarte.setBounds(143, 185, 295, 59);
		btnRegistrarte.addActionListener(this);
		contentPane.add(btnRegistrarte);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(IniciarS)) {
			inicioSesion();
		}
		if(e.getSource().equals(btnRegistrarte)) {
			registrarse();
		}
	}

	private void registrarse() {
		// TODO Auto-generated method stub
		cerrar();
		RegistrarseUsuario regis = new RegistrarseUsuario(this,true,dao);
		regis.setVisible(true);
		
	}
	
	private void cerrar() {
		this.dispose();
	}

	private void inicioSesion() {
		// TODO Auto-generated method stub
		cerrar();
		IniciarSesion ini = new IniciarSesion(this,true,dao);
		ini.setVisible(true);
	}
}