package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Actor;
import clases.Autor;
import modelo.Dao;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class ConsltaAutor extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private Dao dao;
	private JButton btnConsultas;
	private JButton btnVolver;
	private JComboBox comboAutor;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 * @param dao 
	 */
	public ConsltaAutor(Dao dao) {
		this.dao=dao;
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
		
		btnConsultas = new JButton("Consulta");
		btnConsultas.setBounds(396, 35, 87, 29);
		btnConsultas.addActionListener(this);
		contentPanel.add(btnConsultas);
		
		comboAutor = new JComboBox();
		comboAutor.setBounds(10, 64, 355, 43);
		contentPanel.add(comboAutor);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(396, 78, 87, 29);
		btnVolver.addActionListener(this);
		contentPanel.add(btnVolver);
		
		cargarComboAutor(dao);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnVolver)) {
			volver(); 
		}
		if(e.getSource().equals(btnConsultas)) {
			consultar();
		}
		
			
	}
	
	private void cargarComboAutor(Dao dao) {
		
		ArrayList<Autor> aut = dao.getAutor();
		for (int i = 0; i < aut.size(); i++) {
			comboAutor.addItem(aut.get(i).getDni()+" | "+aut.get(i).getNombre());
		}
		comboAutor.setSelectedIndex(-1);
			
	}
	
	
	
	private void consultar() {
		// TODO Auto-generated method stub
		String dni;
		int donde;
		if(comboAutor.getSelectedIndex() != -1) {
			dni = (String) comboAutor.getSelectedItem();
			donde = dni.indexOf(" ");
			Autor aut = dao.consultaAutor(dni.substring(0,donde));
			AltaAutor alt = new AltaAutor(true, dao, aut);
			volver();
			alt.setVisible(true);
		}
		
		
		
	}

	private void volver() {
		this.dispose();
	}
}
