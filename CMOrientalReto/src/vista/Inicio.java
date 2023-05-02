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
import javax.swing.JTable;

public class Inicio extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textCodigo;
	private JTextField textTitulo;
	private JTextField textAño;
	private JTextField textPuntuacion;
	private JTextField textTipo;
	private JTextField textCapitulos;
	private JTextField textTemporadas;
	private JTable tableActores;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Inicio dialog = new Inicio();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Inicio() {
		getContentPane().setLayout(null);
		
		JLabel lblAnime = new JLabel("ANIME");
		lblAnime.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblAnime.setBounds(10, 11, 86, 23);
		getContentPane().add(lblAnime);
		setBounds(100, 100, 518, 692);
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
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblTipo.setBounds(10, 335, 86, 23);
		contentPanel.add(lblTipo);
		
		JLabel lblCapitulos = new JLabel("Capitulos");
		lblCapitulos.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblCapitulos.setBounds(10, 369, 86, 23);
		contentPanel.add(lblCapitulos);
		
		JLabel lblTemporadas = new JLabel("Temporadas");
		lblTemporadas.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblTemporadas.setBounds(10, 405, 101, 23);
		contentPanel.add(lblTemporadas);
		
		JLabel lblEstudio = new JLabel("Estudio");
		lblEstudio.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblEstudio.setBounds(10, 439, 86, 23);
		contentPanel.add(lblEstudio);
		
		JLabel lblAnime_4_4_2_1 = new JLabel("Actores");
		lblAnime_4_4_2_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblAnime_4_4_2_1.setBounds(10, 486, 86, 23);
		contentPanel.add(lblAnime_4_4_2_1);
		
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
		
		textTipo = new JTextField();
		textTipo.setColumns(10);
		textTipo.setBounds(123, 339, 279, 20);
		contentPanel.add(textTipo);
		
		textCapitulos = new JTextField();
		textCapitulos.setColumns(10);
		textCapitulos.setBounds(123, 373, 279, 20);
		contentPanel.add(textCapitulos);
		
		textTemporadas = new JTextField();
		textTemporadas.setColumns(10);
		textTemporadas.setBounds(121, 409, 279, 20);
		contentPanel.add(textTemporadas);
		
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
		
		tableActores = new JTable();
		tableActores.setBounds(123, 493, 279, 123);
		contentPanel.add(tableActores);
		
		JComboBox comboEstudio = new JComboBox();
		comboEstudio.setBounds(123, 442, 279, 22);
		contentPanel.add(comboEstudio);
		
	}
}
