package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Actor;
import modelo.Dao;
import modelo.DaoImplementacion;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class ConsltaActor extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JButton btnConsultas;
	private JButton btnVolver;
	private JComboBox comboActor;
	private Dao dao;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 * @param dao 
	 * @param admin 
	 */
	public ConsltaActor(Admin admin, Dao dao) {
		this.dao=dao;
		setBounds(100, 100, 509, 156);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblActor = new JLabel("ACTOR");
			lblActor.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
			lblActor.setBounds(10, 11, 79, 29);
			contentPanel.add(lblActor);
		}
		
		btnConsultas = new JButton("Consulta");
		btnConsultas.setBounds(396, 35, 87, 29);
		btnConsultas.addActionListener(this);
		contentPanel.add(btnConsultas);
		
		comboActor = new JComboBox();
		comboActor.setBounds(10, 64, 355, 43);
		contentPanel.add(comboActor);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(396, 78, 87, 29);
		btnVolver.addActionListener(this);
		contentPanel.add(btnVolver);
		cargarComboActor(dao);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnConsultas)) {
			consultar();
		}
		if(e.getSource().equals(btnVolver)) {
			volver(dao); 
		}
	}
	
	private void cargarComboActor(Dao dao) {
		ArrayList<Actor> act = dao.getActor();
		for (int i = 0; i < act.size(); i++) {
			comboActor.addItem(act.get(i).getDni()+" | "+act.get(i).getNombre());
		}
		comboActor.setSelectedIndex(-1);
		
	}

	private void consultar() {
		// TODO Auto-generated method stub
		String dniA ;
		boolean consulta = true;
		int donde;
		if(comboActor.getSelectedIndex() != -1) {
			dniA =(String) comboActor.getSelectedItem();
			donde = dniA.indexOf(" ");
			
			Actor act = dao.consultaActor(dniA.substring(0,donde));
			AltaActor alt = new AltaActor(consulta, dao, act);
			cerrar();
			alt.setVisible(true);
		}
	}
	
	private void cerrar() {
		this.dispose();
	}

	private void volver(Dao dao) {
		cerrar();
	}
}
