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

import clases.ContenidoMultimedia;
import clases.Manga;
import modelo.Dao;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.JTable;

public class TusCompras extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTable tabla;
	private Dao dao;
	private ComprarManga ven;
	private List<Manga> man;
	private List<ContenidoMultimedia> cm;
	private int cod;
	private JButton btnvolver;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 * @param dao 
	 * @param cod 
	 */
	public TusCompras(Dao dao, int cod) {
		this.dao=dao;
		this.cod=cod;
		man=dao.getMangasUsuario(cod);
		setBounds(100, 100, 680, 360);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 0, 0);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tus compras");
		lblNewLabel.setFont(new Font("Source Serif Pro", Font.BOLD, 20));
		lblNewLabel.setBounds(168, 39, 125, 28);
		contentPanel.add(lblNewLabel);
		
		tabla = new JTable();
		tabla.setBounds(225, 128, 1, 1);
		contentPanel.add(tabla);
		presentarTabla();
		
	}
	
	
	
	//Caracteristicas de la tabla
	public void presentarTabla() {
        
		JScrollPane scroll = new JScrollPane();
		scroll.setBorder(new EmptyBorder(17, 5, 5, 5));
		
		scroll.getViewport().setBackground(Color.WHITE);
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
		scroll.setBounds(40, 100, 585, 160);
		getContentPane().add(scroll);
		
		JLabel lblNewLabel = new JLabel("Mangas");
		lblNewLabel.setFont(new Font("Source Serif Pro", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 0, 633, 286);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mangas que has Comprado");
		lblNewLabel_1.setFont(new Font("Source Serif Pro", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(149, 22, 347, 41);
		getContentPane().add(lblNewLabel_1);
		
		btnvolver = new JButton("Volver");
		btnvolver.setBounds(20, 287, 89, 23);
		btnvolver.addActionListener(this);
		getContentPane().add(btnvolver);
		
		
	}

	@Override
		public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnvolver))
			this.dispose();
			
	}
	

	public JTable cargarTabla() {
		//La cabecera de la tabla 
		String[] cabeceras = { "Titulo", "ISBN","Precio" };
		String[] fila = new String[10];

		DefaultTableModel model = new DefaultTableModel(null, cabeceras);
		
		//rellena los datos de dentro de la tabla
		for (Manga m:man) {
			fila[0] = m.getTitulo() + "";
			fila[1] = m.getIsbn() + "";
			fila[2] = m.getPrecio() + "";
			model.addRow(fila);
		}

		
		

		return new JTable(model);
	}
	
	
	
	public void visualizarManga(MouseAdapter mouseAdapter, ComprarManga man, List<ContenidoMultimedia> con) {

		int row = tabla.getSelectedRow();
		Manga ma;

		String ti = (String) tabla.getValueAt(row, 0);
		
		//necesitamos el codigo para la consulta Manga y row,0 nos devuelve el titulo
		//vamos a buscar el codigo del manga con ese titulo
		
		ma = dao.consultaManga(encontrarCodigo(ti, con));


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




	
}
