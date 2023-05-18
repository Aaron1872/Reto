package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Dao;
import modelo.DaoImplementacion;
import clases.Autor;
import clases.ContenidoMultimedia;
import clases.Editorial;
import clases.Manga;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class ConsltaManga extends JDialog  implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JButton btnConsultas ;
	private JComboBox comboManga ;
	private JButton btnVolver;
	private Dao dao;

	/**
	 * Launch the application.
	 */

		

	/**
	 * Create the dialog.
	 * @param dao 
	 * @param admin 
	 */
	public ConsltaManga(Admin admin, Dao dao) {
		this.dao=dao;
		
		setBounds(100, 100, 509, 156);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblManga = new JLabel("MANGA");
			lblManga.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
			lblManga.setBounds(10, 11, 79, 29);
			contentPanel.add(lblManga);
		}
		
		btnConsultas = new JButton("Consulta");
		btnConsultas.setBounds(396, 35, 87, 29);
		btnConsultas.addActionListener(this);
		contentPanel.add(btnConsultas);
		
		comboManga = new JComboBox();
		comboManga.setBounds(10, 64, 355, 43);
		contentPanel.add(comboManga);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(396, 78, 87, 29);
		btnVolver.addActionListener(this);
		contentPanel.add(btnVolver);
		
		cargarComboManga();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnConsultas)) {
			consultar();
		}
		if(e.getSource().equals(btnVolver)) {
			volver();
		}
		
		
		
	}
	
	private void volver() {
		this.dispose();
	}
	
	
	private void cargarComboManga() {
		
		ArrayList<ContenidoMultimedia> man = dao.getCM(true);

		for (int i = 0; i < man.size(); i++) {
			comboManga.addItem(man.get(i).getCodigo()+" | "+man.get(i).getTitulo());
		}
		comboManga.setSelectedIndex(-1);
	}

	
	private void consultar() {
		// TODO Auto-generated method stub
		String cod ;
		int donde;
		if(comboManga.getSelectedIndex() != -1) {
			cod =(String) comboManga.getSelectedItem();
			donde = cod.indexOf(" ");
			
			ContenidoMultimedia com = dao.consultaCM(Integer.parseInt(cod.substring(0,donde)));
			Manga man = dao.consultaManga(Integer.parseInt(cod.substring(0,donde)));
			Autor au = dao.consultaAutor(com.getAutor());
			Editorial ed = dao.consultaEditorial(man.getEditorial());
			AltaManga  altm = new AltaManga(true, dao, man, com, au, ed);
			volver();
			altm.setVisible(true);
			
		}
		
		
		
		
		
		
		
		
	}
}
