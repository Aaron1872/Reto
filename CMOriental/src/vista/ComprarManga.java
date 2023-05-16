package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Manga;
import modelo.Dao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

public class ComprarManga extends JDialog implements ActionListener{
	private int cant =0;
	private Dao dao;
	private Manga man;
	private JTextField textTitulo;
	private JTextField textAñoIni;
	private JTextField textPuntuacion;
	private JTextField textISBN;
	private JTextField textNtomos;
	private JTextField textPeriodizidad;
	private JTextField textPrecio;
	private JTextField textCantidad;
	private JTextField textEditorial;
	private JTextField textEstado;
	private JTextField textAutor;
	private JButton btnMenos;
	private JButton btnMas;
	private JButton btnVolver;
	private JButton btnComprar;
	private int cod;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 * @param dao 
	 * @param ma 
	 * @param modal 
	 * @param cod 
	 */
	public ComprarManga(Dao dao, Manga ma, boolean modal, int cod) {
		man=ma;
		this.dao=dao;
		this.cod=cod;
		this.setModal(modal);
		setBounds(100, 100, 520, 600);
		getContentPane().setLayout(null);
		
		JPanel contentPanel_1 = new JPanel();
		contentPanel_1.setLayout(null);
		contentPanel_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel_1.setBounds(10, -29, 502, 590);
		getContentPane().add(contentPanel_1);
		
		JLabel lblAnime_3 = new JLabel("Autor");
		lblAnime_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblAnime_3.setBounds(10, 165, 86, 23);
		contentPanel_1.add(lblAnime_3);
		
		JLabel lblAnime_4 = new JLabel("A\u00F1o Inicio");
		lblAnime_4.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblAnime_4.setBounds(10, 214, 86, 23);
		contentPanel_1.add(lblAnime_4);
		
		JLabel lblAnime_4_1 = new JLabel("Estado");
		lblAnime_4_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblAnime_4_1.setBounds(10, 257, 86, 23);
		contentPanel_1.add(lblAnime_4_1);
		
		JLabel lblPuntuacion = new JLabel("Puntuacion");
		lblPuntuacion.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblPuntuacion.setBounds(10, 301, 86, 23);
		contentPanel_1.add(lblPuntuacion);
		
		JLabel lblISBN = new JLabel("ISBN");
		lblISBN.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblISBN.setBounds(10, 335, 86, 23);
		contentPanel_1.add(lblISBN);
		
		JLabel lblTomos = new JLabel("N\u00BATomos");
		lblTomos.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblTomos.setBounds(10, 357, 86, 47);
		contentPanel_1.add(lblTomos);
		
		JLabel lblEditorial = new JLabel("Editorial");
		lblEditorial.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblEditorial.setBounds(10, 405, 101, 23);
		contentPanel_1.add(lblEditorial);
		
		JLabel lblPeriozidad = new JLabel("Periodizidad");
		lblPeriozidad.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblPeriozidad.setBounds(10, 439, 101, 23);
		contentPanel_1.add(lblPeriozidad);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblPrecio.setBounds(10, 473, 86, 23);
		contentPanel_1.add(lblPrecio);
		
		textTitulo = new JTextField();
		textTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		textTitulo.setColumns(10);
		textTitulo.setBounds(123, 119, 279, 20);
		textTitulo.enable(false);
		textTitulo.setDisabledTextColor(Color.BLACK);
		contentPanel_1.add(textTitulo);
		
		textAñoIni = new JTextField();
		textAñoIni.setHorizontalAlignment(SwingConstants.CENTER);
		textAñoIni.setColumns(10);
		textAñoIni.setBounds(123, 218, 279, 20);
		textAñoIni.enable(false);
		textAñoIni.setDisabledTextColor(Color.BLACK);
		contentPanel_1.add(textAñoIni);
		
		textPuntuacion = new JTextField();
		textPuntuacion.setToolTipText("Puntua entre 0-10");
		textPuntuacion.setHorizontalAlignment(SwingConstants.CENTER);
		textPuntuacion.setColumns(10);
		textPuntuacion.setBounds(123, 304, 279, 20);
		textPuntuacion.enable(false);
		textPuntuacion.setDisabledTextColor(Color.BLACK);
		contentPanel_1.add(textPuntuacion);
		
		textISBN = new JTextField();
		textISBN.setHorizontalAlignment(SwingConstants.CENTER);
		textISBN.setColumns(10);
		textISBN.setBounds(123, 339, 279, 20);
		textISBN.enable(false);
		textISBN.setDisabledTextColor(Color.BLACK);
		contentPanel_1.add(textISBN);
		
		textNtomos = new JTextField();
		textNtomos.setHorizontalAlignment(SwingConstants.CENTER);
		textNtomos.setColumns(10);
		textNtomos.setBounds(123, 373, 279, 20);
		textNtomos.enable(false);
		textNtomos.setDisabledTextColor(Color.BLACK);
		contentPanel_1.add(textNtomos);
		
		textPeriodizidad = new JTextField();
		textPeriodizidad.setToolTipText("Cada cuanto tiempo sale ");
		textPeriodizidad.setHorizontalAlignment(SwingConstants.CENTER);
		textPeriodizidad.setColumns(10);
		textPeriodizidad.setBounds(123, 443, 279, 20);
		textPeriodizidad.enable(false);
		textPeriodizidad.setDisabledTextColor(Color.BLACK);
		contentPanel_1.add(textPeriodizidad);
		
		btnComprar = new JButton("Comprar");
		btnComprar.setBounds(359, 546, 118, 33);
		btnComprar.addActionListener(this);
		contentPanel_1.add(btnComprar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(10, 559, 80, 20);
		btnVolver.addActionListener(this);
		contentPanel_1.add(btnVolver);
		
		textPrecio = new JTextField();
		textPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		textPrecio.setColumns(10);
		textPrecio.setBounds(123, 477, 279, 20);
		textPrecio.enable(false);
		textPrecio.setDisabledTextColor(Color.BLACK);
		contentPanel_1.add(textPrecio);
		
		JLabel lblStock = new JLabel("Cantidad");
		lblStock.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblStock.setBounds(10, 507, 86, 23);
		contentPanel_1.add(lblStock);
		
		textCantidad = new JTextField();
		textCantidad.setText("0");
		textCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		textCantidad.setColumns(10);
		textCantidad.setBounds(176, 508, 68, 20);
		textCantidad.enable(false);
		textCantidad.setDisabledTextColor(Color.BLACK);
		contentPanel_1.add(textCantidad);
		
		JLabel lblAnime_1 = new JLabel("Titulo");
		lblAnime_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblAnime_1.setBounds(10, 115, 86, 23);
		contentPanel_1.add(lblAnime_1);
		
		btnMenos = new JButton("-");
		btnMenos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnMenos.setBounds(123, 507, 43, 23);
		btnMenos.addActionListener(this);
		contentPanel_1.add(btnMenos);
		
		btnMas = new JButton("+");
		btnMas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnMas.setBounds(254, 507, 43, 23);
		btnMas.addActionListener(this);
		contentPanel_1.add(btnMas);
		
		textEditorial = new JTextField();
		textEditorial.setToolTipText("Cada cuanto tiempo sale ");
		textEditorial.setHorizontalAlignment(SwingConstants.CENTER);
		textEditorial.setColumns(10);
		textEditorial.setBounds(121, 409, 279, 20);
		textEditorial.enable(false);
		textEditorial.setDisabledTextColor(Color.BLACK);
		contentPanel_1.add(textEditorial);
		
		textEstado = new JTextField();
		textEstado.setToolTipText("Cada cuanto tiempo sale ");
		textEstado.setHorizontalAlignment(SwingConstants.CENTER);
		textEstado.setColumns(10);
		textEstado.setBounds(123, 261, 279, 20);
		textEstado.enable(false);
		textEstado.setDisabledTextColor(Color.BLACK);
		contentPanel_1.add(textEstado);
		
		textAutor = new JTextField();
		textAutor.setToolTipText("Cada cuanto tiempo sale ");
		textAutor.setHorizontalAlignment(SwingConstants.CENTER);
		textAutor.setColumns(10);
		textAutor.setBounds(123, 169, 279, 20);
		textAutor.enable(false);
		textAutor.setDisabledTextColor(Color.BLACK);
		contentPanel_1.add(textAutor);
		
		JLabel lblNewLabel = new JLabel("Tu Manga");
		lblNewLabel.setFont(new Font("Source Serif Pro", Font.BOLD, 15));
		lblNewLabel.setBounds(25, 47, 101, 33);
		contentPanel_1.add(lblNewLabel);
		
		cargarManga(ma);
	}
	
	//Carga los datos del manga que has escogido en la tabla de la pagina anterior
	private void cargarManga(Manga ma) {
		//Los datos salen introducidos con el seleccionado en la tabla anterior
		
		textCantidad.setText(Integer.toString(cant));
		textTitulo.setText(ma.getTitulo());
		textAutor.setText(ma.getAutor());
		textEstado.setText(ma.getEstado());
		textEditorial.setText(ma.getEditorial());
		textPeriodizidad.setText(ma.getPeriodicidad());
		textAñoIni.setText(Integer.toString(ma.getAñoInicio()));
		textISBN.setText(Integer.toString(ma.getIsbn()));
		textNtomos.setText(Integer.toString(ma.getNumTomos()));
		textPuntuacion.setText(Float.toString(ma.getPuntuacion()));
		textPrecio.setText(Float.toString(ma.getPrecio()));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource().equals(btnMas)) {
			sumarStock();
		}
		if(e.getSource().equals(btnMenos)) {
			restarStock();
		}
		if(e.getSource().equals(btnVolver)){
			volver();
				
		}if(e.getSource().equals(btnComprar)) {
			comprarManga();
		}
		
	}

	
	private void comprarManga() {
		// TODO Auto-generated method stub
		
		int cant = Integer.parseInt(textCantidad.getText());
		if(dao.ventaManga(man.getCodigo(),cant,cod)) {
			JOptionPane.showMessageDialog(this, "Compra correcta");
			
		}else {
			JOptionPane.showMessageDialog(null, "Error, no hay tanto Stock ", "Error En compra", JOptionPane.ERROR_MESSAGE);
		}
		
		
		
		
	}

	
	
	//Vover a la pagina anterior y cierra esta
	private void volver() {
		// TODO Auto-generated method stub
		//cerramos esta ventana y abrimos la anterior
		VerManga ver = new VerManga(true, dao,cod);
		this.dispose();
		ver.setVisible(true);
	}

	//Utiliza el boton para que la cantidad que pidas se sume o reste
	private void restarStock() {
		// TODO Auto-generated method stub
		//coge la cantidad actual y le resta uno sin dejar poner numeros menores a 0
	    int cant = Integer.parseInt(textCantidad.getText());
	    if(cant>0) {
			textCantidad.setText(Integer.toString(--cant));
		}
	}

	private void sumarStock() {
		// TODO Auto-generated method stub
		//coge la cantidad actual y le suma uno 
	 int cant = Integer.parseInt(textCantidad.getText());
		textCantidad.setText(Integer.toString(++cant));
	}
}
