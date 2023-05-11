package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Estudio;
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

public class ConsltaEstudio extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JButton btnConsultas;
	private JComboBox comboEstudio;
	private JButton btnVolver;
	private Dao dao;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 * 
	 * @param dao
	 */
	public ConsltaEstudio(Dao dao) {
		this.dao = dao;
		setBounds(100, 100, 509, 156);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblActor = new JLabel("ESTUDIO");
			lblActor.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
			lblActor.setBounds(10, 11, 79, 29);
			contentPanel.add(lblActor);
		}

		btnConsultas = new JButton("Consulta");
		btnConsultas.setBounds(396, 35, 87, 29);
		contentPanel.add(btnConsultas);
		btnConsultas.addActionListener(this);

		comboEstudio = new JComboBox();
		comboEstudio.setBounds(10, 64, 355, 43);
		contentPanel.add(comboEstudio);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(396, 78, 87, 29);
		contentPanel.add(btnVolver);
		btnVolver.addActionListener(this);
		cargarComboProp();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
// TODO Auto-generated method stub

		if (e.getSource().equals(btnConsultas)) {
			consultar(dao);
		}
		if (e.getSource().equals(btnVolver)) {
			volver();
		}

	}

	private void consultar(Dao dao) {
// TODO Auto-generated method stub
		String nombre;
		boolean consulta = true;

		if (comboEstudio.getSelectedIndex() != -1) {
			nombre = (String) comboEstudio.getSelectedItem();

			Estudio est = dao.consultaEstudio(nombre);
			AltaEstudio altEst = new AltaEstudio(true, dao, est);
			volver();
			altEst.setVisible(true);
		}

	}

	private void cargarComboProp() {
		Dao dao = new DaoImplementacion();
		ArrayList<Estudio> est = dao.getEstudio();

		for (int i = 0; i < est.size(); i++) {
			comboEstudio.addItem(est.get(i).getNombre());
		}
		comboEstudio.setSelectedIndex(-1);
	}

	private void volver() {
		this.dispose();
	}


}
