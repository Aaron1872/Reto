package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import clases.Actor;
import clases.ContenidoMultimedia;
import clases.Manga;
import modelo.Dao;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

public class VerManga extends JDialog implements ActionListener{
	private Dao dao;
	private JTable tabla;
	private ComprarManga ven;
	private List<Manga> man;
	private List<ContenidoMultimedia> cm;
	private JButton btnvolver;
	private int cod;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 * 
	 * @param dao
	 * @param b
	 * @param cod 
	 */
	public VerManga(boolean b, Dao dao, int cod) {
		this.dao = dao;
		this.cod=cod;
		this.setModal(b);
		//this.cm=dao.getCM(true);
		this.man=dao.getMangas();
		this.cm=dao.getCM(true);
		setBounds(100, 100, 640, 449);
		getContentPane().setLayout(null);

		tabla = new JTable();
		tabla.setBounds(188, 188, 72, -34);
		getContentPane().add(tabla);
		
		presentarTabla();
	}



	public void presentarTabla() {
        
		JScrollPane scroll = new JScrollPane();
		scroll.setBorder(new EmptyBorder(17, 5, 5, 5));
		
		scroll.getViewport();
		scroll.setEnabled(false);
		scroll.setBorder(BorderFactory.createEmptyBorder());
		tabla = this.cargarTabla();

		tabla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				visualizarManga(this, ven, cm);
			}
		});

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
		scroll.setBounds(36, 110, 551, 160);
		getContentPane().add(scroll);
		
		JLabel lblNewLabel = new JLabel("Mangas");
		lblNewLabel.setFont(new Font("Source Serif Pro", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(103, 31, 427, 41);
		getContentPane().add(lblNewLabel);
		
		btnvolver = new JButton("volver");
		btnvolver.setBounds(10, 365, 89, 23);
		btnvolver.addActionListener(this);
		getContentPane().add(btnvolver);
	}
	

	public JTable cargarTabla() {
		String[] cabeceras = { "Titulo", "Puntuacion", "ISBN","Precio","Stock" };
		String[] fila = new String[10];

		DefaultTableModel model = new DefaultTableModel(null, cabeceras);
		
		
		for (Manga m:man) {
			fila[0] = m.getTitulo() + "";
			fila[1] = m.getPuntuacion() + "";
			fila[2] = m.getIsbn() + "";
			fila[3] = m.getPrecio() + "";
			fila[4] = m.getStock() + "";
			model.addRow(fila);
		}

		
		

		return new JTable(model);
	}
	
	
	
	public void visualizarManga(MouseAdapter mouseAdapter, ComprarManga man, List<ContenidoMultimedia> con) {

		int row = tabla.getSelectedRow();
		Manga ma;

		//if (row != -1) {
		String ti = (String) tabla.getValueAt(row, 0);
		
		//necesitamos el codigo para la consulta Manga y row,0 nos devuelve el titulo
		//vamos a buscar el codigo del manga con ese titulo
		
		ma = dao.consultaManga(encontrarCodigo(ti, con));
		dispose();
		ComprarManga com = new ComprarManga(dao, ma, true,cod);
		com.setVisible(true);
	
		//}

		}
	

	//Para encontrar el codigo de ese titulo recorro Contenido multimedia comprarando sus nombres
	private int encontrarCodigo(String ti, List<ContenidoMultimedia> con) {
		// TODO Auto-generated method stub
		int cod=0;
		for(ContenidoMultimedia c:con) {
			if(c.getTitulo().equalsIgnoreCase(ti)) {
				cod=c.getCodigo();
			}
			
			
		}
		return cod;
		
		
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
