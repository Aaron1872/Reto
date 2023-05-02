package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Proveedor;
import modelo.Dao;
import modelo.DaoImplementacion;


import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextPane;
import javax.swing.JTextField;

public class AltaProveedor extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField textNif;
	private JTextField textNombre;
	private JTextField textLugar;
	private JTextField textUbi;
	private JTextField textweb;
	private Dao dao;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public AltaProveedor(Dao dao) {
		this.dao=dao;
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
			JLabel lblActor = new JLabel("Proveedor");
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
			JLabel textDirec = new JLabel("Direcci\u00F3n:");
			textDirec.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
			textDirec.setBounds(10, 122, 131, 29);
			contentPanel.add(textDirec);
		}
		
		textNif = new JTextField();
		textNif.setBounds(56, 48, 309, 20);
		contentPanel.add(textNif);
		textNif.setColumns(10);
		
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
			textUbi = new JTextField();
			textUbi.setColumns(10);
			textUbi.setBounds(88, 168, 277, 20);
			contentPanel.add(textUbi);
		}
		{
			textweb = new JTextField();
			textweb.setColumns(10);
			textweb.setBounds(98, 207, 267, 20);
			contentPanel.add(textweb);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	public void CargarPro(Admin ad, Dao dao, String nombre) {
		
		dao = new DaoImplementacion();
		ArrayList<Proveedor> nompro = dao.getProveedor();
		for (int i = 0; i < nompro.size(); i++) {
			if (nompro.get(i).getNombre().equalsIgnoreCase(nombre)) {
				textLugar.setEnabled(false);
				textNif.setEnabled(false);
				textNombre.setText(nompro.get(i).getNombre());
			
				
			}
		}
	}
}
