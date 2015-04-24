package Vista;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class VistaProForm extends JPanel {
	private JTextField nombre;
	private JTextField presupuesto;

	public VistaProForm() {
		setLayout(null);

		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(35, 55, 80, 14);
		lblNombre.setVerticalAlignment(SwingConstants.TOP);
		lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblNombre);

		nombre = new JTextField();
		nombre.setBounds(125, 52, 100, 20);
		add(nombre);
		nombre.setHorizontalAlignment(SwingConstants.LEFT);
		nombre.setColumns(10);

		JPanel nombreP = new JPanel();
		nombreP.setBounds(166, 16, 10, 0);
		add(nombreP);
		FlowLayout fl_nombreP = new FlowLayout(FlowLayout.LEFT, 5, 0);
		nombreP.setLayout(fl_nombreP);

		JLabel lblPresupuesto = new JLabel("Presupuesto: ");
		lblPresupuesto.setBounds(35, 110, 80, 14);
		lblPresupuesto.setVerticalAlignment(SwingConstants.TOP);
		lblPresupuesto.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblPresupuesto);

		presupuesto = new JTextField();
		presupuesto.setBounds(125, 107, 100, 20);
		add(presupuesto);
		presupuesto.setColumns(10);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(25, 205, 100, 23);
		add(btnConfirmar);

		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLimpiar.setBounds(135, 205, 100, 23);
		add(btnLimpiar);

		setBackground(Color.gray);

	}

}
