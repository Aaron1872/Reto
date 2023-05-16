package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import clases.Anime;
import modelo.Dao;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class VerAnime extends JDialog implements ActionListener{
	private Dao dao;
	private JTable tabla;
	private List<Anime> animes;
	private JButton btnvolver;
	private int cod;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 * @param dao 
	 * @param b 
	 * @param cod 
	 */
	
	public VerAnime(boolean b, Dao dao, int cod) {
		this.dao=dao;
		this.setModal(b);
		this.cod=cod;
		animes=dao.getAnimes();
		setBounds(100, 100, 731, 471);
		
		
		presentarTabla();
		
	}
	
	
public void presentarTabla() {
        
		JScrollPane scroll = new JScrollPane();
		scroll.setBorder(new EmptyBorder(17, 5, 5, 5));
		
		scroll.getViewport();
		scroll.setEnabled(false);
		scroll.setBorder(BorderFactory.createEmptyBorder());
		tabla = this.cargarTabla();
		tabla.setEnabled(false);

		tabla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		getContentPane().setLayout(null);

		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabla.setBorder((new EmptyBorder(17, 5, 5, 5)));
		tabla.setBackground(Color.WHITE);
		tabla.setForeground(Color.BLACK);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

		for (int i = 0; i < tabla.getColumnCount(); i++) {
		    tabla.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}
		
		tabla.setFont(new Font("Arial", Font.PLAIN, 14));
	
		tabla.setRowHeight(40);
//tabla.setEnabled(false);
		scroll.setViewportView(tabla);
		scroll.setBounds(23, 110, 668, 238);
		getContentPane().add(scroll);
		
		JLabel lblNewLabel = new JLabel("Animes");
		lblNewLabel.setFont(new Font("Source Serif Pro", Font.BOLD, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(34, 24, 588, 28);
		getContentPane().add(lblNewLabel);
		
		btnvolver = new JButton("volver");
		btnvolver.setBounds(10, 386, 89, 23);
		btnvolver.addActionListener(this);
		getContentPane().add(btnvolver);
	}
	

	public JTable cargarTabla() {
		String[] cabeceras = { "Titulo", "Puntuacion", "Estado", "Tipo de Anime ", "Capitulos", "Temporadas", "Estudio"};
		String[] fila = new String[10];

		DefaultTableModel model = new DefaultTableModel(null, cabeceras);
		
		
		for (Anime a:animes) {
			fila[0] = a.getTitulo() + "";
			fila[1] = a.getPuntuacion() + "";
			fila[2] = a.getEstado() + "";
			fila[3] = a.getTipoAnime() + "";
			fila[4] = a.getCapitulos() + "";
			fila[5] = a.getTemporadas() + "";
			fila[6] = a.getEstudio() + "";
			model.addRow(fila);
		}

		
		

		return new JTable(model);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnvolver)) {
			volver();
		}
	}


	private void volver() {
		// TODO Auto-generated method stub
		this.dispose();
		Usuario usu = new Usuario(dao,cod);
		usu.setVisible(true);
	}
}
