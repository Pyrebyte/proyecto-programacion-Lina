package vista;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class VistaPro extends JPanel {
	protected JPanel form;
	public JTextField nombre;
	public JTextField presupuesto;

	// empieza VistaLista:
	protected JPanel lista;
	@SuppressWarnings("rawtypes")
	public JList list;
	public DefaultListModel listModel;

	public JButton info;
	public JButton eliminar;
	public JButton confirm;
	public JButton limpiar;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public VistaPro() {
		setLayout(new GridLayout(0, 2));
		form = new JPanel(null);

		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(35, 55, 80, 14);
		lblNombre.setVerticalAlignment(SwingConstants.TOP);
		lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
		form.add(lblNombre);

		nombre = new JTextField();
		nombre.setBounds(125, 52, 100, 20);
		form.add(nombre);
		nombre.setHorizontalAlignment(SwingConstants.LEFT);
		nombre.setColumns(10);

		JPanel nombreP = new JPanel();
		nombreP.setBounds(166, 16, 10, 0);
		form.add(nombreP);
		FlowLayout fl_nombreP = new FlowLayout(FlowLayout.LEFT, 5, 0);
		nombreP.setLayout(fl_nombreP);

		JLabel lblPresupuesto = new JLabel("Presupuesto: ");
		lblPresupuesto.setBounds(35, 110, 80, 14);
		lblPresupuesto.setVerticalAlignment(SwingConstants.TOP);
		lblPresupuesto.setHorizontalAlignment(SwingConstants.LEFT);
		form.add(lblPresupuesto);

		presupuesto = new JTextField();
		presupuesto.setBounds(125, 107, 100, 20);
		form.add(presupuesto);
		presupuesto.setColumns(10);

		confirm = new JButton("Confirmar");
		confirm.setBounds(25, 205, 100, 23);
		form.add(confirm);

		limpiar = new JButton("Limpiar");
		limpiar.setBounds(135, 205, 100, 23);
		form.add(limpiar);

		form.setBackground(Color.gray);

		// empieza listavista:
		lista = new JPanel(null);

		JPanel panel = new JPanel();
		panel.setBounds(45, 11, 180, 260);
		lista.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		listModel = new DefaultListModel();
		list = new JList(listModel);
		panel.add(list);

		info = new JButton("+ INFO");
		info.setBounds(45, 295, 80, 23);
		lista.add(info);

		eliminar = new JButton("Eliminar");
		eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		eliminar.setBounds(145, 295, 80, 23);
		lista.add(eliminar);

		lista.setBackground(Color.gray);

		add(form);
		add(lista);

	}

	public void limpiar(){
		this.nombre.setText("");
		this.presupuesto.setText("");
	}
	
	public void registrarControlador(ActionListener e){
		confirm.addActionListener(e);
		limpiar.addActionListener(e);
		info.addActionListener(e);
		eliminar.addActionListener(e);
	}
}
