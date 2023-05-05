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
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class ConsltaProveedor extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JComboBox comboProveedor;
	private JButton btnVolver;
	private JButton btnConsultas;
	private Dao dao;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public ConsltaProveedor(Admin vent , Dao dao) {
		this.dao=dao;
		setBounds(100, 100, 509, 156);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblActor = new JLabel("PROVEEDOR");
			lblActor.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
			lblActor.setBounds(10, 11, 98, 29);
			contentPanel.add(lblActor);
		}
		
		btnConsultas = new JButton("Consulta");
		btnConsultas.setBounds(396, 35, 87, 29);
		btnConsultas.addActionListener(this);
		contentPanel.add(btnConsultas);
		
		comboProveedor = new JComboBox();
		comboProveedor.setBounds(10, 64, 355, 43);
		contentPanel.add(comboProveedor);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(396, 78, 87, 29);
		btnVolver.addActionListener(this);
		contentPanel.add(btnVolver);
		cargarComboProp();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(e.getSource().equals(btnConsultas)) {
			if (comboProveedor.getSelectedIndex() > -1) {
				consultar();
			} 
		
		}
		if(e.getSource().equals(btnVolver)) {
			volver(); 
		}
		
	}
	

	private void cargarComboProp() {
		Dao dao = new DaoImplementacion();
		ArrayList<Proveedor> pro = dao.getProveedor();
		//comboProveedor.removeAllItems();

		for (int i = 0; i < pro.size(); i++) {
			comboProveedor.addItem(pro.get(i).getNif()+" | "+pro.get(i).getNombre());
			
		}
		comboProveedor.setSelectedIndex(-1);
	}
	


	
	private void consultar() {
		String cifProveedor ;
		int donde;
		boolean consulta =true;
		// TODO Auto-generated method stub
		if (comboProveedor.getSelectedIndex() != -1) {
			//Obtener CIF seleccionado
			cifProveedor = (String) comboProveedor.getSelectedItem();
			donde = cifProveedor.indexOf(" ");
	
			Proveedor pro = dao.consultaProveedor(cifProveedor.substring(0, donde));
			
			AltaProveedor alt = new AltaProveedor( true, dao, pro);
			cerrar();
			//alt.CargarPro(null, dao, (String) comboProveedor.getSelectedItem());
			alt.setVisible(true);
			
		}else {
			////
		}
	}
	
	
	
	
	private void cerrar() {
		this.dispose();
	}

	private void volver() {
		cerrar();
		dao = new DaoImplementacion();
		//Admin ad = new Admin(dao);
		//ad.setVisible(true);
	}
}
