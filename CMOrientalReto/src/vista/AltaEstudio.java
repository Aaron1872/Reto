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
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JTextField;

public class AltaEstudio extends JDialog implements ActionListener {

	/**
	*
	*/
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textNombre;
	private JTextField textFecha;
	private JButton btnAlta;
	private JButton btnVolver;
	private JButton btnBaja;
	private JButton btnModi;
	private JLabel lblCaracteristicas;
	private JTextField textCaracteristicas;
	private Dao dao;
	private Estudio estu;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 * 
	 * @param dao
	 * @param admin
	 */
	public AltaEstudio(boolean modal, Dao dao, Estudio est) {
		this.setModal(modal);
		estu = est;
		this.dao = dao;
		setBounds(100, 100, 639, 381);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblEstudio = new JLabel("Estudio");
			lblEstudio.setBounds(10, 11, 85, 35);
			lblEstudio.setFont(new Font("Comic Sans MS", Font.BOLD, 19));
			contentPanel.add(lblEstudio);
		}
		{
			JLabel lblNombre = new JLabel("Nombre");
			lblNombre.setBounds(33, 71, 85, 35);
			lblNombre.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
			contentPanel.add(lblNombre);
		}
		{
			JLabel lblFechaFundacion = new JLabel("Fecha fundacion");
			lblFechaFundacion.setBounds(33, 117, 137, 35);
			lblFechaFundacion.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
			contentPanel.add(lblFechaFundacion);
		}
		{
			textNombre = new JTextField();
			textNombre.setBounds(178, 81, 341, 20);
			textNombre.setColumns(10);
			contentPanel.add(textNombre);
		}
		{
			textFecha = new JTextField();
			textFecha.setBounds(180, 127, 341, 20);
			textFecha.setColumns(10);
			contentPanel.add(textFecha);
		}
		{
			btnModi = new JButton("Modi");
			btnModi.setBounds(531, 112, 80, 20);
			contentPanel.add(btnModi);
			btnModi.addActionListener(this);
		}
		{
			btnBaja = new JButton("Baja");
			btnBaja.setBounds(531, 142, 80, 20);
			contentPanel.add(btnBaja);
			btnBaja.addActionListener(this);
		}
		{
			btnVolver = new JButton("Volver");
			btnVolver.setBounds(531, 173, 80, 20);
			contentPanel.add(btnVolver);
			btnVolver.addActionListener(this);
		}
		{
			btnAlta = new JButton("Alta");
			btnAlta.setBounds(531, 81, 80, 20);
			contentPanel.add(btnAlta);
			btnAlta.addActionListener(this);
		}

		lblCaracteristicas = new JLabel("Caracteristicas");
		lblCaracteristicas.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblCaracteristicas.setBounds(33, 173, 124, 35);
		contentPanel.add(lblCaracteristicas);
		{
			textCaracteristicas = new JTextField();
			textCaracteristicas.setColumns(10);
			textCaracteristicas.setBounds(178, 183, 341, 20);
			contentPanel.add(textCaracteristicas);
		}
		if (est == null) {
			btnBaja.setEnabled(false);
			btnModi.setEnabled(false);
		} else {
			btnAlta.setEnabled(false);
			textNombre.enable(false);
			CargarEstudio(est);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
// TODO Auto-generated method stub

		if (e.getSource().equals(btnAlta)) {
			altaEstudio();
		}
		if (e.getSource().equals(btnModi)) {
			modificado(estu);
		}
		if (e.getSource().equals(btnBaja)) {
			borrado(estu);
		}
		if (e.getSource().equals(btnVolver)) {
			volver();
		}

	}

	private void modificado(Estudio est) {
// TODO Auto-generated method stub
		String nombre = est.getNombre();
		if (validar()) {
			Estudio estu = new Estudio();
			estu.setFechaFun(LocalDate.parse(textFecha.getText()));
			estu.setCaracteristica(textCaracteristicas.getText());

			dao.modificarEstudio(estu, nombre);
			limpiar();

		}

	}

	private void borrado(Estudio est) {
// TODO Auto-generated method stub
		String nombre = est.getNombre();

		dao.borradoEstudio(nombre);
		limpiar();
		JOptionPane.showMessageDialog(null, "Proveedor borrado correctamente", "Borrado",
				JOptionPane.INFORMATION_MESSAGE);
		volver();
	}

	public boolean validar() {
		boolean bien = false;
		if (textNombre.getText().equalsIgnoreCase(null) && textFecha.getText().equalsIgnoreCase(null)
				&& textCaracteristicas.getText().equalsIgnoreCase(null)) {

		} else {
			bien = true;
		}
		return bien;

	}

	private void altaEstudio() {
// TODO Auto-generated method stub
		if (validar()) {

			Estudio est = new Estudio();
// pro.setNif(textNif.getText());
			est.setNombre(textNombre.getText());
			DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			est.setFechaFun(LocalDate.parse(textFecha.getText(), formateador));
			est.setCaracteristica(textCaracteristicas.getText());

			dao.altaEstudios(est);
			JOptionPane.showMessageDialog(null, "Alta hecha correctamente", "Alta", JOptionPane.INFORMATION_MESSAGE);
			limpiar();
		} else {
			JOptionPane.showMessageDialog(null, "No puedes dejar parametros vacios", "Error",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	private void limpiar() {
// TODO Auto-generated method stub
		textNombre.setText(null);
		textFecha.setText(null);
		textCaracteristicas.setText(null);
	}

	private void volver() {
		this.dispose();
	}

	

	public void CargarEstudio(Estudio est) {
		textNombre.setText(est.getNombre());
		textFecha.setText(est.getFechaFun().toString());
		textCaracteristicas.setText(est.getCaracteristica());

	}
}
