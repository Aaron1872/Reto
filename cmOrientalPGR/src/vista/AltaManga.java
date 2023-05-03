package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AltaManga extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textCodigo;
	private JTextField textTitulo;
	private JTextField textAño;
	private JTextField textPuntuacion;
	private JTextField textISBN;
	private JTextField textTomos;
	private JTextField textPeriozidad;
	private JTextField textPrecio;
	private JTextField textStock;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AltaManga dialog = new AltaManga();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AltaManga() {
		getContentPane().setLayout(null);
		
		JLabel lblAnime = new JLabel("MANGA");
		lblAnime.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblAnime.setBounds(10, 11, 86, 23);
		getContentPane().add(lblAnime);
		setBounds(100, 100, 518, 629);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblAnime_1 = new JLabel("Codigo");
		lblAnime_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblAnime_1.setBounds(10, 67, 86, 23);
		contentPanel.add(lblAnime_1);
		
		JLabel lblAnime_2 = new JLabel("Titulo");
		lblAnime_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblAnime_2.setBounds(10, 115, 86, 23);
		contentPanel.add(lblAnime_2);
		
		JLabel lblAnime_3 = new JLabel("Autor");
		lblAnime_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblAnime_3.setBounds(10, 165, 86, 23);
		contentPanel.add(lblAnime_3);
		
		JLabel lblAnime_4 = new JLabel("A\u00F1o Inicio");
		lblAnime_4.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblAnime_4.setBounds(10, 214, 86, 23);
		contentPanel.add(lblAnime_4);
		
		JLabel lblAnime_4_1 = new JLabel("Estado");
		lblAnime_4_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblAnime_4_1.setBounds(10, 257, 86, 23);
		contentPanel.add(lblAnime_4_1);
		
		JLabel lblPuntuacion = new JLabel("Puntuacion");
		lblPuntuacion.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblPuntuacion.setBounds(10, 301, 86, 23);
		contentPanel.add(lblPuntuacion);
		
		JLabel lblISBN = new JLabel("ISBN");
		lblISBN.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblISBN.setBounds(10, 335, 86, 23);
		contentPanel.add(lblISBN);
		
		JLabel lblTomos = new JLabel("N\u00BATomos");
		lblTomos.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblTomos.setBounds(10, 357, 86, 47);
		contentPanel.add(lblTomos);
		
		JLabel lblEditorial = new JLabel("Editorial");
		lblEditorial.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblEditorial.setBounds(10, 405, 101, 23);
		contentPanel.add(lblEditorial);
		
		JLabel lblPeriozidad = new JLabel("Periodizidad");
		lblPeriozidad.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblPeriozidad.setBounds(10, 439, 101, 23);
		contentPanel.add(lblPeriozidad);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblPrecio.setBounds(10, 473, 86, 23);
		contentPanel.add(lblPrecio);
		
		textCodigo = new JTextField();
		textCodigo.setBounds(123, 71, 279, 20);
		contentPanel.add(textCodigo);
		textCodigo.setColumns(10);
		
		textTitulo = new JTextField();
		textTitulo.setColumns(10);
		textTitulo.setBounds(123, 119, 279, 20);
		contentPanel.add(textTitulo);
		
		textAño = new JTextField();
		textAño.setColumns(10);
		textAño.setBounds(123, 218, 279, 20);
		contentPanel.add(textAño);
		
		textPuntuacion = new JTextField();
		textPuntuacion.setColumns(10);
		textPuntuacion.setBounds(123, 304, 279, 20);
		contentPanel.add(textPuntuacion);
		
		textISBN = new JTextField();
		textISBN.setColumns(10);
		textISBN.setBounds(123, 339, 279, 20);
		contentPanel.add(textISBN);
		
		textTomos = new JTextField();
		textTomos.setColumns(10);
		textTomos.setBounds(123, 373, 279, 20);
		contentPanel.add(textTomos);
		
		textPeriozidad = new JTextField();
		textPeriozidad.setColumns(10);
		textPeriozidad.setBounds(123, 443, 279, 20);
		contentPanel.add(textPeriozidad);
		
		JComboBox comboEstado = new JComboBox();
		comboEstado.setBounds(123, 260, 279, 22);
		contentPanel.add(comboEstado);
		
		JComboBox comboAutor = new JComboBox();
		comboAutor.setBounds(123, 168, 279, 22);
		contentPanel.add(comboAutor);
		
		JButton btnAlta = new JButton("Alta");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAlta.setBounds(412, 462, 80, 20);
		contentPanel.add(btnAlta);
		
		JButton btnModi = new JButton("Modi");
		btnModi.setBounds(412, 489, 80, 20);
		contentPanel.add(btnModi);
		
		JButton btnBaja = new JButton("Baja");
		btnBaja.setBounds(412, 520, 80, 20);
		contentPanel.add(btnBaja);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(412, 551, 80, 20);
		contentPanel.add(btnVolver);
		
		JComboBox comboEditorial = new JComboBox();
		comboEditorial.setBounds(123, 408, 279, 22);
		contentPanel.add(comboEditorial);
		
		textPrecio = new JTextField();
		textPrecio.setColumns(10);
		textPrecio.setBounds(123, 477, 279, 20);
		contentPanel.add(textPrecio);
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblStock.setBounds(10, 507, 86, 23);
		contentPanel.add(lblStock);
		
		JLabel lblProveedor = new JLabel("Proveedor");
		lblProveedor.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblProveedor.setBounds(10, 541, 86, 23);
		contentPanel.add(lblProveedor);
		
		JComboBox comboProveedor = new JComboBox();
		comboProveedor.setBounds(123, 550, 279, 22);
		contentPanel.add(comboProveedor);
		
		textStock = new JTextField();
		textStock.setColumns(10);
		textStock.setBounds(123, 508, 279, 20);
		contentPanel.add(textStock);
		
	}
}
